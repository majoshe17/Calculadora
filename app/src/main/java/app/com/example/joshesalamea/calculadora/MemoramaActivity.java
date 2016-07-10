package app.com.example.joshesalamea.calculadora;

/**
 * Created by joshesalamea on 30/6/16.
 */

import android.content.ContentValues;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.material.joanbarroso.flipper.CoolImageFlipper;

import app.com.example.joshesalamea.calculadora.database.AplicacionDBHelper;


public class MemoramaActivity extends BaseActivity {
    private final Handler handler =new Handler();
    Integer resultado=0;
    CoolImageFlipper flipp;
    AplicacionDBHelper appHelper;

    Drawable turn0;
    Drawable turn1;
    Drawable turn2;
    Drawable turn3;
    Drawable turn4;
    Drawable turn5;
    Drawable turn6;
    Drawable turn7;
    Drawable turn8;
    Drawable turn9;
    Drawable turn10;
    Drawable cara1;
    ImageButton boton1;
    Integer contador =0;

    private boolean touchActivo =true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appHelper = new AplicacionDBHelper(getApplicationContext());
        setContentView(R.layout.activity_memorama);
        setTitle("Memorama");
        flipp= new CoolImageFlipper(getApplicationContext());

        buscarimagenes();





        View.OnClickListener lis = new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                ImageButton imagenes1 = (ImageButton) findViewById(R.id.ima1);
                ImageButton imagenes2 = (ImageButton) findViewById(R.id.ima2);
                ImageButton imagenes3 = (ImageButton) findViewById(R.id.ima3);
                ImageButton imagenes4 = (ImageButton) findViewById(R.id.ima4);
                ImageButton imagenes5 = (ImageButton) findViewById(R.id.ima5);
                ImageButton imagenes6 = (ImageButton) findViewById(R.id.ima6);
                ImageButton imagenes7 = (ImageButton) findViewById(R.id.ima7);
                ImageButton imagenes8 = (ImageButton) findViewById(R.id.ima8);
                ImageButton imagenes9 = (ImageButton) findViewById(R.id.ima9);
                ImageButton imagenes10 = (ImageButton) findViewById(R.id.ima10);
                ImageButton imagenes11 = (ImageButton) findViewById(R.id.ima11);
                ImageButton imagenes12 = (ImageButton) findViewById(R.id.ima12);
                ImageButton imagenes13 = (ImageButton) findViewById(R.id.ima13);
                ImageButton imagenes14 = (ImageButton) findViewById(R.id.ima14);
                ImageButton imagenes15 = (ImageButton) findViewById(R.id.ima15);
                ImageButton imagenes16 = (ImageButton) findViewById(R.id.ima16);




