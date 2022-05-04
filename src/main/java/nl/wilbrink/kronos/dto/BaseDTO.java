package nl.wilbrink.kronos.dto;

public abstract class BaseDTO {

    private Long id;

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

}
