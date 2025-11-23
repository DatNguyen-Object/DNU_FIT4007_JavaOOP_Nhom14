package repository;
import java.util.List;

public interface Persistable<T> {
    void save(List<T> data);
    List<T> load();
}