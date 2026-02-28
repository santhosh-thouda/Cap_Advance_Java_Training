package com.capgemini.library.service;

import com.capgemini.library.entity.Member;

import java.util.List;

public interface MemberService {

    Member addMember(Member member);

    Member getMemberById(Long id);

    List<Member> getAllMembers();

    Member updateMember(Long id, Member member);

    void deleteMember(Long id);
}