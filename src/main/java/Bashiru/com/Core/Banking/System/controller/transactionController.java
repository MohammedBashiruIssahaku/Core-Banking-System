package Bashiru.com.Core.Banking.System.controller;

import Bashiru.com.Core.Banking.System.entity.Transaction;
import Bashiru.com.Core.Banking.System.repository.UserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class transactionController
{
    UserRepository userRepository;

    @DeleteMapping
    @RequestMapping({"id"})
    public void withdraw(@PathVariable long id)
    {
         userRepository.deleteById(id);
    }

    




}
