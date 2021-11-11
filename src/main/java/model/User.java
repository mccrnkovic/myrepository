package model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Data
@Entity(name = "User")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotBlank(message = "You did not give a name")
    private String username;

    @NotBlank(message = "You did not give an email")
    private String email;

    @NotNull
    @Size(min=4, message = "Password must contain at least 4 characters")
    private String password;

    @NotBlank(message = "You did not give a headquarters")
    private String hq;

    private Boolean admin;

    @OneToOne
    @Valid
    private BankAccount bankAccount;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date founded;

    @OneToMany
    private Set<User> partners = new HashSet<User>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static class UserBuilder {
        private String username;
        private String password;
        private String email;
        private String hq;
        private BankAccount bankAccount;

        public UserBuilder() {

        }

        public UserBuilder setBankAccount(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        public UserBuilder(String username) {
            this.username = username;
        }

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setHq(String hq) {
            this.hq = hq;
            return this;
        }

        public User build(){
            User user= new User();
            user.setHq(this.hq);
            user.setUsername(this.username);
            user.setEmail(this.email);
            user.setPassword(this.password);
            user.setBankAccount(this.bankAccount);
            return user;
        }

        public User tmp(){
            BankAccount.BankAccountBuilder bankAccountBuilder = new BankAccount.BankAccountBuilder("tmpiban");
            bankAccountBuilder.setBalance(0.0);
            User user = new User();
            user.setUsername("tmpUser");
            user.setBankAccount(bankAccountBuilder.build());
            user.setPassword("tmppass");
            user.setHq("tmphq");
            user.setEmail("tmpemail");
            return user;
        }
    }

}
