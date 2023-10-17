package com.example.practiceapi.views.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import com.example.practiceapi.databinding.FragmentSingleProductBinding
import com.example.practiceapi.model.products.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleProductFragment : Fragment() {
    lateinit var binding : FragmentSingleProductBinding
    private val viewModel : ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSingleProductBinding.inflate(inflater,container,false)
        requireArguments().getInt("id").let {
            viewModel.product(it)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.responsedt.observe(viewLifecycleOwner){
            if (it.isSuccessful){
                setProduct(it.body()!!)

            }
        }

    }
    private fun setProduct(it: Product){
        binding.title.text =it.title
        binding.price.text ="Price: ${it.price}"
        binding.rating.text ="Rating: ${it.rating}"
        binding.stock.text ="Stock: ${it.stock}"
        binding.brand.text ="Brand: ${it.brand}"
        binding.description.text =it.description
        binding.category.text ="Category: ${it.category}"
        binding.discount.text = "Discount Price: ${it.discountPercentage}"
        binding.thumbnail.load(it.thumbnail)

//        it.images?.get(0)?.let { img_url ->
//            binding.image1.load(img_url)
//
//        }
//
//        it.images?.get(1)?.let { img_url ->
//            binding.image2.load(img_url)
//
//        }
//        it.images?.get(2)?.let { img_url ->
//            binding.image3.load(img_url)

        }

    }


