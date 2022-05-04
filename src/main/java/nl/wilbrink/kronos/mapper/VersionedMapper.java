package nl.wilbrink.kronos.mapper;

import nl.wilbrink.kronos.dto.VersionedDTO;
import nl.wilbrink.kronos.entity.VersionedEntity;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface VersionedMapper<DTO extends VersionedDTO, ENTITY extends VersionedEntity> extends BaseMapper<DTO, ENTITY>{

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    void mapEntity(DTO dto, @MappingTarget ENTITY entity);

}
