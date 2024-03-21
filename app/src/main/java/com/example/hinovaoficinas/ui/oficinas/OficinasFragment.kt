package com.example.hinovaoficinas.ui.oficinas

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hinovaoficinas.R
import com.example.hinovaoficinas.databinding.FragmentOficinasBinding
import com.example.hinovaoficinas.models.OficinaApiModel
import com.example.hinovaoficinas.ui.componentes.adapter.OficinasAdapter
import com.example.hinovaoficinas.ui.componentes.dialog.OficinaDialog
import com.example.hinovaoficinas.viewmodel.MainViewModel

class OficinasFragment : Fragment(), OficinasAdapter.RecyclerViewEvent {

    private var _binding: FragmentOficinasBinding? = null
    private val binding get() = _binding!!

    var item: List<OficinaApiModel> = listOf()
    override fun onItemClicked(position: Int) {
        OficinaDialog(item[position]).show(
            childFragmentManager,
            OficinaDialog.TAG
        )
    }

    private var oficinasAdapter: OficinasAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        _binding = FragmentOficinasBinding.inflate(inflater, container, false)

        mainViewModel.receberOficinas()

        mainViewModel.listaOficinasCarregado.observe(viewLifecycleOwner, Observer { resposta ->
            item = resposta.ListaOficinas
            oficinasAdapter = OficinasAdapter(resposta.ListaOficinas, this)
            binding.rvItensOfinas.adapter = oficinasAdapter
        })

        return binding.root
    }

}