package com.mailprojectteam.memorizelic.ui.home
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mailprojectteam.memorizelic.CardsOptions
import com.mailprojectteam.memorizelic.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val startSettingsButton: Button = root.findViewById(R.id.button_start_deck);

        startSettingsButton.setOnClickListener {
            val intent = Intent(requireContext(),CardsOptions::class.java)
            startActivity(intent)
        }
        
        return root
    }
}