                Integer[] numero = new Integer[20];
                Boolean c1=false;
                switch (v.getId()) {
                    case R.id.ima1:

                        Control(turn1, imagenes1);





                        break;

                    case R.id.ima2:
                        Control(turn2, imagenes2);
                        break;

                    case R.id.ima3:

                        Control(turn9, imagenes3);


                        break;

                    case R.id.ima4:
                        Control(turn4, imagenes4);
                        break;

                    case R.id.ima5:
                        Control(turn5, imagenes5);
                        break;

                    case R.id.ima6:
                        Control(turn6, imagenes6);
                        break;

                    case R.id.ima7:
                        Control(turn2, imagenes7);

                        break;


                    case R.id.ima8:
                        Control(turn8, imagenes8);

                        break;

                    case R.id.ima9:
                        Control(turn1, imagenes9);
                        break;

                    case R.id.ima10:
                        Control(turn3, imagenes10);
                        break;

                    case R.id.ima11:
                        Control(turn3, imagenes11);

                        break;

                    case R.id.ima12:
                        Control(turn4, imagenes12);
                        break;

                    case R.id.ima13:
                        Control(turn5, imagenes13);
                        break;

                    case R.id.ima14:
                        Control(turn8, imagenes14);
                        break;

                    case R.id.ima15:
                        Control(turn9, imagenes15);

                        break;

                    case R.id.ima16:
                        Control(turn6, imagenes16);
                        break;







                }


            }
        };
        ImageButton ima1=(ImageButton) findViewById(R.id.ima1);
        ima1.setOnClickListener(lis);

        ImageButton ima2=(ImageButton) findViewById(R.id.ima2);
        ima2.setOnClickListener(lis);

        ImageButton ima3=(ImageButton) findViewById(R.id.ima3);
        ima3.setOnClickListener(lis);

        ImageButton ima4=(ImageButton) findViewById(R.id.ima4);
        ima4.setOnClickListener(lis);

        ImageButton ima5=(ImageButton) findViewById(R.id.ima5);
        ima5.setOnClickListener(lis);

        ImageButton ima6=(ImageButton) findViewById(R.id.ima6);
        ima6.setOnClickListener(lis);

        ImageButton ima7=(ImageButton) findViewById(R.id.ima7);
        ima7.setOnClickListener(lis);

        ImageButton ima8=(ImageButton) findViewById(R.id.ima8);
        ima8.setOnClickListener(lis);

        ImageButton ima9=(ImageButton) findViewById(R.id.ima9);
        ima9.setOnClickListener(lis);

        ImageButton ima10=(ImageButton) findViewById(R.id.ima10);
        ima10.setOnClickListener(lis);

        ImageButton ima11=(ImageButton) findViewById(R.id.ima11);
        ima11.setOnClickListener(lis);

        ImageButton ima12=(ImageButton) findViewById(R.id.ima12);
        ima12.setOnClickListener(lis);

        ImageButton ima13=(ImageButton) findViewById(R.id.ima13);
        ima13.setOnClickListener(lis);

        ImageButton ima14=(ImageButton) findViewById(R.id.ima14);
        ima14.setOnClickListener(lis);

        ImageButton ima15=(ImageButton) findViewById(R.id.ima15);
        ima15.setOnClickListener(lis);

        ImageButton ima16=(ImageButton) findViewById(R.id.ima16);
        ima16.setOnClickListener(lis);



    }

    private  void buscarimagenes()
    {
        turn0 = getResources().getDrawable(R.drawable.ima0);
        turn1 = getResources().getDrawable(R.drawable.ima1);
        turn2 = getResources().getDrawable(R.drawable.ima2);
        turn3 = getResources().getDrawable(R.drawable.ima3);
        turn4 = getResources().getDrawable(R.drawable.ima4);
        turn5 = getResources().getDrawable(R.drawable.ima5);
        turn6 = getResources().getDrawable(R.drawable.ima6);
        turn7 = getResources().getDrawable(R.drawable.ima7);
        turn8 = getResources().getDrawable(R.drawable.ima8);
        turn9 = getResources().getDrawable(R.drawable.ima9);
        turn10 = getResources().getDrawable(R.drawable.ima13);
    }

    public void onTurned(Drawable contenedor, ImageButton boton, boolean band)
    {
        boolean bandera=band;

        flipp.flipImage(bandera? contenedor : turn0, boton);
        Log.d("verdadero",String.valueOf(bandera));
    }

    public void Control(final Drawable contenedor, final ImageButton boton)
    {

       // Log.d("Hola",String.valueOf(cara1));
        if(cara1==null)
        {
            cara1 =contenedor;
            boton1=boton;
            onTurned(contenedor, boton, true);
            //Log.d("Hola",String.valueOf(cara1));

        }
        else if (cara1 == contenedor) {

            onTurned(contenedor, boton, true);
            contador = contador + 1;
            //Log.d("Suma", String.valueOf(contador));
            boton.setEnabled(false);
            boton.setEnabled(false);
            // Log.d("Hola",String.valueOf(cara1));


            cara1 = null;
            boton1 = null;

            if (contador == 8) {
                String usu = getIntent().getStringExtra("Username");
                Toast.makeText(MemoramaActivity.this, usu +"Juego Finalizado: Puntuacion 10", Toast.LENGTH_SHORT).show();

                ContentValues valuesToStore = new ContentValues();
                valuesToStore.put("usuario", "1");
                valuesToStore.put("puntuacion","10");
                appHelper.createUsuario(valuesToStore, "puntuaciones");


            }
        }
        else{
            onTurned(contenedor, boton, true);
            touchActivo=false;
            handler.postDelayed(new Runnable()
            {
                public void run()
                {
                    onTurned(cara1, boton1, false);
                    onTurned(contenedor, boton, false);

                    //Log.d("Conten"," contenedor"+String.valueOf(cara1));
                    //Log.d("Conten"," cara1"+String.valueOf(contenedor));

                    cara1=null;
                    touchActivo=true;
                }
            },1000);
            //Log.d("Hola","hola");

        }






    }






}

