package app.com.example.joshesalamea.calculadora.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by joshesalamea on 1/7/16.
 */
public class AplicacionDBHelper extends SQLiteOpenHelper {
    private static int BD_VERSION = 2;
    private static String BD_NAME = "bd_proyecto";
    private static String USUARIOS_TABLE = "usuarios";
    private static String PUNTUACIONES_TABLE = "puntuaciones";


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ PUNTUACIONES_TABLE);
        sqLiteDatabase.execSQL("CREATE TABLE "+PUNTUACIONES_TABLE+" (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, puntuacion INTEGER)");

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+USUARIOS_TABLE);
        sqLiteDatabase.execSQL("CREATE TABLE "+USUARIOS_TABLE+" (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, password TEXT,nombre TEXT, correo TEXT, telefono TEXT, direccion TEXT)");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+PUNTUACIONES_TABLE+" (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, puntuacion INTEGER)");
        //sqLiteDatabase.execSQL("INSERT INTO "+PUNTUACIONES_TABLE+" (usuario, puntuacion) VALUES('jugador1','15'), ('jugador2', '30'), ('jugador3','8')");


        sqLiteDatabase.execSQL("CREATE TABLE "+USUARIOS_TABLE+" (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, password TEXT, nombre TEXT, correo TEXT, telefono TEXT, direccion TEXT)");
        //sqLiteDatabase.execSQL("INSERT INTO "+USUARIOS_TABLE+" (usuario, password, nombre, telefono, correo, direccion) " +
        //                                                        "VALUES('jose','jose','jose','9090','sdaas@asda' ,'calle')");
    }


    //Devolver como array
    public Boolean getUsuariosLogin(String usuario, String password) {

        String[] columns = {"usuario, password"};
        String selection = "usuario = " + "'" + usuario + "' AND password =" + "'" + password + "'"  ;
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor c = db.query(
                USUARIOS_TABLE,          // The table to query
                columns,            // The columns to return
                selection,               // The columns for the WHERE clause
                null,               // The values for the WHERE clause
                null,               // don't group the rows
                null,               // don't filter by row groups
                null                // The sort order


        );
        Log.d("Vector",String.valueOf(c.getCount()));

        if (c.getCount()>0) {
            return true;
        }
        else
        {
            return false;
        }

    }

    public Cursor getPuntuaciones() {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"puntuacion"};


        //String[] where = {id};
        Cursor c = db.query(
                PUNTUACIONES_TABLE,          // The table to query
                columns,            // The columns to return
                null,               // The columns for the WHERE clause
                null,               // The values for the WHERE clause
                null,               // don't group the rows
                null,               // don't filter by row groups
                null                // The sort order
        );
        return c;
    }



    public void createUsuario (ContentValues values, String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(
                tableName,
                null,
                values);
    }

    public void createPuntuaciones (ContentValues values, String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(
                tableName,
                null,
                values);
    }

    public AplicacionDBHelper(Context context) {
        super(context, BD_NAME, null, BD_VERSION);
    }
}
