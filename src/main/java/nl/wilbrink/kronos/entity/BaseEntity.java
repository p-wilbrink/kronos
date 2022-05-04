package nl.wilbrink.kronos.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity extends AbstractPersistable<Long> {

    @Override
    public void setId(final Long id) {
        super.setId(id);
    }

}
