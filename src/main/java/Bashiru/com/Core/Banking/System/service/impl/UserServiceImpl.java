package Bashiru.com.Core.Banking.System.service.impl;

import Bashiru.com.Core.Banking.System.entity.User;
import Bashiru.com.Core.Banking.System.repository.UserRepository;
import Bashiru.com.Core.Banking.System.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User findUserByName(String userName) throws Exception {
        try {
            return userRepository.findUserByName(userName);
        }catch (Exception e){
            LOGGER.error("Failed to fetch user. Status = Fail, error {}", e.getMessage());
            throw new Exception("Error occurred " + e.getMessage());
        }
    }

    @Override
    public List<User> findUsers() throws Exception {
         return userRepository.findAllUsers();

    }
}