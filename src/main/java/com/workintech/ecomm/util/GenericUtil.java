package com.workintech.ecomm.util;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Function;

public final class GenericUtil {

    public static <T, R> T saveEntity(T dto, Function<T, R> toEntityMapper, Function<R, T> toDtoMapper, JpaRepository<R, Long> repository) {
        R entity = toEntityMapper.apply(dto);
        R savedEntity = repository.save(entity);
        return toDtoMapper.apply(savedEntity);
    }

}
