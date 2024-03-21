package com.example.hinovaoficinas.ui.escolha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hinovaoficinas.databinding.FragmentEscolhaBinding

class EscolhaFragment : Fragment() {

    private var _binding: FragmentEscolhaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEscolhaBinding.inflate(inflater, container, false)

        with(binding){
            btIndique.setOnClickListener {
                TODO()
            }

            btOficinas.setOnClickListener {
                TODO()
            }
        }
        return binding.root
    }
}