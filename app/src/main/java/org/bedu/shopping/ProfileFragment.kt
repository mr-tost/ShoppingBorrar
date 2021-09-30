package org.bedu.shopping

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.bedu.shopping.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(){

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        fetchProfile()

        return binding.root
    }


    private fun fetchProfile(){

    }


}