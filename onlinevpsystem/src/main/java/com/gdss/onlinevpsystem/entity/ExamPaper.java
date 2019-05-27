package com.gdss.onlinevpsystem.entity;

import lombok.Data;

import java.util.List;

@Data
public class ExamPaper {

    private Integer eId;

    private String eTitle;

    private List<ExamQuestion> list;

    public ExamPaper() {
    }

    public ExamPaper(Integer eId, String eTitle) {
        this.eId = eId;
        this.eTitle = eTitle;
    }

    public ExamPaper(Integer eId, String eTitle, List<ExamQuestion> list) {
        this.eId = eId;
        this.eTitle = eTitle;
        this.list = list;
    }
}
