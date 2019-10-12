package ru.igor.task.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    int id;

    @NotBlank
    @Size(min = 5, max = 100)
    String login;

    @NotBlank
    @Size(min = 2, max = 100)
    String password;

    @NotBlank
    @Size(min = 5, max = 100)
    String email;

    @NotBlank
    @Size(min = 2, max = 50)
    String fio;

    @ElementCollection(fetch = FetchType.EAGER)
    List<GrantedAuthority> grantList;

    public User() {
    }

    public User(int id, String login, String password, String email, String fio) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fio = fio;
        setGrantList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public List getGrantList() {
        return grantList;
    }

    //hard
    public void setGrantList() {
        this.grantList = new ArrayList<>();
        this.grantList.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        if (!fio.equals(user.fio)) return false;
        return grantList.equals(user.grantList);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + fio.hashCode();
        result = 31 * result + grantList.hashCode();
        return result;
    }
}
