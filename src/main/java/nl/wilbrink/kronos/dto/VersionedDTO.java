package nl.wilbrink.kronos.dto;

public abstract class VersionedDTO extends BaseDTO {

    private Long version;

    public void setVersion(final Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return this.version;
    }

}
