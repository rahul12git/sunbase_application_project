package com.crud.sunbase.entities;

import java.util.List;


public class PostResponse {
    private List<Customer> content;
    private  Integer pageSize;
    private  Integer pageNumber;
    private  Integer totalElements;
    private Integer totalPages;
    private  boolean lastPage;


    public PostResponse(List<Customer> content, Integer pageSize, Integer pageNumber, Integer totalElements, Integer totalPages, boolean lastPage) {
        this.content = content;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.lastPage = lastPage;
    }

    public PostResponse() {
    }

    public List<Customer> getContent() {
        return content;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setContent(List<Customer> content) {
        this.content = content;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    @Override
    public String toString() {
        return "postResponse{" +
                "content=" + content +
                ", pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", lastPage=" + lastPage +
                '}';
    }
}