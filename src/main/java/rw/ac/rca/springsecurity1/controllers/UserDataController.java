package rw.ac.rca.springsecurity1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.springsecurity1.entity.AuthRequest;
import rw.ac.rca.springsecurity1.entity.UserData;
import rw.ac.rca.springsecurity1.payload.ApiResponse;
import rw.ac.rca.springsecurity1.service.JwtService;
import rw.ac.rca.springsecurity1.service.UserDataService;
import rw.ac.rca.springsecurity1.utils.ExceptionUtils;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserDataController {
    @Autowired
    private UserDataService service;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<ApiResponse>  addNewUser(@RequestBody UserData userData) {
        try{
            return ResponseEntity.ok(new ApiResponse(true,"User added successfully",service.addUser(userData)));
        }catch (Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }
    @GetMapping("/admin/list")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserData> listUsers() {
        return service.listAll();
    }
    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try{
            System.out.println("heree!!");
            UserDetails userDetails = service.loadUserByUsername(authRequest.getUsername());
            System.out.println(userDetails);
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(authRequest.getUsername());
            } else {
                throw new UsernameNotFoundException("invalid user request !");
            }

    }catch (Exception e){
            e.printStackTrace();
        return ExceptionUtils.handleControllerExceptions(e).toString();
    }

    }
}




