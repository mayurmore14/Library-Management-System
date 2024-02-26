package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import com.infogalaxy.librarymanagementsystem.model.MemberModel;

import java.util.List;
import java.util.Optional;

public interface IMemberService {

    public MemberEntity createMember(MemberModel memberModel);

    public List<MemberEntity> retrieveMember();

    public Optional<MemberEntity> retrieveMemberById(int id);

    public MemberEntity updateMemberById(int id, MemberModel memberModel);

    public String deleteMemberById(int id);

}
