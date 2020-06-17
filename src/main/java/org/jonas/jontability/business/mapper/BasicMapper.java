package org.jonas.jontability.business.mapper;

public interface BasicMapper<E, D> {

	D toDto(E entity);

	E toEntity(D dto);

}
