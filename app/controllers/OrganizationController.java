package controllers;

import dal.OrganizationDAL;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class OrganizationController extends Controller{

    OrganizationDAL organizationDAL = new OrganizationDAL();

    public Result getAllOrganiztions()
    {
        return ok(Json.toJson(organizationDAL.getAll()));
    }
}
