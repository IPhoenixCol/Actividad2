package com.example.solid_ibero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SustitucionLiskov extends AppCompatActivity {


    private ArrayList marcas;
    private ArrayAdapter adaptador1;
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sustitucion_liskov);


        Coche[] arrayCoches = {
                new Renault(),
                new Audi(),
                new Mercedes()
        };

        marcas=new ArrayList();
        for (Coche coche : arrayCoches) {

            marcas.add(coche.getMarcaCoche()+ "  $" + coche.precioMedioCoche() + " Numero de sillas : " + coche.numAsientos() );
        }
        adaptador1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,marcas);
        lv1=findViewById(R.id.list3);
        lv1.setAdapter(adaptador1);
    }


    abstract class Coche {
        abstract String getMarcaCoche();
        abstract int precioMedioCoche();
        abstract int numAsientos();
    }

    class Renault extends Coche {
        String getMarcaCoche() { return "Renault";}
        int precioMedioCoche() { return 18000; }
        int numAsientos() { return 5; }
    }

    class Audi extends Coche {
        String getMarcaCoche() { return "Audi";}
        int precioMedioCoche() { return 25000; }
        int numAsientos() { return 5; }
    }

    class Mercedes extends Coche {
        String getMarcaCoche() { return "Mercedes";}
        int precioMedioCoche() { return 27000; }
        int numAsientos() { return 5; }
    }

}
