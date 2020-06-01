package org.jonas.jontability.mapper;

public interface BasicMapper<E, D> {

	D toDto(E entity);

	E toEntity(D dto);

}
