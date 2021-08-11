package com.educode.examentottus.presentation.ui.home.ui.team.member

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.educode.examentottus.R
import com.educode.examentottus.databinding.FragmentMemberBinding
import com.educode.examentottus.databinding.FragmentTeamBinding
import com.educode.examentottus.presentation.ui.home.ui.team.team.RecyclerTeamAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class MemberFragment : ScopeFragment() {
    private val memberViewModel: MemberViewModel by viewModel()
    private var _binding: FragmentMemberBinding? = null
    private lateinit var membersAdapter: RecyclerMemberAdapter

    private val binding get() = _binding!!

    private lateinit var args: MemberFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMemberBinding.inflate(inflater, container, false)

        arguments?.let {
            args = MemberFragmentArgs.fromBundle(it)
        }

        memberViewModel.getMember(args.id)

        view()

        listenData(binding)

        binding.btnNewMember.setOnClickListener {
            val bottomSheet = BottomSheetDialog(requireActivity())
            val view = layoutInflater.inflate(R.layout.layout_bottom_sheet,null)

            val btnRegistrar = view.findViewById<Button>(R.id.btn_registrar)!!

            bottomSheet.setContentView(view)
            bottomSheet.show()

            btnRegistrar.setOnClickListener {

                val txtNombre = bottomSheet.findViewById<EditText>(R.id.et_member_name_create)?.text.toString()
                val txtMail = bottomSheet.findViewById<EditText>(R.id.et_member_mail_create)?.text.toString()
                memberViewModel.insertMember(txtNombre,txtMail,args.id).observe(requireActivity()){
                    if(it){
                        Toast.makeText(requireContext(),"Miembro Creado", Toast.LENGTH_SHORT).show()
                        membersAdapter.notifyDataSetChanged()
                        bottomSheet.dismiss()

                    }else{
                        Toast.makeText(requireContext(),"Miembro no se pudo crear", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }

        binding.btnDeleteMember.setOnClickListener { view->
            // TODO
        }

        return binding.root
    }

    private fun view() {
        membersAdapter = RecyclerMemberAdapter()

    }

    private fun listenData(binding: FragmentMemberBinding) {
        memberViewModel.data.observe(requireActivity(), {
            membersAdapter.members = it

        })
        binding.rvMembers.adapter = membersAdapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}