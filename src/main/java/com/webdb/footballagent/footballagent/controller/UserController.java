package com.webdb.footballagent.footballagent.controller;



import com.webdb.footballagent.footballagent.config.TokenProvider;
import com.webdb.footballagent.footballagent.dto.UserDto;
import com.webdb.footballagent.footballagent.model.AuthToken;
import com.webdb.footballagent.footballagent.model.Selection;
import com.webdb.footballagent.footballagent.model.User;
import com.webdb.footballagent.footballagent.request.UserLoginRequest;
import com.webdb.footballagent.footballagent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/football_agent/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody UserLoginRequest userLoginRequest) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginRequest.getUsername(),
                        userLoginRequest.getPassword(), null
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String token = generateToken( user.getEmail() );

        final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }

    @RequestMapping(value="/{username}/add_selection", method = RequestMethod.POST)
    public void addSelection(@RequestBody Selection selection ,@PathVariable String username){
        userService.addSelection(selection, username);
    }

    @RequestMapping(value="/{username}/get_all_selections", method = RequestMethod.GET)
    public List<Selection> getAllSelections(@PathVariable String username){
      return  userService.getAllSelections(username);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/adminping", method = RequestMethod.GET)
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/userping", method = RequestMethod.GET)
    public String userPing(){
        return "Any User Can Read This";
    }

}
