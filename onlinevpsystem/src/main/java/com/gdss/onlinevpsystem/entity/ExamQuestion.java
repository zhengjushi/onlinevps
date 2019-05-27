package com.gdss.onlinevpsystem.entity;

import lombok.Data;

@Data
public class ExamQuestion {

    private Integer qId;

    // 题目
    private String qQuestion;

    // 选项 A
    private String qA;

    // 选项 B
    private String qB;

    // 选项 C
    private String qC;

    // 选项 D
    private String qD;

    // 试卷 ID （属于哪张试卷）
    private Integer eId;

    // 答案（A，B，C，D）
    private String qAnswer;

}
