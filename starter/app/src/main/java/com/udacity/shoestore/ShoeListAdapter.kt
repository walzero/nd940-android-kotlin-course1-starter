package com.udacity.shoestore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe


class ShoeListAdapter(
    private var shoeList: MutableList<Shoe> = mutableListOf()
) : RecyclerView.Adapter<ShoeListAdapter.ShoeViewHolder>() {

    private lateinit var recyclerView: RecyclerView

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    fun addShoe(shoe: Shoe) {
        synchronized(shoeList) {
            shoeList.add(shoe)
            notifyItemInserted(shoeList.lastIndex)
        }
    }

    fun addShoes(shoes: List<Shoe>) {
        synchronized(shoeList) {
            val startPosition = shoeList.lastIndex
            shoeList.addAll(shoes)
            notifyItemRangeInserted(startPosition.inc(), shoes.count())
        }
    }

    fun replaceShoes(shoes: List<Shoe>) {
        synchronized(shoeList) {
            shoeList = shoes.toMutableList()
            notifyDataSetChanged()
        }
    }

    private fun scrollToTheEnd() {
        if (::recyclerView.isInitialized) {
            recyclerView.scrollToPosition(shoeList.lastIndex)
        }
    }

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