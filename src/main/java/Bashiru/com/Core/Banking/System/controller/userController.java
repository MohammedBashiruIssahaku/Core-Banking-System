package Bashiru.com.Core.Banking.System.controller;

import Bashiru.com.Core.Banking.System.entity.User;
import Bashiru.com.Core.Banking.System.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController
{
    UserRepository userRepository;

    @GetMapping("{name}")
    @RequestMapping("/findUser")
    public User findUserByName(@PathVariable String name) throws Exception
    {
           return userRepository.findUserByName(name);

    }


    @GetMapping
    @RequestMapping("/findAllUsers")
    public void findAllUsers()
    {
        userRepository.findAllUsers();
    }

}
