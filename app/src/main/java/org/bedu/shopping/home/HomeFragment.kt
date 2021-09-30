package com.example.beducompras.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.core.view.doOnPreDraw
import org.bedu.shopping.data.model.Product
import org.bedu.shopping.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), ProductAdapterListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //private var products: List<Product>? = null

    private lateinit var productAdapter: ProductAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        setupRecyclerView()

        /*if(products == null){
            fetchProducts()
        } else{
            showProducts()
        }*/

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()

        view.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }


    private fun fetchProducts(){

    }

    private fun setupRecyclerView(){
        productAdapter = ProductAdapter()
        binding.productList.apply{
            adapter = productAdapter
        }
    }


    override fun onProductClicked(view: View, product: Product) {

    }
}