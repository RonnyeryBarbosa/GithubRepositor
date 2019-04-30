package com.ronnyerybarbosa.githubrepositor.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ronnyerybarbosa.githubrepositor.data.repository.Repository
import kotlinx.android.synthetic.main.item_repositor.view.*
import java.text.SimpleDateFormat


class RepositorItemAdapter(val postItems: List<Repository>, val context: Context) : RecyclerView.Adapter<RepositorItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(com.ronnyerybarbosa.githubrepositor.R.layout.item_repositor, parent, false))

    }

    override fun getItemCount(): Int {
        return postItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.itemView.txt_name_repo.text = postItems[position].name
        holder.itemView.txt_name_user.text = postItems[position].owner?.login
        holder?.itemView.txt_rating.text = postItems[position].stars.toString()
        holder?.itemView.txt_create.text = "criado: ${getDate(postItems[position].create)}"
        holder?.itemView.txt_update.text = "atualizado: ${getDate(postItems[position].update)}"





        Glide.with(context)
            .load( postItems[position].owner?.avatar)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.itemView.image_user)

        //holder?.itemView.tv_post_body.text = postItems.get(position).body
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

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

}