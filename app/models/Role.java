package models;

import io.ebean.Model;
import javax.persistence.*;

@Entity
@Table(name="t_roles")
public class Role extends Model{

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    public Role(int id, String name) {
        this.setId(id);
        this.setName(name);
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
}
