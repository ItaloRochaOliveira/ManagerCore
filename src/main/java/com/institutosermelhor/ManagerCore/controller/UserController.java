package com.institutosermelhor.ManagerCore.controller;

import com.institutosermelhor.ManagerCore.controller.Dtos.UserDto;
import com.institutosermelhor.ManagerCore.models.entity.User;
import com.institutosermelhor.ManagerCore.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "Users")
public class UserController {

  UserService service;

  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<UserDto>> getUsers() {
    List<User> users = service.getUsers();
    List<UserDto> usersDto = users.stream()
        .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail(), user.getRole()))
        .toList();

    return ResponseEntity.status(HttpStatus.OK).body(usersDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable String id) {
    User user = service.findById(id);
    UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail(),
        user.getRole());

    return ResponseEntity.status(HttpStatus.OK).body(userDto);
  }

  @DeleteMapping("{userId}")
  public ResponseEntity<Void> delete(@PathVariable String userId) {
    service.delete(userId);
    return ResponseEntity.noContent().build();
  }
}
