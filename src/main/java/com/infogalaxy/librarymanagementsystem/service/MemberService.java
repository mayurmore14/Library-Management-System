package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;

import java.util.ArrayList;
import java.util.List;

public class MemberService {

    List<MemberEntity> memberEntityList = new ArrayList<>();
    public MemberEntity createMember(MemberEntity memberEntity) {
        memberEntityList.add(memberEntity);
        return memberEntity;
    }
}
