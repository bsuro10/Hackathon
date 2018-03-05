package controllers;

import dal.EventDAL;
import dal.UserDAL;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class EventController extends Controller {

    private EventDAL eventDAL = new EventDAL();

    public Result getAll() {
        return ok(Json.toJson(eventDAL.getAll()));
    }

    public Result getUnApproveEventsByOrgEvents() {
        UserDAL userDAL = new UserDAL();
        User currUser = userDAL.getById(session().get("username"));
        return ok(Json.toJson(eventDAL.getUnApproveEventsByOrgEvents(currUser.getOrganization().getId())));
    }
}
