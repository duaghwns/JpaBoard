package com.example.demo.service.impl;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDto sign(MemberDto member) {
        Member entity = new Member(null, member.getId(), member.getName(),member.getAge(),member.getPassword());
        memberRepository.save(entity);
        member.setSeq(entity.getSeq());
        return member;
    }

    @Override
    public MemberDto login(MemberDto member) {


        return null;
    }
}
