package Bashiru.com.Core.Banking.System.service;

import Bashiru.com.Core.Banking.System.entity.User;

import java.util.List;


public interface UserService {
    User findUserByName(String userName) throws Exception;

    List<User> findUsers() throws Exception;
}

