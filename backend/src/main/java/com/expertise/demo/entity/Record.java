package com.expertise.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Record {
    @ExcelProperty("评审ID")
    private Integer id;
    @ExcelProperty("专家ID")
    private String expertID;
    @ExcelProperty("项目ID")
    private String programID;
    @ExcelProperty("评审时间")
    private Date time;
    @ExcelProperty("评价")
    private String comment;
    @ExcelProperty("分数")
    private int ontime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpertID() {
        return expertID;
    }

    public void setExpertID(String expertID) {
        this.expertID = expertID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getOntime() {
        return ontime;
    }

    public void setOntime(int ontime) {
        this.ontime = ontime;
    }

    public Record(){}

    public Record(String expertID,String programID,Date time,String comment,int ontime){
        this.comment=comment;
        this.expertID=expertID;
        this.programID=programID;
        this.ontime=ontime;
        this.time=time;
    }

}
