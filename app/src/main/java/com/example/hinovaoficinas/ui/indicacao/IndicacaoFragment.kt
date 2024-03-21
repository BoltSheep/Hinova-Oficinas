package com.example.hinovaoficinas.ui.indicacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hinovaoficinas.databinding.FragmentIndicacaoBinding
import com.example.hinovaoficinas.viewmodel.MainViewModel

class IndicacaoFragment : Fragment() {

    private var _binding: FragmentIndicacaoBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = FragmentIndicacaoBinding.inflate(inflater, container, false)


        var nome: String = ""
        var email: String = ""
        var telefone: String = ""

        with(binding) {
            etNomeAmigo.doOnTextChanged { text, _, _, _ ->
                nome = text.toString()
            }

            etEmailAmigo.doOnTextChanged { text, _, _, _ ->
                email = text.toString()
            }

            etTelefoneAmigo.doOnTextChanged { text, _, _, _ ->
                telefone = text.toString()
            }

            btEnviarIndicacao.setOnClickListener {
                mainViewModel.enviarDados(nome, email, telefone)
            }

            mainViewModel.status.observe(viewLifecycleOwner, Observer { status ->
                if (status){
                    etNomeAmigo.text.clear()
                    etEmailAmigo.text.clear()
                    etTelefoneAmigo.text.clear()
                    Toast.makeText(context,"Indicacao enviada com sucesso!",Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context,"Ocorreu Algum Erro",Toast.LENGTH_LONG).show()
                }
            })

        }

        return binding.root
    }
}