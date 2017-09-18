package com.example.wende.caculatorsave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityCalcula extends AppCompatActivity implements View.OnClickListener{
    private EditText edtNumero1;
    private EditText edtNumero2;
    private TextView txtResult;
    private Button btnSoma;
    private Button btnSubtrair;
    private Button btnDividir;
    private Button btnMultiplicar;
    private ImageButton btnExecute;
    private Button btnSalvar;
    private String operacao;

    private ArrayList<String> arraySalvos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calcula);

        edtNumero1 = (EditText) findViewById(R.id.edtNum1);
        edtNumero2 = (EditText) findViewById(R.id.edtNum2);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnSoma = (Button) findViewById(R.id.btnSum);
        btnMultiplicar = (Button) findViewById(R.id.btnMult);
        btnDividir = (Button) findViewById(R.id.btnDiv);
        btnSubtrair = (Button) findViewById(R.id.btnSub);
        btnExecute = (ImageButton) findViewById(R.id.btnExecutar);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(this);

        arraySalvos = new ArrayList<String>();

        btnMultiplicar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                operacao = "multiplicar";
            }
        });

        btnSoma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                operacao = "somar";
            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                operacao = "subtrair";
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                operacao = "dividir";
            }
        });


        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                double num1 = Double.parseDouble(edtNumero1.getText().toString());
                double num2 = Double.parseDouble(edtNumero2.getText().toString());

                if(edtNumero1.getText().toString().equals("")||
                        edtNumero2.getText().toString().equals("")||
                        (operacao == null)){
                    alert();
                }else if (operacao == "somar"){
                    Double res = num1 + num2;
                    txtResult.setText(res.toString());
                }else if (operacao == "subtrair"){
                    Double res = num1 - num2;
                    txtResult.setText(res.toString());
                }else if (operacao == "multiplicar"){
                    Double res = num1 * num2;
                    txtResult.setText(res.toString());
                }else if (operacao == "dividir"){
                    Double res = num1 / num2;
                    txtResult.setText(res.toString());
                }
            }
        });

    }

    public void alert(){
        Toast toast = Toast.makeText(this,
                "O campo de numeros ou operacao está em branco",
                Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onClick(View view) {
        if(view == btnSalvar){
            salvarCalculo();
        }
    }

    public void salvarCalculo(){
        String calsalvos = txtResult.getText().toString();
        arraySalvos.add(calsalvos);

        Intent it = new Intent(this, SalvamentoActivity.class);

        it.putExtra("conteudo", arraySalvos);

        startActivity(it);
    }
}
