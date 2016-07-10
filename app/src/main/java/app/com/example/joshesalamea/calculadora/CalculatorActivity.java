package app.com.example.joshesalamea.calculadora;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * Created by joshesalamea on 29/6/16.
 */
public class CalculatorActivity extends BaseActivity {
    static final int PICK_CONTACT_REQUEST = 1;
    static final int DISPLAY_NAME = ' ';
    boolean osuma=false;
    boolean oresta=false;
    boolean omultiplica=false;
    boolean odivide=false;
    boolean decimal=false;
    double resultado= 0.0 ;


   // String directorio;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);



        View.OnClickListener lis = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView texto = (TextView) findViewById(R.id.pantalla);
                String concatenar= texto.getText().toString();
                Double[] numero = new Double[20];



                switch (v.getId()) {
                    case R.id.llama:
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:934137660"));
                        startActivity(intent);

                        break;
                    case R.id.nueve:

                        texto.setText(concatenar+"9");
                        break;

                    case R.id.ocho:

                        texto.setText(concatenar+"8");
                        break;

                    case R.id.siete:

                        texto.setText(concatenar+"7");
                        break;

                    case R.id.seis:

                        texto.setText(concatenar+"6");
                        break;

                    case R.id.cinco:

                        texto.setText(concatenar+"5");
                        break;

                    case R.id.cuatro:

                        texto.setText(concatenar+"4");
                        break;

                    case R.id.tres:

                        texto.setText(concatenar+"3");
                        break;

                    case R.id.dos:

                        texto.setText(concatenar+"2");
                        break;

                    case R.id.uno:

                        texto.setText(concatenar+"1");
                        break;


                    case R.id.cero:

                        texto.setText(concatenar+"0");
                        break;


                    case R.id.punto:
                        if (decimal==false) {
                            texto.setText(concatenar + ".");
                            decimal=true;
                        }
                        else{
                            return;
                        }
                        break;

                    case R.id.suma:
                        osuma=true;
                        decimal=false;
                        texto.setText("");
                        numero[0]= Double.parseDouble(concatenar);
                        resultado= numero[0];
                        break;

                    case R.id.resta:
                        oresta=true;
                        decimal=false;
                        texto.setText("");
                        numero[0]= Double.parseDouble(concatenar);
                        resultado= numero[0];
                        break;

                    case R.id.multiplica:
                        omultiplica=true;
                        decimal=false;
                        texto.setText("");
                        numero[0]= Double.parseDouble(concatenar);
                        resultado= numero[0];
                        break;

                    case R.id.divide:
                        odivide=true;
                        decimal=false;
                        texto.setText("");
                        numero[0]= Double.parseDouble(concatenar);
                        resultado= numero[0];
                        break;




                    case R.id.borra:
                        decimal=false;
                        texto.setText("");
                        try (FileInputStream openFileInput = new FileInputStream(getFilesDir())) {
                            String res = "";
                            int content;
                            while ((content = openFileInput.read()) != -1) {
                                // convert to char and display it
                                res+=((char) content);
                            }
                            Toast.makeText(getApplicationContext(), "El resultado almacenado era " + res,Toast.LENGTH_LONG).show();
                            Log.d("mensaje",String.valueOf(res));

                        } catch (Exception e) {
                            // not handled
                        }


                        break;

                    case R.id.resulta:
                        numero[1]= Double.parseDouble(concatenar);

                        if (osuma == true  )
                        {
                            resultado=resultado + numero[1];
                            texto.setText(String.valueOf(resultado));
                            osuma=false;

                        }


                        else if (oresta==true)
                        {
                            resultado=resultado - numero[1];
                            texto.setText(String.valueOf(resultado));
                            oresta=false;
                            Log.d("operacion","resta");

                        }
                        else if (omultiplica==true)
                        {
                            resultado=resultado * numero[1];
                            texto.setText(String.valueOf(resultado));
                            omultiplica=false;
                            Log.d("operacion","multiplica");

                        }
                        else if (odivide==true)
                        {
                            if (numero[1]!=0) {
                                resultado = resultado / numero[1];
                                texto.setText(String.valueOf(resultado));
                                odivide = false;
                            }
                            else{
                                texto.setText(String.valueOf(""));
                                Toast.makeText(getApplicationContext(),"Error: Division cero", Toast.LENGTH_SHORT).show();
                            }

                        }




                        try (FileOutputStream openFileOutput = openFileOutput( "arch_resultado.txt", Context.MODE_PRIVATE)) {
                            openFileOutput.write(String.valueOf(resultado).getBytes());
                            Toast.makeText(getApplicationContext(), "Resultado almacenado",Toast.LENGTH_LONG).show();
                            //Log.d("mensaje",String.valueOf(fileList()));

                        } catch (Exception e) {
                            // not handled
                        }




                        //////////////////////



                        break;



                }




            }
        };

        Button button=(Button) findViewById(R.id.llama);
        button.setOnClickListener(lis);

        Button nueve=(Button) findViewById(R.id.nueve);
        nueve.setOnClickListener(lis);

        Button ocho=(Button) findViewById(R.id.ocho);
        ocho.setOnClickListener(lis);

        Button siete=(Button) findViewById(R.id.siete);
        siete.setOnClickListener(lis);

        Button seis=(Button) findViewById(R.id.seis);
        seis.setOnClickListener(lis);

        Button cinco=(Button) findViewById(R.id.cinco);
        cinco.setOnClickListener(lis);

        Button cuatro=(Button) findViewById(R.id.cuatro);
        cuatro.setOnClickListener(lis);

        Button tres=(Button) findViewById(R.id.tres);
        tres.setOnClickListener(lis);

        Button dos=(Button) findViewById(R.id.dos);
        dos.setOnClickListener(lis);

        Button uno=(Button) findViewById(R.id.uno);
        uno.setOnClickListener(lis);

        Button cero=(Button) findViewById(R.id.cero);
        cero.setOnClickListener(lis);

        Button suma=(Button) findViewById(R.id.suma);
        suma.setOnClickListener(lis);

        Button resta=(Button) findViewById(R.id.resta);
        resta.setOnClickListener(lis);

        Button multiplica=(Button) findViewById(R.id.multiplica);
        multiplica.setOnClickListener(lis);

        Button divide=(Button) findViewById(R.id.divide);
        divide.setOnClickListener(lis);

        Button resulta=(Button) findViewById(R.id.resulta);
        resulta.setOnClickListener(lis);

        Button punto=(Button) findViewById(R.id.punto);
        punto.setOnClickListener(lis);

        Button borra=(Button) findViewById(R.id.borra);
        borra.setOnClickListener(lis);







    }





        @Override
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        TextView t = (TextView) findViewById(R.id.pantalla);
        outstate.putString("result", t.getText().toString());
        Log.v("result", t.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        TextView t = (TextView) findViewById(R.id.pantalla);
        t.setText(savedInstanceState.getString("result"));
        Log.v("retrieving",savedInstanceState.getString("result"));
    }



}
