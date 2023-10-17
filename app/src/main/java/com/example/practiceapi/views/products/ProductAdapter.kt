package com.example.practiceapi.views.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.practiceapi.databinding.ItemBinding
import com.example.practiceapi.model.products.Product

class ProductAdapter(private val listener  : ProductAdapter.Listener) : ListAdapter<Product, ProductAdapter.ProductViewHolder>(COMPARATOR){

    interface Listener {
        fun productClick(Id: Int)
    }

    class ProductViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {

        val COMPARATOR = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(
                oldItem: Product, newItem: Product
            ): Boolean {

                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Product, newItem: Product
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        return ProductViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        getItem(position).let {
            holder.binding.title.text = it.title
            holder.binding.rating.text = "Ratings : ${it.rating}"
            holder.binding.price.text = "Price : $${it.price}"
            holder.binding.discount.text = "Discount Price : $${it.discountPercentage}"
            holder.binding.description.text = it.description
            holder.binding.stock.text = it.stock.toString()
            holder.binding.category.text = it.category
            holder.binding.brand.text = it.brand
            holder.binding.thumbnail.load(it.thumbnail)

//            it.thumbnail?.get(0)?.let { img_url ->
//                holder.binding.thumbnail.load(img_url)
//            }
            holder.itemView.setOnClickListener { _ ->

                listener.productClick(it.id)


            }

        }

    }
}



