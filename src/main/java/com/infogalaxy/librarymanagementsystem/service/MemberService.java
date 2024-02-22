package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import com.infogalaxy.librarymanagementsystem.model.MemberModel;
import com.infogalaxy.librarymanagementsystem.repo.IMemberRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MemberService implements IMemberService{

    @Autowired
    IMemberRepo iMemberRepo;

    /***
     * creating an method use to add new member
     * @param memberModel
     * @return ruturning object of entity class which is containing data of member
     */
    public MemberEntity createMember(MemberModel memberModel) {
        MemberEntity memberEntity = new MemberEntity();
        BeanUtils.copyProperties(memberModel,memberEntity);
        return iMemberRepo.save(memberEntity);
    }

    /***
     * Method to Get All Members data
     * @return List of MemberEntity objects
     */
    public List<MemberEntity> retrieveMember() {
        return iMemberRepo.findAll();
    }
}
