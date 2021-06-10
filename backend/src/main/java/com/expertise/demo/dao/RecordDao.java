package com.expertise.demo.dao;

import com.alibaba.excel.EasyExcel;
import com.expertise.demo.entity.Expert;
import com.expertise.demo.entity.Program;
import com.expertise.demo.entity.Record;
import com.expertise.demo.util.RecordListener;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecordDao {
    private RecordListener recordListener=new RecordListener();

    final private static String localExcelPath="C:/Users/hzlan/Desktop/1/record.xlsx";

    RecordDao(){
        EasyExcel.read(localExcelPath, Program.class,this.recordListener).sheet().doRead();
    }

    public List<Record> findAll(){
        return this.recordListener.getRecordList();
    }

    public List<Record> findById(Integer id){
        List<Record> result=new ArrayList<>();
        for(Record r:this.recordListener.getRecordList()){
            if (r.getId().equals(id)){
                result.add(r);
            }
        }
        return result;
    }

    public Record insert(Record r){
        List<Record> old=this.recordListener.getRecordList();
        old.add(r);
        EasyExcel.write(this.localExcelPath, Record.class).sheet().doWrite(old);
        EasyExcel.read(this.localExcelPath, Record.class, this.recordListener).sheet().doRead();
        return r;
    }
}
