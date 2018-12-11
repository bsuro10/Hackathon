package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_events")
public class Event extends Model {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="start_date")
    private Date start_date;

    @Column(name="end_date")
    private Date end_date;

    @ManyToOne
    @JoinColumn(name="organization_id")
    private Organization org;

    public Event(int id, String name, String address, Date start_date, Date end_date, Organization org) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setStart_date(start_date);
        this.setEnd_date(end_date);
        this.setOrg(org);
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }
}
