package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.recyclerview.databinding.ItemRecyclerBinding
import coil.load

class AdapterRecView(private val listWayang: ArrayList<DcWayang>) :

    RecyclerView.Adapter<AdapterRecView.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val wayang = listWayang[position]
        val circularProgressDrawable = CircularProgressDrawable(holder.itemView.context).apply {
            strokeWidth = 5f
            centerRadius = 30f
            start()
        }

        holder.binding.gambarWayang.load(wayang.foto) {
            crossfade(true)
            placeholder(circularProgressDrawable)
            error(R.drawable.ic_launcher_background)
        }

        holder.binding.gambarWayang.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Gambar ${wayang.nama} diklik",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return listWayang.size
    }

    class ListViewHolder(val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root)
}

