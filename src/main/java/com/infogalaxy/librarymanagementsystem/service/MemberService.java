package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import com.infogalaxy.librarymanagementsystem.exceptions.MemberNotFoundException;
import com.infogalaxy.librarymanagementsystem.model.MemberModel;
import com.infogalaxy.librarymanagementsystem.repo.IMemberRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService implements IMemberService{

    /***
     * to create object of member repo interface
     */
    @Autowired
    IMemberRepo iMemberRepo;

    /***
     * creating an method use to add new member
     * @param memberModel - object of library member
     * @return - object of entity class which is containing data of member
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
    public Optional<MemberEntity> retrieveMemberById(int id) {
        Optional<MemberEntity> memberEntity = iMemberRepo.findById(id);
        if (memberEntity.isPresent()) {
            return memberEntity;
        } else {
            throw new MemberNotFoundException("Member with Given ID is not Found in Database");
        }

    }

    /***
     * method to Update member's data by their ID
     * @param id - Access member data by given Id from database
     * @param memberModel - object of model class containing new data for update
     * @return - updated data of member
     */
    public MemberEntity updateMemberById(int id, MemberModel memberModel) {
        MemberEntity memberEntity = retrieveMemberById(id).get();
        BeanUtils.copyProperties(memberModel,memberEntity);
        return iMemberRepo.save(memberEntity);
    }

    /***
     * method to Delete Member's Data form database by their ID
     * @param id Access member data by given Id from database
     * @return - Message of Deletion
     */
    public String deleteMemberById(int id) {
        MemberEntity memberEntity = retrieveMemberById(id).get();
        iMemberRepo.delete(memberEntity);
        return "Library Member's Data Deleted Successfully...";
    }
}
