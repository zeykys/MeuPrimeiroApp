package br.usjt.meuprimeiroapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String EXTRATO = "br.usjt.extrato";
    ArrayList<String> lista;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        atividade = this;
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.CHAVE);
        lista = buscarExtrato(message);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }

    public ArrayList<String> buscarExtrato(String chave) {
        ArrayList<String> lista = geraLista();
        if (chave == null || chave.length() == 0) {
            return lista;

        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for (String nome : lista) {
                if (nome.toUpperCase().contains(chave.toUpperCase())) {
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }

    public ArrayList<String> geraLista() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("01/06/2016");
        lista.add("02/07/2016");
        lista.add("03/08/2016");
        lista.add("04/09/2016");
        lista.add("05/10/2016");
        return lista;
    }


}
