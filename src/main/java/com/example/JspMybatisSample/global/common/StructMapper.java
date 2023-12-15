package com.example.JspMybatisSample.global.common;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StructMapper<D, E> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDtoList(List<E> entityList);

    List<E> toEntityList(List<D> dtoList);

}
