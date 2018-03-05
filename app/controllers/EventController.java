package controllers;

import dal.EventDAL;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class EventController extends Controller {

    private EventDAL eventDAL = new EventDAL();

    public Result getAll() {
        return ok(Json.toJson(eventDAL.getAll()));
    }
}
