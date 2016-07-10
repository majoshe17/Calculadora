package app.com.example.joshesalamea.calculadora;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by joshesalamea on 10/7/16.
 */
public class ForecastAdapter extends Activity {
    public ContentResolver cr;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        cr = getContentResolver();
        Cursor cursor = cr.query(Settings.System.CONTENT_URI, null, null, null, null);
        lv = (ListView) findViewById(R.id.listview_forecast);
        startManagingCursor(cursor);
        String[] from = {Settings.System.NAME, Settings.System.VALUE};
        int[] to = {R.id.list_item_forecast_textview, R.id.list_item_forecast_textview};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this, R.layout.list_item_forecast, cursor, from, to);
        lv.setAdapter(adapter);
        stopManagingCursor(cursor);
    }


}