package com.quinnox.training.clowns;
/*
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.training.clowns.userspef.RegisterDTO;
import com.quinnox.training.clowns.userspef.Role;
import com.quinnox.training.clowns.userspef.UserService;
import com.quinnox.training.clowns.userspef.Users;

@RestController
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
    	this.userService = userService;
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<ArrayList<String>> login(@RequestBody LoginDTO login) {
        System.out.println("Login controller");
        ArrayList<String> token = userService.loginUser(login);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

	@PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody RegisterDTO register) {
    	System.out.println("Registering");
    	Users user = register.conversion();
    	user.setRole(Role.USER);
        userService.newUser(user);
    	
        return new ResponseEntity<>(user, HttpStatus.OK);    	
    }
	
	@PostMapping("/logout")
	public ResponseEntity<Users> logout(@RequestBody LoginDTO logout) {
		
		System.out.println("Logging out");
		Users user = userService.logoutUser(logout);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
*/


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.training.clowns.userspef.UserRepository;
import com.quinnox.training.clowns.userspef.JwtUtils;
import com.quinnox.training.clowns.userspef.UserDetailsImpl;
import com.quinnox.training.clowns.RespReqs.MessageResponse;
import com.quinnox.training.clowns.RespReqs.JwtResponse;
import com.quinnox.training.clowns.userspef.Role;
import com.quinnox.training.clowns.userspef.Users;







@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class LoginController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;
  
  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    Role role = Role.valueOf(userDetails.getAuthorities().iterator().next().getAuthority());
    
    return new ResponseEntity<JwtResponse>(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), role), HttpStatus.OK);
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody LoginDTO signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }

    // Create new user's account
    Users user = new Users(signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

    if(signUpRequest.getRole()!= null) {
        Role role = signUpRequest.getRole();
        user.setRole(role);
    }
    else {
    	user.setRole(Role.USER);
    }

    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}