package nl.wilbrink.kronos.service;

import nl.wilbrink.kronos.dto.BaseDTO;
import nl.wilbrink.kronos.entity.BaseEntity;
import nl.wilbrink.kronos.mapper.BaseMapper;
import nl.wilbrink.kronos.page.PageRequest;
import nl.wilbrink.kronos.repository.BaseRepository;
import nl.wilbrink.kronos.search.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public abstract class PagingService<DTO extends BaseDTO, ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>> extends CrudService<DTO, ENTITY, REPOSITORY> implements IPagingService<DTO, ENTITY>{

    public PagingService(REPOSITORY repository, BaseMapper<DTO, ENTITY> mapper) {
        super(repository, mapper);
    }

    @Override
    public Page<DTO> getPage(@NonNull final PageRequest pageRequest, @Nullable final SearchCriteria<ENTITY> searchCriteria) {
        final Page<ENTITY> page = searchCriteria != null ? this.repository.findAll(
            searchCriteria.toSpecification(),
            pageRequest.toPageable()
        ) : this.repository.findAll(
            pageRequest.toPageable()
        );

        return page.map(this.mapper::toDTO);
    }

}
