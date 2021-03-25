package com.example.solid_ibero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AbiertoCerrado extends AppCompatActivity {

    private ArrayList marcas;
    private ArrayAdapter adaptador1;
    private ListView lv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abierto_cerrado);




        Coche[] arrayCoches = {
                new Renault(),
                new Audi(),
                new Mercedes()
        };

        marcas=new ArrayList();
        for (Coche coche : arrayCoches) {

            marcas.add(coche.getMarcaCoche()+ "=" + coche.precioMedioCoche());
        }
        adaptador1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,marcas);
        lv1=findViewById(R.id.list2);
        lv1.setAdapter(adaptador1);


    }


    abstract class Coche {
        abstract String getMarcaCoche();
        abstract int precioMedioCoche();
    }

    class Renault extends Coche {
        String getMarcaCoche() { return "Renault";}
        int precioMedioCoche() { return 18000; }
    }

    class Audi extends Coche {
        String getMarcaCoche() { return "Audi";}
        int precioMedioCoche() { return 25000; }
    }

    class Mercedes extends Coche {
        String getMarcaCoche() { return "Mercedes";}
        int precioMedioCoche() { return 27000; }
    }




}
