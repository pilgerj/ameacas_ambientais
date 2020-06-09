package br.feevale.ameacasambientais;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by 0197359 on 01/11/2018.
 */

public class NovaAmeaca extends Activity{

    EditText nomeAmeaca;
    EditText endAmeaca;
    EditText bairroAmeaca;
    EditText impAmeaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_ameaca);

        nomeAmeaca = (EditText) findViewById(R.id.nomeAmeaca);
        endAmeaca = (EditText) findViewById(R.id.endAmeaca);
        bairroAmeaca = (EditText) findViewById(R.id.bairroAmeaca);
        impAmeaca = (EditText) findViewById(R.id.impAmeaca);
    }


    private void salvaAmeaca(View v){
        Intent it = new Intent(this, MainActivity.class);


        finish();

    }
}
