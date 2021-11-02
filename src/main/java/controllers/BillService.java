package controllers;

import lombok.extern.slf4j.Slf4j;
import model.BankAccount;
import model.Bill;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BillService{

    private final BillRepository billRepository;
    private final UserService userService;

    @Autowired
    public BillService(BillRepository billRepository, UserService userService) {
        this.billRepository = billRepository;
        this.userService = userService;
    }

    public List<Bill> loadAllByUser(User user){
        return billRepository.findAllByBuyerOrSeller(user, user);
    }

    public void addBill(Bill bill){
        User user;
        try {
            user = (User) userService.loadUserByUsername(bill.getBuyer().getUsername());
            bill.setBuyer(user);
            billRepository.save(bill);
        }
        catch (UsernameNotFoundException e){
            BankAccount.BankAccountBuilder bankAccountBuilder = new BankAccount.BankAccountBuilder("tmpiban");
            bankAccountBuilder.setBalance(0.0);
            User.UserBuilder userBuilder = new User.UserBuilder("tmpUser");
            user=userBuilder.tmp();
            user.setUsername(bill.getBuyer().getUsername());
            bill.setBuyer(user);
            userService.addUser(user);
            billRepository.save(bill);
        }
    }
}
