package com.example.BasicToAdvance.User.Controller;

import com.example.BasicToAdvance.User.Repository.UserRepository;
import com.example.BasicToAdvance.User.Service.UserServices;
import com.example.BasicToAdvance.User.Service.WeatherService;
import com.example.BasicToAdvance.User.UserDto.UserAuditDto;
import com.example.BasicToAdvance.User.UserDto.User;
import com.example.BasicToAdvance.User.UserDto.UserResponse;
import com.example.BasicToAdvance.User.WeatherApi.WeatherSummaryDTO;
import com.example.BasicToAdvance.contraint.CommonApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(CommonApi.BASE_URL + "/user")
public class UserController extends CommonApi {


    private final UserRepository userRepository;

    private final UserServices userService;
    private final WeatherService weatherService;

    public UserController(UserServices userService,WeatherService weatherService,UserRepository userRepository) {
        this.userService = userService;
        this.weatherService = weatherService;
        this.userRepository = userRepository;
    }
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println(username);
        return new ResponseEntity<>("test", HttpStatus.OK);
    }
    // ✅ Retrieve a user by email
    @GetMapping("/get")
    public ResponseEntity<?> getUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getName();
            System.out.println(email);
            UserResponse user = userService.getUser(email);
            return new ResponseEntity<>(user, HttpStatus.OK); // 200 OK
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found if user doesn't exist
        }
    }

    // ✅ Retrieve a user by ID
    @GetMapping("/getById")
    public ResponseEntity<?> getUserById(@RequestParam UUID id) {
        try {
            UserResponse user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK); // 200 OK
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found if user doesn't exist
        }
    }


    // ✅ Update an existing user
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            UserResponse updatedUser = userService.updateUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK); // 200 OK
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found if user doesn't exist
        }
    }


    @GetMapping("/getWeather")
    public ResponseEntity<?> getWeather(@RequestParam String city) {
        try {
            WeatherSummaryDTO weatherSummary = weatherService.getWeatherSummary(city);
            return new ResponseEntity<>(weatherSummary, HttpStatus.OK); // 200 OK
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found if user doesn't exist
        }
    }



    @GetMapping("/AuditUser")
    public ResponseEntity<?> AuditUser(@RequestParam UUID id) {
        try {
//            List<Revision<Integer, UserSchema>> revisionList = userService.findRevisions(id);
            List<UserAuditDto> revisionList = userService.findRevisions(id);
            return new ResponseEntity<>(revisionList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found if user doesn't exist
        }
    }


}
