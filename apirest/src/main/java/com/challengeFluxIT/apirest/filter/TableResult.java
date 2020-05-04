package com.challengeFluxIT.apirest.filter;

import java.util.List;


public class TableResult<T> {
    private List<T> rows;
    private Long total;

    public static <T> TableResult<T> fromResultPage(ResultPage<T> resultPage) {
    	TableResult<T> uiResultPage = new TableResult<>();
        uiResultPage.setRows(resultPage.getItems());
        uiResultPage.setTotal(resultPage.getTotal());
        return uiResultPage;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
