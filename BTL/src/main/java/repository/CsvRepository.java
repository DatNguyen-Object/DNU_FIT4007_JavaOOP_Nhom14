package repository;

import common.FileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CsvRepository<T> implements Persistable<T> {
    protected String filePath;
    protected List<T> items;

    public CsvRepository(String filePath) {
        this.filePath = filePath;
        this.items = new ArrayList<>();
        this.items = load();
    }

    protected abstract T fromCsv(String line);
    protected abstract String toCsv(T entity);

    @Override
    public List<T> load() {
        List<T> result = new ArrayList<>();
        List<String> lines = FileUtils.read(filePath);
        for (String line : lines) {
            result.add(fromCsv(line));
        }
        return result;
    }

    protected void saveToFile() {
        List<String> lines = new ArrayList<>();
        for (T item : this.items) {
            lines.add(toCsv(item));
        }
        FileUtils.write(filePath, lines);
    }

    @Override
    public List<T> getAll() {
        return this.items;
    }

    @Override
    public void add(T item) {
        this.items.add(item);
        saveToFile();
    }

    @Override
    public void save(List<T> data) {
        this.items = data;
        saveToFile();
    }

    @Override
    public void update(T item) {
        saveToFile();
    }

    @Override
    public void delete(T item) {
        this.items.remove(item);
        saveToFile();
    }
}