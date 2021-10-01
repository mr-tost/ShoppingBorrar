package com.example.beducompras.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.core.view.doOnPreDraw
import org.bedu.shopping.ShoppingApplication
import org.bedu.shopping.data.model.Product
import org.bedu.shopping.databinding.FragmentHomeBinding
import org.bedu.shopping.ui.home.HomeViewModel
import org.bedu.shopping.ui.login.LoginViewModel

class HomeFragment : Fragment(), ProductAdapterListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //private var products: List<Product>? = null

    private lateinit var productAdapter: ProductAdapter
    private val application by lazy { activity?.applicationContext as ShoppingApplication }
    private val homeViewModel: HomeViewModel by lazy { HomeViewModel(application.productRepository) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = this

        setupRecyclerView()

        homeViewModel.let{
            it.products.observe(viewLifecycleOwner) { productList ->
                Log.d("JEJEJO",productList.toString())
                productAdapter.submitList(productList)
            }

            it.getProducts()
        }


        return binding.root
    }



    private fun setupRecyclerView(){
        productAdapter = ProductAdapter()
        binding.productList.apply{
            adapter = productAdapter

            binding.progressBar.visibility = View.INVISIBLE
            binding.textHeader.visibility = View.VISIBLE
            binding.productList.visibility = View.VISIBLE
        }
    }


    override fun onProductClicked(view: View, product: Product) {

    }
}