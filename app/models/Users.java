package models;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name="t_users")
public class Users extends Model {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
