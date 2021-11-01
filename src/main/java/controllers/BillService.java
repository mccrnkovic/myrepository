package controllers;

import lombok.extern.slf4j.Slf4j;
import model.Bill;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BillService{

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> loadAllByUser(User user){
        return billRepository.findAllByBuyerAndSeller(user);
    }
}
