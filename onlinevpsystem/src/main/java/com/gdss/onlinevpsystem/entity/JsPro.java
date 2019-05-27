package com.gdss.onlinevpsystem.entity;

import lombok.Data;

@Data
public class JsPro {

    private Integer proId;

    private String proName;

    private String proDesc;

    private String proExample;

    public JsPro() {
    }

    public JsPro(Integer proId, String proName, String proDesc, String proExample) {
        this.proId = proId;
        this.proName = proName;
        this.proDesc = proDesc;
        this.proExample = proExample;
    }

    public JsPro(String proName, String proDesc, String proExample) {
        this.proName = proName;
        this.proDesc = proDesc;
        this.proExample = proExample;
    }
}
