package com.example.beducompras.ui.home

import android.view.View
import org.bedu.shopping.Product

interface ProductAdapterListener {
    fun onProductClicked(view: View, product: Product)
}