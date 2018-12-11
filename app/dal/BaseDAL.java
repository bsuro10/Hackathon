package dal;

import io.ebean.Ebean;
import java.util.List;

public class BaseDAL<T> {

    private Class<T> type;

    public BaseDAL(Class<T> type) {
        this.type = type;
    }

    public List<T> getAll() {
        return (Ebean.find(type).findList());
    }

    public T getById(String id) {
        return (Ebean.find(type, id));
    }

    public T getById(int id) {
        return (Ebean.find(type, id));
    }

    public void add(T t) {
        Ebean.save(t);
    }

    public void update(T t) {
        Ebean.update(t);
    }

    public void delete(T t) {
        Ebean.delete(t);
    }
}
