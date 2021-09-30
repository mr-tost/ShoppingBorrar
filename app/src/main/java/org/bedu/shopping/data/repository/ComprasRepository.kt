package org.bedu.shopping.data.repository

import android.util.Log
import com.example.beducompras.api.FakeStoreService
import com.example.beducompras.api.LoginService
import com.example.beducompras.repository.CartDao
import org.bedu.shopping.data.model.LoginResponse
import org.bedu.shopping.util.NetworkConnectionError
import org.bedu.shopping.util.NetworkFailedError

class ComprasRepository(
    val loginService: LoginService,
    val storeService: FakeStoreService,
    val cartDao: CartDao
) {

    suspend fun loginUser(user: String, password: String): LoginResponse? {
        try{
            val result = loginService.login(user, password)
            return result.body()

        } catch (cause: Throwable) {
            throw NetworkConnectionError("Hubo un error al llamar el servicio", cause)
        }
    }

}