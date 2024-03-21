package com.example.hinovaoficinas.ui.oficinas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hinovaoficinas.R
import com.example.hinovaoficinas.databinding.FragmentIndicacaoBinding
import com.example.hinovaoficinas.databinding.FragmentOficinasBinding

class OficinasFragment : Fragment() {

    private var _binding: FragmentOficinasBinding? = null
    private val binding get() = _binding!!
//    private var oficinasAdapter: OficinasAdapter? = null
//    private val oficinaItemViewModel by sharedViewModel<OficinaItemViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOficinasBinding.inflate(inflater, container, false)

//        oficinasAdapter = OficinasAdapter(oficinaItemViewModel.ListarOficinas)
//        binding.rvItensOfinas.adapter = oficinasAdapter

        return binding.root
    }

}