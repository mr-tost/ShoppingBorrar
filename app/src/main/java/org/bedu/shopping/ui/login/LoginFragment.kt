package org.bedu.shopping.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import org.bedu.shopping.R
import org.bedu.shopping.ShoppingApplication
import org.bedu.shopping.databinding.FragmentLoginBinding
import org.bedu.shopping.util.UiUtils

class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding

    private val application by lazy { activity?.applicationContext as ShoppingApplication }
    private val loginViewModel: LoginViewModel by lazy { LoginViewModel(application.comprasRepository) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)


        binding.lifecycleOwner = this

        binding.apply {

            this.viewModel = loginViewModel

            buttonAccept.setOnClickListener {
                navigateToMain()
            }

            loginViewModel.let {
                it.error.observe(viewLifecycleOwner) {
                    UiUtils.showSnackbar(requireView(), it!!, R.string.understood)
                }

                it.token.observe(viewLifecycleOwner){
                    navigateToMain()
                }

            }
        }



        return binding.root
    }


    private fun navigateToMain() {
        findNavController().navigate(R.id.main_action)
    }

}