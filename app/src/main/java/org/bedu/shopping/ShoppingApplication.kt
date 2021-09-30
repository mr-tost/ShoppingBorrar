package org.bedu.shopping

import android.app.Application
import com.example.beducompras.repository.ShopDatabase
import org.bedu.shopping.api.Api
import org.bedu.shopping.data.repository.ComprasRepository

class ShoppingApplication: Application() {

    val repository by lazy{cartDao}

    private val cartDao by lazy { ShopDatabase.getDatabase(this).cartDao()}
    private val storeService = Api.storeService
    private val loginService = Api.loginService

    val comprasRepository by lazy{ ComprasRepository(loginService, storeService, cartDao) }
}