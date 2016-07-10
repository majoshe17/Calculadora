package app.com.example.joshesalamea.calculadora;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import app.com.example.joshesalamea.calculadora.database.AplicacionDBHelper;
import io.fabric.sdk.android.Fabric;

/**
 * Created by joshesalamea on 1/7/16.
 */
public class LoginActivity extends AppCompatActivity {


    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "G8g0WXp2CVomtHXS2ZgbQynPz";
    private static final String TWITTER_SECRET = "WaoLpkyWd0ksZvQSFYx15xBDDbAsKtrMu85KMH82socnDsEEVU";
    private TwitterLoginButton loginButton;
    AplicacionDBHelper appHelper;
    String usu, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_login);
        setTitle("Login");

        ////Boton Twitter

        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {

            @Override
            public void success(Result<TwitterSession> result) {
                // The TwitterSession is also available through:
                // Twitter.getInstance().core.getSessionManager().getActiveSession()
                TwitterSession session = result.data;
                // TODO: Remove toast and use the TwitterSession's userID
                // with your app's user model
                String msg = "@" + session.getUserName() + " logged in! (#" + session.getUserId() + ")";
                Intent i = new Intent(LoginActivity.this, BaseActivity.class);
                i.putExtra("Username", usu);
                startActivity(i);


                //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }
        });




        /////***FIN TWITER




        appHelper = new AplicacionDBHelper(getApplicationContext());

        final TextView usuario = (TextView) findViewById(R.id.usuario);
        final TextView password = (TextView) findViewById(R.id.password);


        View.OnClickListener lis = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.login:

                    usu = String.valueOf(usuario.getText());
                    pass = String.valueOf(password.getText());
                    SQLiteDatabase db = appHelper.getReadableDatabase();


                    if (db != null) {
                        Boolean c = appHelper.getUsuariosLogin(usu, pass);
                        if (c == true) {
                            Intent i = new Intent(LoginActivity.this, BaseActivity.class);
                            i.putExtra("Username", usu);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Usuario no Registrado", Toast.LENGTH_SHORT).show();
                        }

                    }
                        break;

                    case R.id.registrarse:
                        Log.d("Hola","Hola");
                            startActivity(new Intent(getApplicationContext(),RegistroUsuario.class));


                        break;


                }


            }


                //}


        };
        Button button = (Button) findViewById(R.id.login);
        button.setOnClickListener(lis);

        Button registrarse = (Button) findViewById(R.id.registrarse);
        registrarse.setOnClickListener(lis);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

}