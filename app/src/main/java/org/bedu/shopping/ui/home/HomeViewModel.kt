package org.bedu.shopping.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.bedu.shopping.R
import org.bedu.shopping.data.model.Product
import org.bedu.shopping.data.repository.ComprasRepository
import org.bedu.shopping.data.repository.ProductRepository
import org.bedu.shopping.util.NetworkFailedError
import java.io.Console

class HomeViewModel(val repository: ProductRepository): ViewModel() {

    private var _products = MutableLiveData<List<Product>>()
    val products get() = _products

    fun getProducts(){

        viewModelScope.launch{
            try{
                Log.d("TAG","Intentandfdso")
                withContext(Dispatchers.IO){
                    val response = repository.getProducts()
                    Log.d("TAG","Listofsd")
                    _products.postValue(response)
                }

            } catch(error: NetworkFailedError){
                //
            } finally{
                //
            }
        }
    }

}