package br.panaggio.movilenext_aula1;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

public class LiveDataTimerViewModel extends ViewModel {

    private static final int ONE_SECOND = 1000;
    private Long initialTime;
    private MutableLiveData<Long> elapsedTime = new MutableLiveData<>();

    public LiveDataTimerViewModel() {
        initialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - initialTime) / ONE_SECOND;
                elapsedTime.postValue(newValue);
            }
        }, ONE_SECOND, ONE_SECOND);
    }

    public MutableLiveData<Long> getElapsedTime() {
        return elapsedTime;
    }
}
