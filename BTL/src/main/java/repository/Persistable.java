package repository;

import java.util.List;

public interface Persistable<T> {
    // Định nghĩa 3 hành động cơ bản mà các Repository phải có
    List<T> getAll();
    void add(T item);
    void update(T item);
}