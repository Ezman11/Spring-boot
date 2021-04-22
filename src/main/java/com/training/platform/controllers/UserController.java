package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/findAll")
    public List<User> findAll() {
        // Change from UserRepository to UserService
        return userService.findAllByJpqlParamsQuery(0, "bangkok");
    }

    @GetMapping(value = "/findById{id}")
    public Optional<User> findById(@PathVariable String id) {
        // Change from UserRepository to UserService
        return userService.findById(Integer.parseInt(id));
    }

    @GetMapping(value = "/findAllByLimit/")
    public Page<User> findAllByLimit(@RequestParam String start,@RequestParam String limit,@RequestParam String field) {
        // Change from UserRepository to UserService
        return userService.findAllByLimit(Integer.parseInt(start),Integer.parseInt(limit),field) ;

    }

    @GetMapping(value = "/findByCityAndActiveAndAge/")
    public List<User> findByCityAndActiveAndAge(@RequestParam String city,@RequestParam String active,@RequestParam String age) {
        // Change from UserRepository to UserService
        return userService.findByCityAndActiveAndAge(city,Integer.parseInt(active),Integer.parseInt(age)) ;

    }

    @GetMapping(value = "/findByAgeIn")
    public List<User> findByAgeIn(@RequestParam(name = "age" ) List<Integer> listage) {
        // Change from UserRepository to UserService
        return userService.findByAgeIn(listage) ;
    }

    @GetMapping(value = "/findAllByQuery")
    public List<User> findAllByQuery() {
        // Change from UserRepository to UserService
        return userService.findAllByQuery() ;
    }

    @GetMapping(value = "/findAllByParamsQuery")
    public List<User> findAllByParamsQuery(@RequestParam String active,@RequestParam String city) {
        // Change from UserRepository to UserService
        return userService.findAllByParamsQuery(Integer.parseInt(active), city) ;
    }

    @GetMapping(value = "/findAllByJpqlQuery")
    public List<User> findAllByJpqlQuery() {
        // Change from UserRepository to UserService
        return userService.findAllByJpqlQuery() ;
    }

    @GetMapping(value = "/findAllByJpqlParamsQuery")
    public List<User> findAllByJpqlParamsQuery(@RequestParam String active,@RequestParam String city) {
        // Change from UserRepository to UserService
        return userService.findAllByJpqlParamsQuery(Integer.parseInt(active), city) ;
    }

    @GetMapping(value = "/findByAgeGreaterThan")
    public List<User> findByAgeGreaterThan(@RequestParam String age) {
        // Change from UserRepository to UserService
        return userService.findByAgeGreaterThan(Integer.parseInt(age)) ;
    }

    @GetMapping(value = "/findByAgeLessThan")
    public List<User> findByAgeLessThan(@RequestParam String age) {
        // Change from UserRepository to UserService
        return userService.findByAgeLessThan(Integer.parseInt(age)) ;
    }
}
