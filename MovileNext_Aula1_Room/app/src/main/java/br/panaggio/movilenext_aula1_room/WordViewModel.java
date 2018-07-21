package br.panaggio.movilenext_aula1_room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mWordRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
        mAllWords = mWordRepository.getAllWords();
    }

    public void insert(Word word) {
        mWordRepository.insert(word);
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void deleteAll() {
        mWordRepository.deleteAll();
    }

    public LiveData<List<Word>> getWordsContaining(String value) {
        return mWordRepository.getWordsContaining(value);
    }
}
