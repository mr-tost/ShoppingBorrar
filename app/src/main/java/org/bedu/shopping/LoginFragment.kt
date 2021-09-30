package org.bedu.shopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import org.bedu.shopping.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)


        binding.lifecycleOwner = this

        binding.apply {


            buttonAccept.setOnClickListener {
                navigateToMain()
            }
        }



        return binding.root
    }


    private fun navigateToMain() {
        findNavController().navigate(R.id.main_action)
    }

}