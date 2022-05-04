package nl.wilbrink.kronos.dto;

import java.time.LocalDateTime;

public abstract class AuditedDTO extends VersionedDTO {

    private LocalDateTime created;
    private LocalDateTime updated;

    private String createdBy;
    private String updatedBy;

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public void setUpdated(final LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getUpdated() {
        return this.updated;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

}
