package app.com.example.joshesalamea.calculadora;

/**
 * Created by joshesalamea on 30/6/16.
 */

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import app.com.example.joshesalamea.calculadora.database.AplicacionDBHelper;



public class ActivityRanking  extends ListActivity {


    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    AplicacionDBHelper carHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);


        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        setListAdapter(adapter);

        carHelper = new AplicacionDBHelper(getApplicationContext());

        Cursor c = carHelper.getPuntuaciones();
        if (c.moveToFirst()) {
            do {
                adapter.add(c.getString(c.getColumnIndex("puntuacion")));
                Log.d("Base",String.valueOf(c));
            } while (c.moveToNext());
        }
        ListView lv = getListView();
    }

}
