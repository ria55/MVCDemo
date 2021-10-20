package application.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {

    private String username;
    private String password;
    private int age;

    private UserRole role;

    private boolean isEnabled;

    public User() {
        isEnabled = true;
    }

    public User(String username, String password, int age, UserRole role) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.role = role;
        isEnabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();

        /*for (UserAuthority auth : role.AUTHORITIES) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(auth.toString());
            list.add(authority);
        }*/

        list.add(new SimpleGrantedAuthority("ADD"));

        return list;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

}
