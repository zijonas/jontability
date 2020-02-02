package org.jonas.jontability.Mapper;

public interface BasicMapper<E, D> {

	D toDto(E entity);

	E toEntity(D dto);

}
