package com.example.android.calzado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Principal extends AppCompatActivity {
    private EditText cajaCantidad;
    private Spinner comboTipo,comboSexo,comboMarca;
    private String[] opciones_tipo,opciones_sexo,opciones_marca;
    private ArrayAdapter adapter_tipo,adapter_sexo,adapter_marca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

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
        int cant,op_tipo,res;
        cant=Integer.parseInt(cajaCantidad.getText().toString());
        op_tipo=comboTipo.getSelectedItemPosition();
    }
}
