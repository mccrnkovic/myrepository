package controllers;

import model.Bill;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    private BillService billService;

    @MockBean
    private BillRepository billRepository;


    @Before
    public void setUp(){
        Bill bill = new Bill();
        bill.setSeller(RepositoryTest.user);
        List<Bill> bills = new ArrayList<>();
        bills.add(bill);
        Mockito.when(billRepository.findAllByBuyerOrSeller(RepositoryTest.user, RepositoryTest.user))
                .thenReturn(bills);
    }

    @Test
    public void billServiceTest(){
        assertThat(billService.loadAllByUser(RepositoryTest.user).stream()
                .map(bill -> bill.getSeller())).asList().contains(RepositoryTest.user);
    }
}
