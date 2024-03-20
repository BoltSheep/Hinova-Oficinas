package com.example.hinovaoficinas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hinovaoficinas.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        var logarValido = false
        var cpfDigitado = ""
        var senhaDigitada = ""

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        with(binding){

            etCpf.doOnTextChanged { text, _, _, _ ->
                cpfDigitado = text.toString()
                logarValido = cpfDigitado == "Mock" && senhaDigitada == "Mock"
            }

            etSenha.doOnTextChanged { text, _, _, _ ->
                senhaDigitada = text.toString()
                logarValido = cpfDigitado == "Mock" && senhaDigitada == "Mock"
            }

            btLogar.setOnClickListener {
                TODO()
            }

            btIgnorarVerificacao.setOnClickListener {
                TODO()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}