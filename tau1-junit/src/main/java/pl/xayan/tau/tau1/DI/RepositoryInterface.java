package pl.xayan.tau.tau1.DI;

import java.util.List;

public interface RepositoryInterface<T extends EntityInterface> {
    void insert(T entity);
    List<T> getAll();
    T getById(int id) ;
    void update(int id, T entity);
    void delete(T entity);
}
