package com.ronnyerybarbosa.githubrepositor.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ronnyerybarbosa.githubrepositor.data.repository.Repository
import kotlinx.android.synthetic.main.item_repositor.view.*
import java.text.SimpleDateFormat


class RepositorItemAdapter(var repositories: MutableList<Repository>, val context: Context, val listener: ItemClickListener) : RecyclerView.Adapter<RepositorItemAdapter.ViewHolder>(), Filterable {


    private var repositoriesSearchList: List<Repository>

    init {
        repositoriesSearchList = repositories
    }

    override fun getFilter(): Filter
    {

        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    repositoriesSearchList = repositories
                } else {
                    val filteredList = ArrayList<Repository>()
                    for (row in repositories)
                    {
                        if (row.name.toLowerCase().startsWith(charString.toLowerCase())) {
                            filteredList.add(row)
                        }
                    }
                    repositoriesSearchList = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = repositoriesSearchList
                return filterResults
            }
            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults)
            {
                repositoriesSearchList = filterResults.values as ArrayList<Repository>
                notifyDataSetChanged()
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(com.ronnyerybarbosa.githubrepositor.R.layout.item_repositor, parent, false))

    }

    override fun getItemCount(): Int {
        return repositoriesSearchList?.size?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.itemView.txt_name_repo.text = repositoriesSearchList[position].name
        holder.itemView.txt_name_user.text = repositoriesSearchList[position].owner?.login
        holder?.itemView.txt_rating.text = repositoriesSearchList[position].stars.toString()
        holder?.itemView.txt_create.text = "criado: ${getDate(repositoriesSearchList[position].create)}"
        holder?.itemView.txt_update.text = "atualizado: ${getDate(repositoriesSearchList[position].update)}"





        Glide.with(context)
            .load(repositoriesSearchList[position].owner?.avatar)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.itemView.image_user)

    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        init {
            view.setOnClickListener {
                listener.onItemClicked(repositories[adapterPosition])
            }
        }
    }


    private fun getDate(s: String): String? {
        try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            val outputFormat = SimpleDateFormat("dd-MM-yyyy")
            val date = inputFormat.parse("2018-04-10T04:00:00.000Z")
            return  outputFormat.format(date)

        } catch (e: Exception) {
            return e.toString()
        }
    }

//    fun setFilter(providersFilter: MutableList<Repository>)
//    {
//        repositories = mutableListOf()
//        repositories.addAll(providersFilter)
//        notifyDataSetChanged()
//    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    interface ItemClickListener {
        fun onItemClicked(repository: Repository)
    }


}