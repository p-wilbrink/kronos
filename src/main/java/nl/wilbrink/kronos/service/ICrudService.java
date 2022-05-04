package nl.wilbrink.kronos.service;

import nl.wilbrink.kronos.dto.BaseDTO;

public interface ICrudService<DTO extends BaseDTO> {

    DTO getById(final Long id);
    DTO create(final DTO dto);
    DTO update(final DTO dto);
    void delete(final Long id);

}
