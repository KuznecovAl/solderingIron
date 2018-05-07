package internet_shop.services;

public interface SERVICE<T> {
    void add(T t);
    void update(T t);
    T get(Long id);
    void deleteId(Long id);
}
