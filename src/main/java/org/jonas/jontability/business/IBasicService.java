package org.jonas.jontability.business;

import java.util.List;
import java.util.Optional;

public interface IBasicService<T> {
    Optional<List<T>> getAll();

    Optional<T> get(Integer id);

    T persist(T dto);

    void delete(Integer id);
}
