package com.billies_works.demo.model;

import java.io.Serializable;

public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String telno;

    public Dept() {}

    public Dept( Integer deptno,
                 String dname,
                 String telno) {
        this.deptno = deptno;
        this.dname = dname;
        this.telno = telno;
    }

    public Integer getDeptno() { return deptno; }
    public String getDname() { return dname; }
    public String getTelno() { return telno; }

    public void setDeptno( Integer deptno ) {
        this.deptno = deptno;
    }
    public void setDname( String dname ) {
        this.dname = dname;
    }
    public void setTelno( String telno ) { this.telno = telno; }

    public String toString() {
        return "Dept:{" + deptno + ": " + dname +
            " : " + telno + " }";
    }
}

// 修正時刻: Wed Feb 10 21:20:33 2021
