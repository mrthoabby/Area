package com.example.area;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText ladoUno,ladoDos,baseUno,alturaUno;
    RadioButton cuadrado,triangulo;
    TextView resultado;
    RadioGroup selectOperation;
    Button btnCalcule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind with XML
        ladoUno = findViewById(R.id.valorLadoUno);
        ladoDos = findViewById(R.id.valorLadoDos);
        baseUno = findViewById(R.id.base);
        alturaUno = findViewById(R.id.altura);
        cuadrado = findViewById(R.id.radioAreaCuadrado);
        triangulo = findViewById(R.id.radioAreaTriangulo);
        resultado = findViewById(R.id.resultado);
        selectOperation = findViewById(R.id.selectorOperation);
        btnCalcule = findViewById(R.id.btn_calcular);


        cuadrado.setChecked(true);
        baseUno.setEnabled(false);
        alturaUno.setEnabled(false);
        ladoDos.setEnabled(true);
        ladoUno.setEnabled(true);


        btnCalcule.setOnClickListener(this);

        selectOperation.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton checkedRadioButton = group.findViewById(checkedId);
            boolean isChecked = checkedRadioButton.isChecked();
            if(isChecked){
                String textContent = String.valueOf(checkedRadioButton.getText());

                if(checkedId == R.id.radioAreaCuadrado){
                    baseUno.setEnabled(false);
                    alturaUno.setEnabled(false);
                    ladoDos.setEnabled(true);
                    ladoUno.setEnabled(true);
                    Toast.makeText(getApplicationContext(), textContent, Toast.LENGTH_SHORT).show();
                }else{
                    baseUno.setEnabled(true);
                    alturaUno.setEnabled(true);
                    ladoDos.setEnabled(false);
                    ladoUno.setEnabled(false);
                }

            }
        });
    }



    public void calcularAreas(View view){
        if (cuadrado.isChecked()){
            resultado.setText(String.valueOf(getNumberFromEditText(ladoUno)*getNumberFromEditText(ladoDos)));

        }
        if(triangulo.isChecked()){
            resultado.setText(String.valueOf((getNumberFromEditText(baseUno)*getNumberFromEditText(alturaUno))/2));
        }
    }


    private Double getNumberFromEditText(EditText view){
       return Double.parseDouble(view.getText().toString());
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btnCalcule.getId()){
            calcularAreas(view);
        }
    }
}