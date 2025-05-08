package com.example.BasicToAdvance.User.Controller;

import com.example.BasicToAdvance.Jarnal.Dto.JarnalResponse;
import com.example.BasicToAdvance.Jarnal.Repository.JarnalRepository;
import com.example.BasicToAdvance.Jarnal.Services.JarnalService;
import com.example.BasicToAdvance.Jarnal.model.JarnalSchema;
import com.example.BasicToAdvance.User.Repository.UserRepository;
import com.example.BasicToAdvance.User.Service.UserServices;
import com.example.BasicToAdvance.User.UserDto.UserResponse;
import com.example.BasicToAdvance.User.UserModel.UserSchema;
import com.example.BasicToAdvance.contraint.CommonApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CommonApi.BASE_URL+"/admin")
public class AdminController {
    private final UserServices userService;
    private final JarnalService jarnalService;

    public AdminController(UserServices userService,JarnalService jarnalService) {
        this.userService = userService;
        this.jarnalService = jarnalService;
    }

    @GetMapping("/jarnals")
    public ResponseEntity<?> jarnals() {
        try {
            List<JarnalResponse> jarnals = jarnalService.getAllJarnals();
            return new ResponseEntity<>(jarnals, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> users() {
       try {
           List<UserResponse> users = userService.getAllUsers();
           return new ResponseEntity<>(users, null, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PutMapping("/add-admin")
    public ResponseEntity<?> addAdmin(
            @RequestParam String email
    ) {
        try {
        UserResponse userResponse = userService.addAdmin(email);
        return new ResponseEntity<>(userResponse, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
