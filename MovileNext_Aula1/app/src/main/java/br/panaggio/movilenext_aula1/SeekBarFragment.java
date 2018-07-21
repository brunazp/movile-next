package br.panaggio.movilenext_aula1;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


public class SeekBarFragment extends Fragment {


    private SeekBar seekBar;
    private SeekBarViewModel seekBarViewModel;

    public SeekBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_seek_bar, container, false);
        seekBar = root.findViewById(R.id.seekBar);
        seekBarViewModel = ViewModelProviders.of(getActivity()).get(SeekBarViewModel.class);

        subscribeSeekBar();

        return root;
    }

    private void subscribeSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    seekBarViewModel.getSeekBarValue().setValue(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Observer<Integer> seekBarObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer progress) {
                if (progress != null) {
                    seekBar.setProgress(progress);
                }
            }
        };

        seekBarViewModel.getSeekBarValue().observe(this, seekBarObserver);
    }

}