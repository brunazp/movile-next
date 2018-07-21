package br.panaggio.movilenext_aula1;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LiveDataActivity extends AppCompatActivity {

    private TextView tvTimer;
    private LiveDataTimerViewModel liveDataTimerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        tvTimer = findViewById(R.id.tvTimer);

        liveDataTimerViewModel =
                ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);

        subscribe();
    }

    private void subscribe() {
        final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                tvTimer.setText(aLong + " segundos se passaram");
            }
        };

        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }

}
