package br.feevale.ameacasambientais;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by 0197359 on 01/11/2018.
 */

public class EditAmeaca extends Activity {
    EditText editNome;
    EditText editEnd;
    EditText editBairro;
    EditText editImpacto;
    AmeacaDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_ameaca);

        db = new AmeacaDB(getBaseContext());


        Intent it = getIntent();
        it.getIntExtra("ID", -1);
        Ameaca a = db.buscaAmeaca(it.getIntExtra("ID", -1));

        editNome = (EditText) findViewById(R.id.editNome);
        editEnd = (EditText) findViewById(R.id.editEnd);
        editBairro = (EditText) findViewById(R.id.editBairro);
        editImpacto = (EditText) findViewById(R.id.editImpacto);

        editNome.setText(a.getNome());
        editEnd.setText(a.getEndereco());
        editBairro.setText(a.getBairro());
        editImpacto.setText(a.getImpacto());

    }


    private void voltarPrimeiro(View v){
        finish();
    }
}
