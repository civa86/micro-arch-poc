package info.civa86.authservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.civa86.authservice.repository.RoleRepository;
import info.civa86.authservice.model.Role;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findRoleById(Integer id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.isPresent() ? role.get() : null;
    }

}
