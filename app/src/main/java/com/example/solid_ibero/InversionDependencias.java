package com.example.solid_ibero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class InversionDependencias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversion_dependencias);
    }


    public void aDatos(View v){

       Conexion conexion = null;
       AccesoADatos acceso = new AccesoADatos(conexion);
       acceso.getDatos();

    }

    public void dService(View v){

        DatabaseService databaseService = null;
        databaseService.getDatos();
        databaseService.setDatos();

    }

    public void aService(View v){

        APIService apiService = null;
        apiService.getDatos();
        apiService.setDatos();

    }


    interface Conexion {
        void getDatos();
        void setDatos();
    }

    class AccesoADatos {

        private Conexion conexion;

        public AccesoADatos(Conexion conexion){
            this.conexion = conexion;
        }

        void getDatos(){
            conexion.getDatos();
            Toast.makeText(InversionDependencias.this,"getDatos AccesoADatos",Toast.LENGTH_LONG).show();
        }
    }

    class DatabaseService implements Conexion {

        @Override
        public void getDatos() {

            Toast.makeText(InversionDependencias.this,"getdatos Dataservice",Toast.LENGTH_LONG).show();

        }

        @Override
        public void setDatos() {

            Toast.makeText(InversionDependencias.this,"setDatos Dataservice",Toast.LENGTH_LONG).show();
        }

    }


    class APIService implements Conexion{

        @Override
        public void getDatos() {

            Toast.makeText(InversionDependencias.this,"getDatos APIService",Toast.LENGTH_LONG).show();
        }

        @Override
        public void setDatos() {

            Toast.makeText(InversionDependencias.this,"setDatos APIService",Toast.LENGTH_LONG).show();

        }
    }


 }

