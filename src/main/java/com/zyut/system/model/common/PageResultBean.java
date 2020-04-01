package com.zyut.system.model.common;

import java.io.Serializable;

/*
 *
 * description :  分页返回实体
 * @author: Robot
 * @date 17:41 2020/3/29
 **/
public class PageResultBean<T> extends ResultBean<T> implements Serializable {

    /**
     * 总记录数
     */
    private long totalRecord;

    /**
     * 总页数
     */
    private int pageCount;

    /**
     * 当前页码
     */
    private int pageNo;

    /**
     * 当前页的记录数量
     */
    private int pageSize;

    public long getTotalRecord() {
        return totalRecord;
    }

    public PageResultBean<T> setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        return this;
    }

    public int getPageCount() {
        return pageCount;
    }

    public PageResultBean<T> setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public int getPageNo() {
        return pageNo;
    }

    public PageResultBean<T> setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageResultBean<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public String toString() {
        return "PageResultBean<T>{" +
                "totalRecord=" + totalRecord +
                ", pageCount=" + pageCount +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

    @Override
    public PageResultBean<T> setMsg(String msg) {
        super.setMsg(msg);
        return this;
    }

    @Override
    public PageResultBean<T> setCode(int code) {
        super.setCode(code);
        return this;
    }

    @Override
    public PageResultBean<T> setData(T data) {
        super.setData(data);
        return this;
    }
}
