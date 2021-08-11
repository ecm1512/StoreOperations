package com.educode.examentottus.presentation.ui.home.ui.team.member

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.educode.examentottus.databinding.CardMemberBinding
import com.educode.examentottus.domain.model.Member
import kotlin.properties.Delegates

class RecyclerMemberAdapter: RecyclerView.Adapter<RecyclerMemberAdapter.CardMemberHolder>()  {


    var members: List<Member> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardMemberHolder {
        val binding = CardMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardMemberHolder(binding)
    }

    override fun onBindViewHolder(holder: CardMemberHolder, position: Int) {
        val member = members[position]
        //holder.itemView.setOnClickListener { listenerTeamItem(team) }
        holder.setDataCard(member)
    }

    override fun getItemCount(): Int {
        return members.size
    }

    class CardMemberHolder(private val binding: CardMemberBinding): RecyclerView.ViewHolder(binding.root) {
        fun setDataCard(member: Member) {

            binding.tvMemberId.text = member.id.toString()
            binding.tvNameMember.text = member.name
            binding.tvMailMember.text = member.mail
        }
    }
}