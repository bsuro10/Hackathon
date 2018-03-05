package dal;

import models.User;

public class UserDAL extends BaseDAL<User> {

    public UserDAL() {
        super(User.class);
    }
}
