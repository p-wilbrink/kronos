package nl.wilbrink.kronos.search;

import org.springframework.data.jpa.domain.Specification;

public abstract class SearchCriteria<T> {

    protected Specification<T> root() {
        return Specification.where(null);
    }

    public abstract Specification<T> toSpecification();

    protected Specification<T> like(final String columnName, final String pattern) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                root.get(columnName),
                "%" + pattern + "%"
        );
    }

    protected Specification<T> iLike(final String columnName, final String pattern) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(columnName)),
                "%" + pattern.toLowerCase() + "%"
        );
    }
}
