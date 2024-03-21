package com.example.hinovaoficinas.ui.indicacao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hinovaoficinas.R
import com.example.hinovaoficinas.databinding.FragmentEscolhaBinding
import com.example.hinovaoficinas.databinding.FragmentIndicacaoBinding

class IndicacaoFragment : Fragment() {

    private var _binding: FragmentIndicacaoBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIndicacaoBinding.inflate(inflater, container, false)



        return binding.root
    }
}