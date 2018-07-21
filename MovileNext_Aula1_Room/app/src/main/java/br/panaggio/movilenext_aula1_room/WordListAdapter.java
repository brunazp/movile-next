package br.panaggio.movilenext_aula1_room;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordViewHolder> {

    private List<Word> mWords;
    private final LayoutInflater mInflater;

    public WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.word_item, parent, false);
        WordViewHolder wordViewHolder = new WordViewHolder(itemView);
        return wordViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int position) {
        wordViewHolder.bind(mWords.get(position));
    }

    @Override
    public int getItemCount() {
        return (mWords != null) ? mWords.size() : 0;
    }

    public void setItems(List <Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }
}
