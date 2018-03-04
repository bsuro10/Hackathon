package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dal.UserDAL;
import dal.UserEventsDAL;
import io.ebean.Ebean;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller {

    private UserDAL userDAL = new UserDAL();
    private UserEventsDAL eventsDAL = new UserEventsDAL();

    public Result getUserByUsername() {
        return ok(Json.toJson(userDAL.getById(session().get("username"))));
    }

    public Result userLogin(String username) {
        session().put("username", username);
        return ok();
    }

    public Result events() {
        return ok(Json.toJson(eventsDAL.getByUsername(session().get("username"))));
    }
}
