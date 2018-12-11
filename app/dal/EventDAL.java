package dal;

import io.ebean.Ebean;
import models.Event;
import models.Organization;
import models.User;
import models.UserEvents;
import dal.UserDAL;

import java.util.ArrayList;
import java.util.List;

public class EventDAL extends BaseDAL<Event> {

    public EventDAL() {
        super(Event.class);
    }

    public List<Event> getAllOrgEvents(int organizationId) {
        return (Ebean.find(Event.class).where().eq("organization_id",organizationId).findList());
    }

    public List<UserEvents> getUnApproveEventsByOrgEvents(int organizationId) {
        List<UserEvents> lstUserEvents = new ArrayList<UserEvents>();
        List<Event> lstEvents = this.getAllOrgEvents(organizationId);

        for (Event currEvent:lstEvents) {
            for (UserEvents currUserEvents:Ebean.find(UserEvents.class).where().eq("event_id", currEvent.getId()).eq("approve", false).findList()) {
                lstUserEvents.add(currUserEvents);
            }
        }

        return (lstUserEvents);
    }
}
