package controllers;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService implements UserDetailsService {

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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUsername(username);
        if(user != null){
            return user;
        }
        else {
            throw new UsernameNotFoundException(username + "not found.");
        }
    }

    public User getCurrentUser(){
        String username=((UserDetails)SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getUsername();

        return (User) loadUserByUsername(username);
    }
}
