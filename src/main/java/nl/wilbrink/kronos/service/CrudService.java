package nl.wilbrink.kronos.service;

import nl.wilbrink.kronos.dto.BaseDTO;
import nl.wilbrink.kronos.entity.BaseEntity;
import nl.wilbrink.kronos.exception.NotFoundException;
import nl.wilbrink.kronos.mapper.BaseMapper;
import org.springframework.data.repository.CrudRepository;

public abstract class CrudService<DTO extends BaseDTO, ENTITY extends BaseEntity, I extends CrudRepository<ENTITY, Long>> implements ICrudService<DTO> {

    protected final I repository;
    protected final BaseMapper<DTO, ENTITY> mapper;

    public CrudService(
        I repository,
        BaseMapper<DTO, ENTITY> mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    protected abstract String getName();

    public DTO getById(final Long id) {
        return this.mapper.toDTO(
            this.findEntity(id)
        );
    }

    public DTO create(final DTO dto) {
        return this.mapper.toDTO(
            this.repository.save(
                this.mapper.toEntity(dto)
            )
        );
    }

    public DTO update(final DTO dto) {
        final ENTITY entity = this.findEntity(dto.getId());

        this.mapper.mapEntity(dto, entity);

        return this.mapper.toDTO(
            this.repository.save(entity)
        );
    }

    public void delete(final Long id) {
        final ENTITY entity = this.findEntity(id);

        this.repository.delete(entity);
    }

    protected ENTITY findEntity(final Long id) {
        return this.repository.findById(id)
            .orElseThrow(() -> new NotFoundException(String.format("%s not found", this.getName())));
    }
}

