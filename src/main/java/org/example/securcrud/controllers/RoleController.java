package org.example.securcrud.controllers;

import lombok.RequiredArgsConstructor;
import org.example.securcrud.model.Role;
import org.example.securcrud.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private RoleService roleService;

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping
    public Role save(@RequestBody Role role) {
        return roleService.addRole(role);
    }
}
