package com.example.android.calzado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private EditText cajaCantidad;
    private TextView valor,resultado;
    private Spinner comboTipo,comboSexo,comboMarca;
    private String[] opciones_tipo,opciones_sexo,opciones_marca;
    private ArrayAdapter adapter_tipo,adapter_sexo,adapter_marca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        valor=(TextView)findViewById(R.id.txtValor);
        resultado=(TextView)findViewById(R.id.txtResultado);
        cajaCantidad=(EditText)findViewById(R.id.txtCantidad);
        comboTipo=(Spinner)findViewById(R.id.cmdTipoZapato);
        comboSexo=(Spinner)findViewById(R.id.cmdSexo);
        comboMarca=(Spinner)findViewById(R.id.cmdMarca);
        opciones_tipo = this.getResources().getStringArray(R.array.opciones_tipo);
        adapter_tipo = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opciones_tipo);
        comboTipo.setAdapter(adapter_tipo);
        opciones_sexo = this.getResources().getStringArray(R.array.opciones_sexo);
        adapter_sexo = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opciones_sexo);
        comboSexo.setAdapter(adapter_sexo);
        opciones_marca = this.getResources().getStringArray(R.array.opciones_marca);
        adapter_marca = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opciones_marca);
        comboMarca.setAdapter(adapter_marca);
    }

    public void calcular(View v){
        if (validar()){
            int cant,op_tipo,op_sexo,op_marca,res=0,unidad=0;
            cant=Integer.parseInt(cajaCantidad.getText().toString());
            op_tipo=comboTipo.getSelectedItemPosition();
            op_sexo=comboSexo.getSelectedItemPosition();
            op_marca=comboMarca.getSelectedItemPosition();

            if (op_tipo==0 && op_sexo==0 && op_marca==0){
                unidad=120000;
                res = cant*unidad;
            }
            if (op_tipo==0 && op_sexo==0 && op_marca==1){
                unidad=140000;
                res = cant*unidad;
            }
            if (op_tipo==0 && op_sexo==0 && op_marca==2){
                unidad=130000;
                res = cant*unidad;
            }
            if (op_tipo==1 && op_sexo==0 && op_marca==0){
                unidad=50000;
                res = cant*unidad;
            }
            if (op_tipo==1 && op_sexo==0 && op_marca==1){
                unidad=80000;
                res = cant*unidad;
            }
            if (op_tipo==1 && op_sexo==0 && op_marca==2){
                unidad=100000;
                res = cant*unidad;
            }
            if (op_tipo==0 && op_sexo==1 && op_marca==0){
                unidad=100000;
                res = cant*unidad;
            }
            if (op_tipo==0 && op_sexo==1 && op_marca==1){
                unidad=130000;
                res = cant*unidad;
            }
            if (op_tipo==0 && op_sexo==1 && op_marca==2){
                unidad=110000;
                res = cant*unidad;
            }
            if (op_tipo==1 && op_sexo==1 && op_marca==0){
                unidad=60000;
                res = cant*unidad;
            }
            if (op_tipo==1 && op_sexo==1 && op_marca==1){
                unidad=70000;
                res = cant*unidad;
            }
            if (op_tipo==1 && op_sexo==1 && op_marca==2){
                unidad=120000;
                res = cant*unidad;
            }
            valor.setText(String.valueOf(unidad));
            resultado.setText(String.valueOf(res));
        }
    }

    public boolean validar(){
        if(cajaCantidad.getText().toString().isEmpty()){
            cajaCantidad.requestFocus();
            cajaCantidad.setError(this.getResources().getString(R.string.error_cantidad));
            return false;
        }
        if (Integer.parseInt(cajaCantidad.getText().toString())==0){
            cajaCantidad.requestFocus();
            cajaCantidad.setError(this.getResources().getString(R.string.error_zero));
            return false;
        }
        if (Integer.parseInt(cajaCantidad.getText().toString())>9999){
            cajaCantidad.requestFocus();
            cajaCantidad.setError(this.getResources().getString(R.string.error_exagerado));
            return false;
        }
        return true;
    }

    public void borrar(View v){
        cajaCantidad.setText("");
        cajaCantidad.requestFocus();
    }
}
