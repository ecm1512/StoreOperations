package com.educode.examentottus.domain.usecases

import com.educode.examentottus.data.repository.MemberRepository
import com.educode.examentottus.data.repository.TeamRepository
import com.educode.examentottus.domain.model.Member

class InsertMember(private val memberRepository: MemberRepository) {
    suspend fun invoke( name: String, mail: String, idTeam: Int) {
        val member = Member(name,mail,idTeam)
        return memberRepository.insertMember(member)
    }
}
