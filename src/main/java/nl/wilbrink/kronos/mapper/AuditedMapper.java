package nl.wilbrink.kronos.mapper;

import nl.wilbrink.kronos.dto.AuditedDTO;
import nl.wilbrink.kronos.entity.AuditedEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface AuditedMapper<DTO extends AuditedDTO, ENTITY extends AuditedEntity> extends VersionedMapper<DTO, ENTITY> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    void mapEntity(DTO dto, @MappingTarget ENTITY entity);

}
