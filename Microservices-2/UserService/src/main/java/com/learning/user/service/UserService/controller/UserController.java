package com.learning.user.service.UserService.controller;

import com.learning.user.service.UserService.model.User;
import com.learning.user.service.UserService.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    int retryCount=1;
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody  User user){
       User user1= userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
//    @Retry(name = "retryHotelService",fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        logger.info("Retry count {}",retryCount++);
        User user1= userService.getUserById(userId);
        return  ResponseEntity.status(HttpStatus.OK).body(user1);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users= userService.getAllUsers();
        return  ResponseEntity.status(HttpStatus.OK).body(users);
    }

    //create ratingHotelFallback method for circuit breaker

    public ResponseEntity<User> ratingHotelFallBack(String userId,Exception e){

        logger.error("Fallback is executed since service is down {} ",e);
        User user = User.builder().email("dummy@gmail.com").name("dummy").about("This user is created dummy because some service is down").build();
        return new ResponseEntity<>(user,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
