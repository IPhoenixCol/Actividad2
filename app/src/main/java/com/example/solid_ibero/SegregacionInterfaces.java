package com.example.solid_ibero;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SegregacionInterfaces extends AppCompatActivity {

    LinearLayout ly1, ly2;
    ImageView img1, img2, img3, img4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segregacion_interfaces);
        ly1 = findViewById(R.id.ly1);
        ly2 = findViewById(R.id.ly2);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
    }


    public void loro(View v){
        ly1.setVisibility(View.VISIBLE);
        Loro loro = new Loro();
        loro.comer(img1);
        loro.volar(img2);

        ly2.setVisibility(View.GONE);
        img3.setVisibility(View.GONE);
        img4.setVisibility(View.GONE);

    }

    public void pinguino(View v){

        ly2.setVisibility(View.VISIBLE);
        Pinguino pinguino = new Pinguino();
        pinguino.comer(img3);
        pinguino.nadar(img4);

        ly1.setVisibility(View.GONE);
        img1.setVisibility(View.GONE);
        img2.setVisibility(View.GONE);

    }


    interface IAve {
        void comer(ImageView i);
    }
    interface IAveVoladora {
        void volar(ImageView i);
    }

    interface IAveNadadora {
        void nadar(ImageView i);
    }

    class Loro implements IAve, IAveVoladora{

        @Override
        public void volar(ImageView i) {
            i.setVisibility(View.VISIBLE);
        }

        @Override
        public void comer(ImageView i) {
            i.setVisibility(View.VISIBLE);
        }
    }

    class Pinguino implements IAve, IAveNadadora{

        @Override
        public void nadar(ImageView i) {
            i.setVisibility(View.VISIBLE);
        }

        @Override
        public void comer(ImageView i) {
            i.setVisibility(View.VISIBLE);
        }
    }
}
