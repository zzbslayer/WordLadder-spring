package com.example.demo.service;

import com.example.demo.model.RoleEntity;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleEntity> findAll(){
        return roleRepository.findAll();
    }

    public RoleEntity findByUsername(String username){
        return roleRepository.findByUsername(username);
    }

    public List<RoleEntity> findByRolename(String rolename){
        return roleRepository.findByRolename(rolename);
    }
}
