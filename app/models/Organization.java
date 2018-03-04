package models;

import io.ebean.Model;

import javax.persistence.*;

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

    @Column(name="image")
    private String image_url;

    @OneToMany(targetEntity = Users.class, mappedBy = "username")
    @JoinColumn(name="manager_id")
    private Users manager;

    public Organization(int id, String name, String address, String desc, String image_url, Users manager) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setDesc(desc);
        this.setImage_url(image_url);
        this.setManager(manager);
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Users getManager() {
        return manager;
    }

    public void setManager(Users manager) {
        this.manager = manager;
    }
}
