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
        this.items = load();
    }

    protected abstract T fromCsv(String line);
    protected abstract String toCsv(T entity);

    @Override
    public List<T> load() {
        List<String> lines = FileUtils.read(filePath);
        return lines.stream().map(this::fromCsv).collect(Collectors.toList());
    }

    @Override
    public void save(List<T> data) {
        List<String> lines = data.stream().map(this::toCsv).collect(Collectors.toList());
        FileUtils.write(filePath, lines);
    }

    public List<T> getAll() { return items; }

    public void add(T item) {
        items.add(item);
        save(items);
    }
}