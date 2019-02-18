package com.example.alfirex.desarrollo_de_interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LinearLayout extends AppCompatActivity {
    TextView txtRojo;
    TextView txtVerde;
    TextView txtAmarillo;
    TextView txtAzul;

    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        // Obtenemos la referencia de los TEXTVIEWS
        txtRojo = (TextView) findViewById(R.id.txtRojo);
        txtVerde = (TextView) findViewById(R.id.txtVerde);
        txtAmarillo = (TextView) findViewById(R.id.txtAmarillo);
        txtAzul = (TextView) findViewById(R.id.txtAzul);

        // LE INDICAMOS QUE VA TENER UN CONTEXT MENU
        registerForContextMenu(txtRojo);
        registerForContextMenu(txtVerde);
        registerForContextMenu(txtAmarillo);
        registerForContextMenu(txtAzul);
    }

    /**
     * Añadimos el menu
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        this.v = v;
                MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    /**
     * Le indicamos que accion tendra en caso que sea seleccionado
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String color = null;
        String posicion = null;
               Log.d("Pru", String.valueOf(item.getItemId()));
        switch (item.getItemId()){
            case R.id.itemColor:
                switch (v.getId()) {
                    case R.id.txtRojo:
                        color = "rojo";
                        break;
                    case R.id.txtVerde:
                        color = "verde";
                        break;
                    case R.id.txtAmarillo:
                        color = "amarillo";
                        break;
                    case R.id.txtAzul:
                        color = "azul";
                        break;
                }
                Toast.makeText(getApplicationContext(),"Color: " + color, Toast.LENGTH_SHORT ).show();
                return true;

            case R.id.itemPosicion:
                switch (v.getId()) {
                    case R.id.txtRojo:
                        posicion = "izquierda";
                        break;
                    case R.id.txtVerde:
                        posicion = "centro arriba";
                        break;
                    case R.id.txtAmarillo:
                        posicion = "centro abajo";
                        break;
                    case R.id.txtAzul:
                        posicion = "derecha";
                        break;
                }
                Toast.makeText(getApplicationContext(),"Posicion: " + posicion, Toast.LENGTH_SHORT ).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }

    // OPTION MENU

    /**
     * Implementamos el OPTION MENU
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return  true;
    }

    /**
     * Seleccionamos las acciones segun lo que seleccionemos
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.id_perfil){
            Toast.makeText(this,"Le has dado click a Perfil",Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.id_setting){
            Toast.makeText(this,"Le has dado click a Configuracion",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
