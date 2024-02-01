package com.example.imagesearchsave

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearchsave.databinding.FragmentSearchBinding
import com.example.imagesearchsave.databinding.ViewItemBinding
import java.time.format.DateTimeFormatter

class RecyclerAdapter(val items: MutableList<Item>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    private lateinit var itemClickListener: onItemClickListener

    fun setItemClickListener(itemClickListener: onItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.ViewHolder {
        val binding = ViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(position)
        }
        holder.img.setImageURI(items[position].img)
        holder.from.text=items[position].from
        holder.time.text=items[position].time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    inner class ViewHolder(val binding: ViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.imgImg
        val from = binding.txtWhere
        val time = binding.txtWhen
    }
}