package nl.wilbrink.kronos.dto;

import java.util.List;

public class ListWrapper<T> {

    private final List<T> items;

    private ListWrapper(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public static <T> ListWrapper<T> of(final List<T> items) {
        return new ListWrapper<>(items);
    }

}
