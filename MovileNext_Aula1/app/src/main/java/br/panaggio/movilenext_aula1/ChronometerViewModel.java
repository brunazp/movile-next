package br.panaggio.movilenext_aula1;

import android.arch.lifecycle.ViewModel;

public class ChronometerViewModel extends ViewModel {
    private Long startTime;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
}
