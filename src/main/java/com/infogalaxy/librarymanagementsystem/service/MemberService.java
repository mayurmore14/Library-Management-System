package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import com.infogalaxy.librarymanagementsystem.repo.IMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService implements IMemberService{

    @Autowired
    IMemberRepo iMemberRepo;

    /***
     * creating an method use to add new member
     * @param memberEntity
     * @return ruturning object of entity class which is containing data of member
     */
    public MemberEntity createMember(MemberEntity memberEntity) {
        return iMemberRepo.save(memberEntity);
    }
}
