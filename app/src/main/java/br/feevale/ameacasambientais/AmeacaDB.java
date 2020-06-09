package br.feevale.ameacasambientais;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class AmeacaDB {
    private static final String NOME_BANCO = "ameacas.db";
    private static final String TAB_AMEACAS = "AMEACAS";
    private static final int VERSAO_BANCO = 10;

    private static final String COL_ID = "ID";
    private static final String COL_NOME = "NOME";
    private static final String COL_END = "ENDE";
    private static final String COL_BAIRRO = "BAIRRO";
    private static final String COL_IMP = "IMP";

    private static final String SQL_TAB_AMEACAS = "create table " + TAB_AMEACAS +
            "(" + COL_ID + " integer primary key autoincrement," +
            COL_NOME + " text not null," +
            COL_END + " text not null," +
            COL_BAIRRO + " text not null," +
            COL_IMP + " text not null)";

    private ameacasDBHelper dbHelper;
    private SQLiteDatabase db;
    private Context ctx;

    public AmeacaDB(Context ctx){
        dbHelper = new ameacasDBHelper(ctx, NOME_BANCO, null, VERSAO_BANCO);
        this.ctx = ctx;
        db = dbHelper.getWritableDatabase();
    }

    public void abrir(){
        db = dbHelper.getWritableDatabase();
    }

    public void fechar(){
        db.close();
    }

    public void adicionarUsuario(Ameaca a){
        ContentValues values = new ContentValues();
        values.put(COL_NOME, a.getNome());
        values.put(COL_END, a.getEndereco());
        values.put(COL_BAIRRO, a.getBairro());
        values.put(COL_IMP, a.getImpacto());
        db.insert(TAB_AMEACAS, null, values);
    }

    public List<Ameaca> recuperarAmeacas(){
        List<Ameaca> ameacas = new ArrayList<Ameaca>();
        Ameaca ameaca;
        String[] colunas = {COL_ID, COL_NOME, COL_END, COL_BAIRRO, COL_IMP};
        Cursor cursor = db.query(TAB_AMEACAS, colunas,null,null,null,null,COL_ID);
        if(cursor.getCount() == 0){
            return ameacas;
        }

        cursor.moveToFirst();
        do{
            ameaca = new Ameaca();
            ameaca.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
            ameaca.setNome(cursor.getString(cursor.getColumnIndex(COL_NOME)));
            ameaca.setEndereco(cursor.getString(cursor.getColumnIndex(COL_END)));
            ameaca.setBairro(cursor.getString(cursor.getColumnIndex(COL_BAIRRO)));
            ameaca.setImpacto(cursor.getInt(cursor.getColumnIndex(COL_IMP)));
            ameacas.add(ameaca);
        }while(cursor.moveToNext());
        return ameacas;
    }

    public Ameaca buscaAmeaca(Integer id){

        Ameaca a;
        String[] colunas = {COL_ID, COL_NOME, COL_END, COL_BAIRRO, COL_IMP};
        String selection = COL_ID;
        String [] arg = {id.toString()};
        Cursor cursor = db.query(TAB_AMEACAS, colunas,selection,arg,null,null,COL_ID);

        if(cursor.getCount() > 0){
            a = new Ameaca();
            a.setNome(cursor.getString(0));
            a.setEndereco(cursor.getString(1));
            a.setBairro(cursor.getString(2));
            a.setImpacto(Integer.getInteger(cursor.getString(3)));
        } else {
            a = null;
        }

        cursor.close();
        db.close();

        return a;
    }

    public Integer deletarAmeaca(int id){
        return db.delete(TAB_AMEACAS, COL_ID + "=" + id, null);
    }
    public Integer deletarAmeaca(){
        return db.delete(TAB_AMEACAS, null, null);
    }

    private static class ameacasDBHelper extends SQLiteOpenHelper {

        public ameacasDBHelper(Context ctx, String nome, SQLiteDatabase.CursorFactory factory, int versao){
            super(ctx, nome, factory, versao);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_TAB_AMEACAS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TAB_AMEACAS);
            onCreate(db);
        }
    }
}
