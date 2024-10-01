package com.example.calculodesalario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgopcoes;
    Button btcalcular;
    EditText edtsalario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtsalario = (EditText) findViewById(R.id.edtsalario);
        rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);
        btcalcular = (Button) findViewById(R.id.btncalcular);
        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                double salario = Double.parseDouble(edtsalario.getText().toString());
                int op = rgopcoes.getCheckedRadioButtonId();
                double novo_salario = 0;
                if (op == R.id.rb40)
                    novo_salario = salario + (salario * 0.4);

                else if (op == R.id.rb45)
                    novo_salario = salario + (salario * 0.45);
                else
                    novo_salario = salario + (salario * 0.5);
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Novo Salário");
                dialogo.setMessage("Seu novo salário é: R$"
                +String.valueOf(novo_salario));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}