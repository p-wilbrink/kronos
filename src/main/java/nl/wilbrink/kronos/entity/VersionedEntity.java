package nl.wilbrink.kronos.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class VersionedEntity extends BaseEntity {

    @Version
    @Column(name = "version")
    private Long version;

    public void setVersion(final Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

}
