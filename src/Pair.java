public class Pair<K, V> {
    private K key;   // Thuộc tính key, kiểu K
    private V value; // Thuộc tính value, kiểu V

    // Constructor để khởi tạo cả hai thuộc tính
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Phương thức getKey()
    public K getKey() {
        return key;
    }

    // Phương thức getValue()
    public V getValue() {
        return value;
    }
}