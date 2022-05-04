package nl.wilbrink.kronos.service;

import nl.wilbrink.kronos.dto.BaseDTO;
import nl.wilbrink.kronos.entity.BaseEntity;
import nl.wilbrink.kronos.page.PageRequest;
import nl.wilbrink.kronos.search.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public interface IPagingService<DTO extends BaseDTO, ENTITY extends BaseEntity> extends ICrudService<DTO> {

    Page<DTO> getPage(@NonNull final PageRequest pageRequest, @Nullable final SearchCriteria<ENTITY> searchCriteria);

}