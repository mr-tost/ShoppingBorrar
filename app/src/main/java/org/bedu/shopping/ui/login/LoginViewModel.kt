package org.bedu.shopping.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.bedu.shopping.R
import org.bedu.shopping.data.repository.ComprasRepository
import org.bedu.shopping.util.NetworkFailedError
import java.io.Console

class LoginViewModel(val repository: ComprasRepository): ViewModel() {
    val user = MutableLiveData("")
    val password = MutableLiveData("")

    private val _token = MutableLiveData<String>()
    val token get()= _token

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int?>
        get() = _error


    fun tryToLogin(){

        Log.d("TAG","Boton accionado ${user.value} ${password.value}")

        if (user.value!!.isEmpty() || password.value!!.isEmpty()) {
            _error.value = R.string.empty_field
            return
        }

        viewModelScope.launch{
            try{
                Log.d("TAG","Intentando")
               val response = repository.loginUser(user.value!!,password.value!!)
                Log.d("TAG","Listo")
               _token.value = response?.token

            } catch(error: NetworkFailedError){
                _error.value = R.string.user_not_found
            } finally{
                _error.value = R.string.error_login
            }
        }
    }

}