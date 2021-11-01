package controllers;

import model.Bill;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    List<Bill> findAllByBuyerAndSeller(User user);

}
