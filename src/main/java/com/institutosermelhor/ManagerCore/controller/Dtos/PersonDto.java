package com.institutosermelhor.ManagerCore.controller.Dtos;

import com.institutosermelhor.ManagerCore.infra.security.Role;

public record PersonDto(String username, String email, Role role) {

}
