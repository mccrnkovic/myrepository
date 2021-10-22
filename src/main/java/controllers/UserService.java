package controllers;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService{

    private UserRepository userRepository;
    private BankAccountRepository bankAccountRepository;

    @Autowired
    public UserService(UserRepository userRepository, BankAccountRepository bankAccountRepository) {
        this.userRepository = userRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    public void addUser(User user) {
        bankAccountRepository.save(user.getBankAccount());
        userRepository.save(user);
        log.info("USER REGISTERED: " + user);
    }


}
