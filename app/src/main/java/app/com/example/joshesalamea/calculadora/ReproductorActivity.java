package app.com.example.joshesalamea.calculadora;

/**
 * Created by joshesalamea on 30/6/16.
 */

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;


public class ReproductorActivity extends BaseActivity {
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        setTitle("Reproductor");

        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("audio/*");

        //Este Intent define para el ACTION_PICK, la URI de donde cogerá los datos

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        //Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        //Usamos el Intent anterior para filtrar únicamente los que queremos que usen
        Intent chooserIntent = Intent.createChooser(getIntent, "Select Audio");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

        startActivityForResult(chooserIntent, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode==1){
                Uri song = data.getData();
                MediaPlayer mediaPlayer =new MediaPlayer();
                try {
                    Log.d("Path", String.valueOf(song.getPath()));

                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(song.getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                  //  @Override
                    //public void onPrepared(MediaPlayer mediaPlayer) {
                      // mediaPlayer.start();
                    //}
                //});
                //mediaPlayer.prepareAsync();

            }
        }else{
            Log.v("Result","Something happened");
        }
    }

    private void insertDummyContactWrapper() {
        int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.WRITE_CONTACTS);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE_ASK_PERMISSIONS);
            return;
        }
        //insertDummyContact();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    //insertDummyContact();

                    Log.d("Permiso","OK");
                } else {
                    // Permission Denied
                    Toast.makeText(ReproductorActivity.this, "WRITE_CONTACTS Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }




}
