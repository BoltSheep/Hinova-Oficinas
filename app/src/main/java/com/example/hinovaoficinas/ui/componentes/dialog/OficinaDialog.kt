package com.example.hinovaoficinas.ui.componentes.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.hinovaoficinas.databinding.DialogOficinaCompletoBinding
import com.example.hinovaoficinas.models.OficinaApiModel

class OficinaDialog(oficina: OficinaApiModel): DialogFragment() {

    private var _binding: DialogOficinaCompletoBinding? = null

    private val binding get() = _binding!!

    val oficinaCompleta = oficina

    companion object {
        const val TAG = "OficinaDialog"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogOficinaCompletoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){

            tvNomeOficina.text = oficinaCompleta.Nome
            tvDescricaoCompleta.text = oficinaCompleta.Descricao
            tvEndereco.text = oficinaCompleta.Endereco
            tvEmail.text = oficinaCompleta.Email
            tvTelefone.text = oficinaCompleta.Telefone1
        }
    }
}