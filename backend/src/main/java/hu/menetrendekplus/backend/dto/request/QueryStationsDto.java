package hu.menetrendekplus.backend.dto.request;

import java.util.Objects;

public class QueryStationsDto {

    private String query;

    private int maxResults;

    private boolean isSimple = false;

    public QueryStationsDto() {
    }

    public QueryStationsDto(String query, int maxResults, boolean isSimple) {
        this.query = query;
        this.maxResults = maxResults;
        this.isSimple = isSimple;
    }

    public QueryStationsDto(String query, int maxResults) {
        this.query = query;
        this.maxResults = maxResults;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public boolean isSimple() {
        return isSimple;
    }

    public void setSimple(boolean simple) {
        isSimple = simple;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryStationsDto that = (QueryStationsDto) o;
        return maxResults == that.maxResults && isSimple == that.isSimple && Objects.equals(query, that.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(query, maxResults, isSimple);
    }

    @Override
    public String toString() {
        return "QueryStationsDto{" +
                "query='" + query + '\'' +
                ", maxResults=" + maxResults +
                ", isSimple=" + isSimple +
                '}';
    }
}
