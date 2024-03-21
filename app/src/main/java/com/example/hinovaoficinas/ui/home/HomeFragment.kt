package com.example.hinovaoficinas.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hinovaoficinas.R
import com.example.hinovaoficinas.databinding.FragmentHomeBinding
import com.example.hinovaoficinas.models.mock.UsuarioMockado
import com.example.hinovaoficinas.viewmodel.MainViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        var cpfDigitado = ""
        var senhaDigitada = ""

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        with(binding) {

            etCpf.doOnTextChanged { text, _, _, _ ->
                cpfDigitado = text.toString()
                btLogar.isEnabled = (!text.isNullOrEmpty() && !etSenha.text.isNullOrEmpty())
            }

            etSenha.doOnTextChanged { text, _, _, _ ->
                senhaDigitada = text.toString()
                btLogar.isEnabled = (!text.isNullOrEmpty() && !etSenha.text.isNullOrEmpty())
            }

            btLogar.setOnClickListener {
                if (mainViewModel.checarDadosLogin(
                        cpfDigitado,
                        senhaDigitada
                    )
                ) {
                    findNavController().navigate(R.id.action_navigation_home_to_escolhaFragment)
                } else {
                    val text = "O Login Falhou"
                    val duration = Toast.LENGTH_LONG

                    val toast = Toast.makeText(context, text, duration) // in Activity
                    toast.show()
                }

            }

            btIgnorarVerificacao.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_escolhaFragment)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}