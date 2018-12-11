package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Model;
import models.Role;
import javax.persistence.*;

@Entity
@Table(name="t_users")
public class User extends Model {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="fullname")
    private String fullname;

    @Column(name="cellphone")
    private String cellphone;

    @Column(name="city")
    private String city;

    @Column(name="address")
    private String address;

    @Column(name="school")
    private String school;

    @Column(name="sch_class")
    private String sch_class;

    @Column(name="req_hours")
    private int req_hours;

    @Column(name="curr_hours")
    private int curr_hours;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name="org_id")
    private Organization organization;

    public User(String username,
                String password,
                String city,
                String address,
                String school,
                String sch_class,
                int req_hours,
                int curr_hours,
                Role role,
                String cellphone,
                Organization org,
                String fullname) {
      
        this.setUsername(username);
        this.setPassword(password);
        this.setCity(city);
        this.setAddress(address);
        this.setSch_class(sch_class);
        this.setSchool(school);
        this.setReq_hours(req_hours);
        this.setCurr_hours(curr_hours);
        this.setRole(role);
        this.setCellphone(cellphone);
        this.setOrganization(org);
        this.setFullname(fullname);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSch_class() {
        return sch_class;
    }

    public void setSch_class(String sch_class) {
        this.sch_class = sch_class;
    }

    public int getReq_hours() {
        return req_hours;
    }

    public void setReq_hours(int req_hours) {
        this.req_hours = req_hours;
    }

    public int getCurr_hours() {
        return curr_hours;
    }

    public void setCurr_hours(int curr_hours) {
        this.curr_hours = curr_hours;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @JsonBackReference
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
