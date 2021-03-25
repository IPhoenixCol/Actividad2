package com.example.solid_ibero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ResponsabilidadUnica extends AppCompatActivity {

    private ArrayList marcas;
    private ArrayAdapter adaptador1;
    private ListView lv1;
    private EditText et1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responsabilidad_unica);

        Coche coche1 = new Coche("Mazda");
        Coche coche2 = new Coche("Chevroleet");
        Coche coche3 = new Coche("Daewoo");
        Coche coche4 = new Coche("Ferrari");
        Coche coche5 = new Coche("Porshe");

        marcas=new ArrayList();
        marcas.add(coche1.getMarca());
        marcas.add(coche2.getMarca());
        marcas.add(coche3.getMarca());
        marcas.add(coche4.getMarca());
        marcas.add(coche5.getMarca());
        adaptador1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,marcas);
        lv1=findViewById(R.id.list1);
        lv1.setAdapter(adaptador1);

        et1=findViewById(R.id.editText);



        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ResponsabilidadUnica.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina esta marca ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        marcas.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });

    }

    public void agregar(View v) {
        Coche cochex = new Coche(et1.getText().toString());
        marcas.add(cochex.getMarca());
        adaptador1.notifyDataSetChanged();
        et1.setText("");
        new CocheDB().guardarCocheDB(cochex);
    }


   public class Coche {

        private String Marca ;

        Coche(String Marca){ this.Marca = Marca; }

        public String getMarca (){

            return Coche.this.Marca;
        }
    }



   public  class CocheDB {


        public void  guardarCocheDB(Coche coche){

            Toast.makeText(ResponsabilidadUnica.this,"Coche de marca: "+ coche.getMarca() + " .... Guardado",Toast.LENGTH_LONG).show();

        }
        public void eliminarCocheDB(Coche coche){

            Toast.makeText(ResponsabilidadUnica.this,"Coche de marca: "+ coche.getMarca() + " .... Guardado",Toast.LENGTH_LONG).show();

        }
    }




}
