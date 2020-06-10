package com.zelosin.untilJuin.entities.users.info;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "spusers")
@Data
public class SPUser implements UserDetails {

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login")
    private String userName;

    @Column(name = "password")
    private String userPassword;

    @OneToOne(mappedBy = "SPUser", cascade = CascadeType.ALL)
    private LinkedVKAccount linkedVKAccount;

    public SPUser() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
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

    public SPUser(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public boolean hasLinkedAccount() {
        if(linkedVKAccount == null){
            linkedVKAccount = new LinkedVKAccount();
            return false;
        }
        else return linkedVKAccount.getAccessToken() != null;
    }

    public void defineAccountRelation(){
        linkedVKAccount.setSPUser(this);
    }

}
