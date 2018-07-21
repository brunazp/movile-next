package br.panaggio.movilenext_aula1;

import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChronometerViewModel chronometerViewModel =
                ViewModelProviders.of(this).get(ChronometerViewModel.class);

        if (chronometerViewModel.getStartTime() == null) {
            long startTime = SystemClock.elapsedRealtime();
            chronometerViewModel.setStartTime(startTime);
        }

        Chronometer chronometer = findViewById(R.id.chronometer);
        chronometer.setBase(chronometerViewModel.getStartTime());
        chronometer.start();
    }
}
