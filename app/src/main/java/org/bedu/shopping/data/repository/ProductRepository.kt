package org.bedu.shopping.data.repository

import com.example.beducompras.api.FakeStoreService
import com.example.beducompras.repository.CartDao
import org.bedu.shopping.data.model.LoginResponse
import org.bedu.shopping.data.model.Product
import org.bedu.shopping.util.NetworkConnectionError

class ProductRepository(
                    val storeService: FakeStoreService,
                        val cartDao: CartDao) {

    suspend fun getProducts(): List<Product>? {
        try{
            val result = storeService.getProducts()
            return result.body()

        } catch (cause: Throwable) {
            throw NetworkConnectionError("Hubo un error al llamar el servicio", cause)
        }
    }

    fun insert(product: Product){
        cartDao.insert(product)
    }

}