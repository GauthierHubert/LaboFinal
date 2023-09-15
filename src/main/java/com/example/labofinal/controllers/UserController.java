package com.example.labofinal.controllers;

import com.example.labofinal.models.dto.UserDTO;
import com.example.labofinal.models.forms.UserForm;
import com.example.labofinal.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<Long> add(@RequestBody UserForm form){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.add(form.toEntity()));
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll(){
        return ResponseEntity.ok(userService.getAll().stream().map(UserDTO::toDto).toList());
    }


    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<UserDTO> getOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(UserDTO.toDto(userService.getOne(id)));
    }


    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody UserForm form){
        userService.update(id, form.toEntity());
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
