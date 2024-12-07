package Bashiru.com.Core.Banking.System.service;

import Bashiru.com.Core.Banking.System.entity.User;

public interface UserService {
    User findUserByUserNameAndPassword(String userName, String password) throws Exception;
}

