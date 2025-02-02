package com.prj.service;

import com.prj.entities.Role;
import com.prj.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public Optional<Role> updateRole(Long id, Role roleDetails) {
        return roleRepository.findById(id).map(role -> {
            role.setRoleName(roleDetails.getRoleName());
            return roleRepository.save(role);
        });
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
