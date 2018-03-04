package controllers;

import dal.UserDAL;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller {

    private UserDAL userDAL = new UserDAL();

    public Result getUserByUsername(String username) {
        return ok(Json.toJson(userDAL.getById(username)));
    }
}
