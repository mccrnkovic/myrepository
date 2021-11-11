package controllers;

import model.BankAccount;
import model.Bill;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    public static User user = (new User.UserBuilder()).tmp();
    private Bill bill = new Bill();

    @Test
    public void userRepositoryTest(){
        entityManager.persist(this.user);
        entityManager.flush();
        User test = userRepository.findByUsername(this.user.getUsername());
        assertThat(test.getUsername()).isEqualTo(this.user.getUsername());
    }

}
