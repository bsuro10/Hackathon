package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_organizations")
public class Organization extends Model {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="description")
    private String desc;

    @OneToMany(targetEntity=User.class, mappedBy="organization")
    private List<User> managers = new ArrayList<User>();

    public Organization(int id, String name, String address, String desc, List<User> lstManagers) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setDesc(desc);
        this.setManagers(lstManagers);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<User> getManagers() {
        return managers;
    }

    public void setManagers(List<User> managers) {
        this.managers = managers;
    }
}
