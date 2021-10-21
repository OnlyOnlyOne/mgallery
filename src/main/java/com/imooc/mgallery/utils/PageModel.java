package com.imooc.mgallery.utils;

import java.util.ArrayList;
import java.util.List;

public class PageModel {
    private int page;//页号
    private int totalPages;//总页数
    private int rows;//每页记录数
    private int totalRows;//总记录数
    private int pageStartRow;//当前页从第n行开始
    private int pageEndRow;//当前页到n行结束
    private boolean hasNextPage;//是否存在下一页
    private boolean hasPreviousPage;//是否存在上一页
    private List pageData;//当前页面数据

    public PageModel() {
    }//符合javabean的要求

    public PageModel(int page, int rows, List pageData) {
        this.page = page;
        this.rows = rows;
        this.pageData = pageData;
        totalRows = pageData.size();
        //Math.cele向上取整。
        totalPages = new Double(Math.ceil(totalRows / (rows * 1f))).intValue();//intValue()得到整数部分
        pageStartRow = (page - 1) * rows;
        pageEndRow = page * rows;
        //不过可能发生下标越界
        if (pageEndRow > totalRows) {
            pageEndRow = totalRows;
        }
        this.pageData = pageData.subList(pageStartRow, pageEndRow);
        if (page > 1) {
            hasPreviousPage = true;
        } else {
            hasPreviousPage = false;
        }
        if (page < totalPages) {
            hasNextPage = true;
        } else {
            hasNextPage = false;
        }

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }


    public int getPageEndRow() {
        return pageEndRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }


    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }


    public List getPageData() {
        return pageData;
    }


    public static void main(String[] args) {
        List sample = new ArrayList();
        for (int i = 0; i <= 100; i++) {
            sample.add(i);
        }
        PageModel pageModel = new PageModel(6, 8, sample);
        System.out.println(pageModel.getPageData());
        System.out.println(pageModel.getTotalPages());
        System.out.println(pageModel.getPageStartRow());
        System.out.println(pageModel.getPageEndRow());

    }

}
