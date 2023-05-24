package com.utkuglsvn.viewpagercarouselandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utkuglsvn.viewpagercarouselandroid.databinding.ItemViewpagerBinding

class ItemAdapter(private val list: MutableList<ItemData>) :
    RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapterViewHolder {
        val binding = ItemViewpagerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemAdapterViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ItemAdapterViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.apply {
                    textView.text = number
                    Glide.with(holder.itemView.context)
                        .load(imgUrl)
                        .error(R.drawable.ic_launcher_foreground)
                        .into(binding.imageView)
                }

                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        holder.itemView.context, number,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    inner class ItemAdapterViewHolder(val binding: ItemViewpagerBinding) :
        RecyclerView.ViewHolder(binding.root)
}