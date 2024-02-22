package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import com.infogalaxy.librarymanagementsystem.model.MemberModel;

import java.util.List;

public interface IMemberService {

    public MemberEntity createMember(MemberModel memberModel);

    public List<MemberEntity> retrieveMember();

}
