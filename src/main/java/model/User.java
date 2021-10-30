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

}
