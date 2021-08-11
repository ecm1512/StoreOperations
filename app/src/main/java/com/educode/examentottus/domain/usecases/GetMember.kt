package com.educode.examentottus.domain.usecases

import com.educode.examentottus.data.repository.MemberRepository
import com.educode.examentottus.domain.model.Member

class GetMember(private val memberRepository: MemberRepository) {
    suspend fun invoke(idTeam: Int): List<Member> {
        return memberRepository.getMember(idTeam)
    }
}