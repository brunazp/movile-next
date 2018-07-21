package br.panaggio.movilenext_aula1_room;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class WordViewHolder extends RecyclerView.ViewHolder {

    private final TextView mWordItemView;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        mWordItemView = itemView.findViewById(R.id.textview_word);
    }

    public void bind(Word word) {
        mWordItemView.setText(word.getWord());
    }
}
