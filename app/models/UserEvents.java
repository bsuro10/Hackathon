package models;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name="t_event_user")
public class UserEvents extends Model {

    @Id
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;

    @Column(name="hours")
    private int hours;

    @Column(name="approve")
    private boolean approve;

    public UserEvents(int id, User user, Event event, int hours, boolean approve) {
        this.setId(id);;
        this.setUser(user);
        this.setEvent(event);
        this.setHours(hours);
        this.setApprove(approve);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }
}
