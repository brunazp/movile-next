package br.panaggio.movilenext_aula2_kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.panaggio.movilenext_aula2_kotlin.R
import br.panaggio.movilenext_aula2_kotlin.network.Repository
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryAdapter(
        private val items: List<Repository>,
        private val listener: (Repository) -> Unit
) : RecyclerView.Adapter<RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_repository, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item, listener)
    }
}

class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(item: Repository, listener: (Repository) -> Unit) {
        with(itemView) {
            tvTitle.text = item.name
            tvDescription.text = item.description
            tvOwner.text = item.owner?.login
            setOnClickListener { listener(item) }

            Glide.with(context).load(item.owner?.avatarUrl).into(ivMain)
        }
    }
}