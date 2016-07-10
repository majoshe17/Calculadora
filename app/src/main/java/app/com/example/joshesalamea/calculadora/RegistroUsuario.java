package app.com.example.joshesalamea.calculadora;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app.com.example.joshesalamea.calculadora.database.AplicacionDBHelper;

/**
 * Created by joshesalamea on 4/7/16.
 */
public class RegistroUsuario extends AppCompatActivity {

    AplicacionDBHelper appHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        setTitle("Registro Usuario");


        appHelper = new AplicacionDBHelper(getApplicationContext());



        final TextView nombre = (TextView) findViewById(R.id.nombre);
        final TextView usuario = (TextView) findViewById(R.id.usuario);
        final TextView password = (TextView) findViewById(R.id.password);
        final TextView correo = (TextView) findViewById(R.id.correo);
        final TextView direccion = (TextView) findViewById(R.id.direccion);
        final TextView telefono = (TextView) findViewById(R.id.telefono);


        View.OnClickListener lis = new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //public void registrar(View v) {
                    ContentValues valuesToStore = new ContentValues();
                    valuesToStore.put("usuario", String.valueOf(usuario.getText()));
                    valuesToStore.put("password", String.valueOf(password.getText()));
                    valuesToStore.put("nombre", String.valueOf(nombre.getText()));
                    valuesToStore.put("correo", String.valueOf(correo.getText()));
                    valuesToStore.put("direccion", String.valueOf(direccion.getText()));
                    valuesToStore.put("telefono", String.valueOf(telefono.getText()));


                    appHelper.createUsuario(valuesToStore, "usuarios");

                    Toast.makeText(getApplicationContext(),"Usuarios Registrados", Toast.LENGTH_SHORT).show();
                }
            //}

        };
        Button button=(Button) findViewById(R.id.registro);
        button.setOnClickListener(lis);

    }








}
