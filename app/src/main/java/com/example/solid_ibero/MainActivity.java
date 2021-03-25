package com.example.solid_ibero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void rUnica(View v){

        Intent cc = new Intent(MainActivity.this,ResponsabilidadUnica.class );
        MainActivity.this.startActivity(cc);

    }

    public void aCerrado(View v){

        Intent cc = new Intent(MainActivity.this,AbiertoCerrado.class );
        MainActivity.this.startActivity(cc);

    }

    public void sLiskov(View v){

        Intent cc = new Intent(MainActivity.this,SustitucionLiskov.class );
        MainActivity.this.startActivity(cc);

    }

    public void sInterfaz(View v){

        Intent cc = new Intent(MainActivity.this,SegregacionInterfaces.class );
        MainActivity.this.startActivity(cc);

    }

    public void iDependencias(View v){

        Intent cc = new Intent(MainActivity.this,InversionDependencias.class );
        MainActivity.this.startActivity(cc);

    }


    public void conclusion(View v){

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Conclusión Final");
        dialogo1.setMessage("Cada uno de los patrones o principios, en cualquier proyecto pueden ser usados en alguna parte de su derarrollo, ya que son patrones basicos para mantener el proceso de programacion en total orden. Tener la claridad del uso de cada principio, permitira tener una estructura de clases solida, lo que facilita futuras modificaciones");

        dialogo1.setCancelable(false);

        dialogo1.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        dialogo1.show();

    }
}
