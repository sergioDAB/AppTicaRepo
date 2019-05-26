package aplicactions.ticas.appticas.utils;

import java.util.List;

public class QueryResult {
    private Integer totalRecords;
    private List<Object> list;

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public QueryResult(Integer totalRecords, List<Object> list) {
        this.totalRecords = totalRecords;
        this.list = list;
    }
}
