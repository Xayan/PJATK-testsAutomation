package pl.xayan.tau.tau1.DI;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T extends EntityInterface> implements RepositoryInterface<T> {
    private List<T> entityList = new ArrayList<>();

    public void insert(T entity) {

    }

    public List<T> getAll()
    {
        return null;
    }

    public T getById(int id) {
        return null;
    }

    public int getCount() {
        return 0;
    }

    public void update(int id, T entity) {

    }

    public void delete(T entity) {

    }
}
