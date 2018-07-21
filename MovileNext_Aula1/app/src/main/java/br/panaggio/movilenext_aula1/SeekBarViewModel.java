package br.panaggio.movilenext_aula1;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SeekBarViewModel extends ViewModel {
    private MutableLiveData<Integer> seekBarValue = new MutableLiveData<>();

    public MutableLiveData<Integer> getSeekBarValue() {
        return seekBarValue;
    }
}
