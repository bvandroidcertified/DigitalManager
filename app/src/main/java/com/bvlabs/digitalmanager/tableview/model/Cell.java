package com.bvlabs.digitalmanager.tableview.model;

import com.evrencoskun.tableview.filter.IFilterableModel;
import com.evrencoskun.tableview.sort.ISortableModel;

public class Cell implements ISortableModel, IFilterableModel {

    private String mId;
    private Object mData;
    private String mFilterKeyword;
    private String mCodeColor;

    public Cell(String id) {
        this.mId = id;
    }

    public Cell(String id, Object data) {
        this.mId = id;
        this.mData = data;
        this.mFilterKeyword = String.valueOf(data);
    }

    public Cell(String id, Object data,String codeColor) {
        this.mId = id;
        this.mData = data;
        this.mFilterKeyword = String.valueOf(data);
        this.mCodeColor = mCodeColor;
    }

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */
    @Override
    public String getId() {
        return mId;
    }

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */
    @Override
    public Object getContent() {
        return mData;
    }


    public Object getData() {
        return mData;
    }

    public void setData(String data) { mData = data; }

    public String getFilterKeyword() {
        return mFilterKeyword;
    }

    public void setFilterKeyword(String filterKeyword) {
        this.mFilterKeyword = filterKeyword;
    }

    @Override
    public String getFilterableKeyword() {
        return mFilterKeyword;
    }

    public String getCodeColor() {
        return mCodeColor;
    }
}
