package pl.xayan.tau.tau3.DI;

import pl.xayan.tau.tau3.exception.EntityNotFoundException;

import java.util.List;

public interface RepositoryInterface<T extends EntityInterface> {
    void insert(T entity);
    List<T> getAll();
    T findById(int id) ;
    void update(int id, T entity);
    void delete(T entity) throws EntityNotFoundException;
}
