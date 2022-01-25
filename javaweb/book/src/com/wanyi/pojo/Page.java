package com.wanyi.pojo;

import java.util.List;

public class Page<T> {
    public static final int Page_Size = 4;
    private int pageIndex;
    private int itemsPerPage = Page_Size;
    private List<T> items;
    private int itemCount;
    private int pageCount;
    private String url;

    public Page() {
    }

    public Page(int pageIndex, int itemsPerPage, List<T> items, int itemCount, int pageCount, String url) {
        this.pageIndex = pageIndex;
        this.itemsPerPage = itemsPerPage;
        this.items = items;
        this.itemCount = itemCount;
        this.pageCount = pageCount;
        this.url = url;
    }

    public static int getPage_Size() {
        return Page_Size;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageIndex=" + pageIndex +
                ", itemsPerPage=" + itemsPerPage +
                ", items=" + items +
                ", itemCount=" + itemCount +
                ", pageCount=" + pageCount +
                ", url='" + url + '\'' +
                '}';
    }
}
