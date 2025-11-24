package repository;

import java.util.List;

public interface Persistable<T> {
    List<T> getAll();
    void add(T item);
    void update(T item);
    void delete(T item);
    void save(List<T> data);
    List<T> load();
}