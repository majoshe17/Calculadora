package app.com.example.joshesalamea.calculadora;

/**
 * Created by joshesalamea on 30/6/16.
 */

import android.os.Bundle;


public class ActivityRanking extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
    }


}