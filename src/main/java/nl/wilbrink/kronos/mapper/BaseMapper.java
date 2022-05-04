package nl.wilbrink.kronos.mapper;

import nl.wilbrink.kronos.dto.BaseDTO;
import nl.wilbrink.kronos.entity.BaseEntity;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface BaseMapper<DTO extends BaseDTO, ENTITY extends BaseEntity> {

    DTO toDTO(ENTITY entity);
    ENTITY toEntity(DTO dto);

    @Mapping(target = "id", ignore = true)
    void mapEntity(DTO dto, @MappingTarget ENTITY entity);

}
