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
     * @return List of all MemberEntity objects
     */
    public List<MemberEntity> retrieveMember() {
        return iMemberRepo.findAll();
    }

    /***
     * method to Retrieve particular member data by their ID
     * @param id - used id for search data of member
     * @return - object of member found by ID
     */
    public MemberEntity retrieveMemberById(int id) {
        return iMemberRepo.findById(id).get();
    }

    /***
     * mwthod to Update member's data by their ID
     * @param id
     * @param memberModel - object of model class containing new data for update
     * @return - updated data of member
     */
    public MemberEntity updateMemberById(int id, MemberModel memberModel) {
        MemberEntity memberEntity = new MemberEntity();
        BeanUtils.copyProperties(memberModel,memberEntity);
        return iMemberRepo.save(memberEntity);
    }
}
