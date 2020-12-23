package com.udacity.shoestore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe


class ShoeListAdapter(
    private var shoeList: MutableList<Shoe>
) : RecyclerView.Adapter<ShoeListAdapter.ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShoeViewHolder(ItemShoeBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.bind(shoeList[position])
    }

    override fun getItemCount(): Int = shoeList.size

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_shoe
    }

    class ShoeViewHolder(
        private val itemBinding: ItemShoeBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(shoe: Shoe) {
            itemBinding.shoe = shoe
            itemBinding.executePendingBindings()
        }
    }
}