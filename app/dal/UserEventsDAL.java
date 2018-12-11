package dal;
import io.ebean.Ebean;
import models.UserEvents;

import java.util.List;

public class UserEventsDAL extends BaseDAL<UserEvents> {

    public UserEventsDAL() {
        super(UserEvents.class);
    }
    public List<UserEvents> getByUsername(String username) {
        return (Ebean.find(UserEvents.class).where().eq("username", username).findList());
    }
}
