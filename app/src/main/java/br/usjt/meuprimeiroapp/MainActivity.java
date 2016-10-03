package br.usjt.meuprimeiroapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private EditText extrato;
    public final static String CHAVE = "br.usjt.chave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extrato = (EditText) findViewById(R.id.busca_extrato);
    }


    public void consultarExtrato(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String chave = extrato.getText().toString();


        intent.putExtra(CHAVE, chave);
        startActivity(intent);
    }
}
