package com.example.practiceapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.practiceapi.databinding.FragmentProductBinding
import com.example.practiceapi.views.products.CategoryViewModel
import com.example.practiceapi.views.products.ProductViewModel
import com.example.practiceapi.views.products.ProductAdapter

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment(), ProductAdapter.Listener {

lateinit var binding:  FragmentProductBinding
private val viewModelc : CategoryViewModel by viewModels()
private val viewModel : ProductViewModel by viewModels()


    lateinit var adapter : ProductAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater,container,false)
        adapter = ProductAdapter(this)
        binding.allproductrcv.adapter = adapter
        viewModel.allProduct()

        val tabLayout = binding.tablayout

        viewModelc.responsedata.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                val categories = response.body()
                if (categories != null) {
                    for (category in categories) {
                        val tab = tabLayout.newTab()
                        tab.text = category // Assuming ResponseCategory is a List<String>
                        tabLayout.addTab(tab)
                    }
                }
            }
        }

        viewModelc.allCategory()

        viewModel.allProduct()


        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.responsedata.observe(viewLifecycleOwner){
            if (it.isSuccessful){
                adapter.submitList(it.body()?.products)
            }
        }






    }

    override fun productClick(Id: Int) {
        var bundle = Bundle ()
        bundle.putInt("id",Id)

        findNavController().navigate(R.id.action_productFragment_to_singleProductFragment, bundle)
    }


}