package org.bedu.shopping.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.bedu.shopping.R
import org.bedu.shopping.databinding.FragmentMainBinding


class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        // Relacionando los items del menú Bottom Navigation con los fragments del nav_graph
        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        val navController = navHostFragment.navController
        setupBottomNavMenu(navController)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

    }

    private fun setupBottomNavMenu(navController: NavController){
         binding.navView.setupWithNavController(navController)
    }
}