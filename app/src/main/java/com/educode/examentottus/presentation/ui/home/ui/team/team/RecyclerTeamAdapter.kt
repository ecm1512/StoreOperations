package com.educode.examentottus.presentation.ui.home.ui.team.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.educode.examentottus.databinding.CardTeamBinding
import com.educode.examentottus.domain.model.Team
import kotlin.properties.Delegates

class RecyclerTeamAdapter(private var listenerTeamItem: (Team) -> Unit): RecyclerView.Adapter<RecyclerTeamAdapter.CardTeamHolder>()  {

    var teams: List<Team> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTeamHolder {
        val binding = CardTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardTeamHolder(binding)
    }

    override fun onBindViewHolder(holder: CardTeamHolder, position: Int) {
        val team = teams[position]
        holder.itemView.setOnClickListener { listenerTeamItem(team) }
        holder.setDataCard(team)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    class CardTeamHolder(private val binding: CardTeamBinding): RecyclerView.ViewHolder(binding.root) {
        fun setDataCard(team: Team) {

            binding.tvTeamId.text = team.id.toString()
            binding.tvNameTeam.text = team.name
            binding.tvPhraseTeam.text = team.phrase
        }
    }
}