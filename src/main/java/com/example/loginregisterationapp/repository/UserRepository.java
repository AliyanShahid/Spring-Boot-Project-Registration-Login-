package com.example.loginregisterationapp.repository;

import com.example.loginregisterationapp.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData,Integer> {

    public UserData findByEmail(String em);
}
