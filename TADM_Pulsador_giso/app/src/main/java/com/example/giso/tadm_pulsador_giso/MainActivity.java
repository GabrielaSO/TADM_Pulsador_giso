package com.example.giso.tadm_pulsador_giso;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView tiempo,aleatorio;
    Button inicio;
    float al, counter;
    CountDownTimer timer;
    //Random random=new Random();
    DecimalFormat decimal = new DecimalFormat("#.0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiempo=findViewById(R.id.tiempo);
        inicio=findViewById(R.id.btnInicio);
        aleatorio=findViewById(R.id.aleatorio);

        //Al abrise la aplicacion el timer corre y genera aleatorio
        //generaAleatorio();

        //al= (float) (random.nextFloat()*(3.0-1.0)+1.0);
        al=(float) (Math.random()*(3.0-1.0)+1.0);
        aleatorio.setText(""+decimal.format(al));


        timer = new CountDownTimer(1000, 300) {
            public void onTick(long milisUntilFinished) {
                counter = (float)(counter+0.1);
                tiempo.setText(""+decimal.format(counter));
                //counter++;
                if (counter>2.9) counter = (float) 1.0;
            }

            public void onFinish() {
                timer.start();
            }
        };
        timer.start();

            //Generar Num Aleatorio
            inicio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    float a = Float.parseFloat(decimal.format(counter));
                    float b = Float.parseFloat(decimal.format(al));
                    timer.cancel();
                    //comparacion de Floats
                    if (a==b){
                        Toast.makeText(MainActivity.this, "Ganaste!!", Toast.LENGTH_SHORT).show();

                        timer.start();
                        al=(float) (Math.random()*3);
                        aleatorio.setText(""+decimal.format(al));
                    }else{
                        Toast.makeText(MainActivity.this, "Perdiste :(", Toast.LENGTH_SHORT).show();

                        //vuelve a iniciar
                        timer.start();
                        al=(float) (Math.random()*(3.0-1.0)+1.0);
                        aleatorio.setText(""+decimal.format(al));
                    }
                }
            });

    }

   // public void generaAleatorio(){

}
