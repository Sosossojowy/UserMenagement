package com.boizband.api;

import com.boizband.users.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UsersApi {

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    ResponseEntity getAllUsers();

    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    ResponseEntity getUser(@PathVariable String userId);

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    ResponseEntity addUser(@RequestBody User user);

    @RequestMapping(path = "/users/{userId}", method = RequestMethod.DELETE)
    ResponseEntity deleteUser(@PathVariable String userId);


    @RequestMapping(path = "/users/{userId}", method = RequestMethod.PUT)
    ResponseEntity updateUser(@PathVariable final String userId, @RequestBody User user);
}
