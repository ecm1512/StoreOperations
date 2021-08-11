package com.educode.examentottus.presentation.ui.home.ui.team.team


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.educode.examentottus.R
import com.educode.examentottus.databinding.FragmentTeamBinding
import com.educode.examentottus.domain.model.Team
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamFragment : ScopeFragment() {

    private val teamViewModel: TeamViewModel by viewModel()
    private var _binding: FragmentTeamBinding? = null
    private lateinit var teamsAdapter: RecyclerTeamAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTeamBinding.inflate(inflater, container, false)

        binding.fbAddTeam.setOnClickListener{
            showCreateTeamDialog()
        }

        teamViewModel.getTeam()

        view()

        listenData(binding)

        return binding.root
    }

    private fun view() {
        teamsAdapter = RecyclerTeamAdapter { team -> goToDetailTeam(team) }

    }

    private fun listenData(binding: FragmentTeamBinding) {
        teamViewModel.data.observe(requireActivity(), {
            teamsAdapter.teams = it
        })
        binding.rvTeams.adapter = teamsAdapter
    }

    private fun goToDetailTeam(team: Team) {
        val action = TeamFragmentDirections.actionNavGalleryToMemberFragment(team.id)
        findNavController().navigate(action)
    }

    private fun showCreateTeamDialog() {
        findNavController().navigate(R.id.action_nav_gallery_to_dialogFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}