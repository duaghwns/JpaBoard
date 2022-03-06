package com.example.demo.service;

import com.example.demo.dto.MemberDto;

public interface MemberService {
    MemberDto sign(MemberDto member);
    MemberDto login(MemberDto member);
}
