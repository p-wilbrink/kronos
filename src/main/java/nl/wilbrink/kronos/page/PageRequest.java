package nl.wilbrink.kronos.page;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.springframework.data.domain.PageRequest.of;

public class PageRequest {

    private Integer perPage;

    private int pageNumber;

    private String sortDirection;

    private String sortField;

    private static String DEFAULT_SORT_FIELD = "id";
    private static int MAX_PER_PAGE = 100;
    private static int DEFAULT_PER_PAGE = 20;

    public void setPerPage(final int perPage) {
        if (perPage > MAX_PER_PAGE) {
            this.perPage = MAX_PER_PAGE;
        }
        this.perPage = perPage;
    }

    public int getPerPage() {
        return this.perPage != null ? this.perPage : DEFAULT_PER_PAGE;
    }

    public void setPageNumber(final int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public String getSortDirection() {
        return this.sortDirection;
    }

    public void setSortDirection(final String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortField() {
        return this.sortField != null ? this.sortField : this.DEFAULT_SORT_FIELD;
    }

    public void setSortField(final String sortField) {
        this.sortField = sortField;
    }

    protected Sort getSort() {
        Sort.Direction sortDirection = "desc".equalsIgnoreCase(this.getSortDirection()) ? Sort.Direction.DESC : Sort.Direction.ASC;
        return Sort.by(sortDirection, this.getSortField());
    }
    public Pageable toPageable() {
        return of(
                this.getPageNumber(),
                this.getPerPage(),
                this.getSort()
        );
    }

}
