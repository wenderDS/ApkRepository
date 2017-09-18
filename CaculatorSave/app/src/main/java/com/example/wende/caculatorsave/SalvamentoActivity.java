package com.example.wende.caculatorsave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SalvamentoActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnFechar;
    private ListView lsvCalcula;
    private ArrayAdapter<String> arraySalvos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvamento);

        btnFechar = (Button) findViewById(R.id.btnFechar);
        lsvCalcula = (ListView) findViewById(R.id.listCalcula);

        btnFechar.setOnClickListener(this);

        arraySalvos = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        lsvCalcula.setAdapter(arraySalvos);

        Bundle bundle = getIntent().getExtras();

        ArrayList<String> calsalvos = bundle.getStringArrayList("conteudo");
        arraySalvos.addAll(calsalvos);
    }

    @Override
    public void onClick(View view) {
        if (view == btnFechar){
            finish();
        }
    }
}
