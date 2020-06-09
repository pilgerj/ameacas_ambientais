package br.feevale.ameacasambientais;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView listAmeacas;
    AmeacaDB db;
    AmeacasListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new AmeacaDB(getBaseContext());
        adapter = new AmeacasListAdapter(getBaseContext(), db);

        listAmeacas = (ListView) findViewById(R.id.listAmeacas);
        listAmeacas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                db.deletarAmeaca((int) l);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        listAmeacas.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent itEdit = new Intent(this, EditAmeaca.class);
                itEdit.putExtra("ID", i);
                startActivity(itEdit);
            }
        });
    }

    public void novaAmeaca(View v){
        Intent it = new Intent(this, NovaAmeaca.class);
        //it.putExtra("QUESTION", txt);
        startActivity(it);

    }




}
