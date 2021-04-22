package com.humanresource.hrrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.humanresource.entities.HrLoginEntity;

@Repository
public interface HrRepository extends JpaRepository<HrLoginEntity, String> {

}
