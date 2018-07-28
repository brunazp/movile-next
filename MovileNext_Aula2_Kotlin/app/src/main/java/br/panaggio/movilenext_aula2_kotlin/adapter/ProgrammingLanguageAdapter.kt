package br.panaggio.movilenext_aula2_kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.panaggio.movilenext_aula2_kotlin.R
import br.panaggio.movilenext_aula2_kotlin.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.item_programming_language.view.*

class ProgrammingLanguageAdapter(
        private val items: List<ProgrammingLanguage>,
        private val listener: (ProgrammingLanguage) -> Unit
) : RecyclerView.Adapter<ProgrammingLanguageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingLanguageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_programming_language, parent, false)
        return ProgrammingLanguageViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ProgrammingLanguageViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item, listener)
    }
}

class ProgrammingLanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(item: ProgrammingLanguage, listener: (ProgrammingLanguage) -> Unit) {
        with(itemView) {
            tvTitle.text = item.name
            tvDescription.text = item.description
            tvLaunchYear.text = item.year.toString()
            ivMain.setImageResource(item.imageResourceId)
            setOnClickListener { listener(item) }
        }
    }
}