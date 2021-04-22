package com.humanresource.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.humanresource.entities.HrLoginEntity;
import com.humanresource.hrrepository.HrRepository;


@Component
public class HrLoginDao {

    @Autowired
    private HrRepository hrRepository;
    
    public HrLoginEntity getEntity(String username) {
        Optional<HrLoginEntity> hrOptional=this.hrRepository.findById(username);
        return hrOptional.get();
        
    }
    public boolean checkPassword(HrLoginEntity hr) {
        if(hr.getUsername()==null) {
            System.out.println("length");
            return false;
        }
        HrLoginEntity entity=getEntity(hr.getUsername());
        if(entity.getPassword().equals(hr.getPassword()))
            return true;
        return false;
        
    }
}
