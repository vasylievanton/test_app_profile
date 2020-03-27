package com.test.test_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.test_app.R
import com.test.test_app.model.Tags

class ListAdapter(private var list: List<Tags>) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val tag: Tags = list[position]
        holder.bind(tag)
    }

    override fun getItemCount(): Int = list.size

    fun setData(data: List<Tags>) {
        list = data
        notifyDataSetChanged()
    }

}

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var mTitleView: TextView? = null


    init {
        mTitleView = itemView.findViewById(R.id.tag_tv)
    }

    fun bind(tag: Tags) {
        mTitleView?.text = tag.emoji + "  " + tag.title
    }

}