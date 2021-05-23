package com.reportapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reportapp.entity.UserData;

public interface UserDataRepository extends JpaRepository<UserData, Long>{

}
