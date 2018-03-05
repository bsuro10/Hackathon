package dal;

import io.ebean.Ebean;
import models.User;

import java.util.List;

public class UserDAL extends BaseDAL<User> {

    public UserDAL() {
        super(User.class);
    }

    public List<User> getAllUsersBySchoolAndClass(String school, String schClass) {
        return (Ebean.find(User.class).where().eq("school", school).eq("sch_class",schClass).findList());
    }
}
