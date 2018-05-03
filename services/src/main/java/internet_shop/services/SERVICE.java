package internet_shop.services;

import java.io.Serializable;

public interface SERVICE<T> {
    void add(T t);
    void update(T t);
    T get(Long id);
    void deleteId(Long id);
}
