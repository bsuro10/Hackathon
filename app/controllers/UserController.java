package controllers;

import dal.UserDAL;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller {

    private UserDAL userDAL = new UserDAL();

    public Result getUserByUsername() {
        return ok(Json.toJson(userDAL.getById(session().get("username"))));
    }

    public Result userLogin(String username) {
        session().put("username", username);
        return ok();
    }

    public Result getUsersBySchoolAndClass() {
        User currUser = userDAL.getById(session().get("username"));
        return ok(Json.toJson(userDAL.getAllUsersBySchoolAndClass(currUser.getSchool(), currUser.getSch_class())));
    }
}
