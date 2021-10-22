package controllers;

import model.BankAccount;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@ComponentScan
public class UserService{

    private UserRepository userRepository;
    private BankAccountRepository bankAccountRepository;

    @Autowired
    public UserService(UserRepository userRepository, BankAccountRepository bankAccountRepository) {
        this.userRepository = userRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    public ArrayList<User> selectAll(){
        return (ArrayList<User>) userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public void addBankAccount(BankAccount bankAccount){
        bankAccountRepository.save(bankAccount);
    }
}
