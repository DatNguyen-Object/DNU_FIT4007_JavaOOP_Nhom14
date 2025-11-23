public class Box<T> {
    private T name;
    public Box(T name) {
        this.name = name;
    }
    public T getName() {
        return name;
    }
    public void setName(T name) {
            this.name = name;
    }
}