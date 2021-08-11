package com.educode.examentottus.presentation.ui.home.ui.team.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.educode.examentottus.R
import com.educode.examentottus.databinding.DialogTeamBinding
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DialogFragment : ScopeFragment() {

    private lateinit var binding: DialogTeamBinding
    private val viewModel: DialogViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DialogTeamBinding.inflate(inflater, container, false)

        binding.btnNewTeam.setOnClickListener {


            viewModel.insertTeam(binding.etTeamName.text.toString(),binding.etTeamPhrase.text.toString()).observe(requireActivity()){
                if(it){
                    Toast.makeText(requireContext(),"Equipo Creado", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.nav_gallery)
                }else{
                    Toast.makeText(requireContext(),"Equipo no se pudo crear", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }
}