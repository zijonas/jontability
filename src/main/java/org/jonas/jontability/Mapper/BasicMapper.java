package org.jonas.jontability.Mapper;

public interface BasicMapper<E, D> {

	D toDto(E Entity);

	E toEntity(D billDto);

}
