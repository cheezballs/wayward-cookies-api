package us.mattroberts.waywardcookies.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import us.mattroberts.waywardcookies.service.OrderService;

import java.security.Principal;

@RestController
@Slf4j
public class AuthController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/login")
    public ResponseEntity<?> login(Principal principal) {
        // this should return appropriately for non-successes
        log.debug("User successfully logged in : " + principal.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}