package com.billies_works.demo.model;

import java.io.Serializable;

public class EmpDept implements Serializable {
    private Integer empno;
    private String ename;
    private String job;
    private Integer age;
    private String dname;

    public EmpDept() {}

    public EmpDept( Integer empno,
                String ename,
                String job,
                Integer age,
                String dname ) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.age = age;
        this.dname = dname;
    }

    public Integer getEmpno() { return empno; }
    public String getEname() { return ename; }
    public String getJob() { return job; }
    public Integer getAge() { return age; }
    public String getDname() { return dname; }

    public void setEmpno( Integer empno ) {
        this.empno = empno;
    }
    public void setEname( String ename ) {
        this.ename = ename;
    }
    public void setJob( String job ) { this.job = job; }
    public void setAge( Integer age ) { this.age = age; }
    public void setDname( String dname ) {
        this.dname = dname;
    }

    public String toString() {
        return "Emp:{" + empno + ": " + ename +
            " : " + job + " : " +
            age + " : " + dname + " }";
    }
}

// 修正時刻: Mon Feb 15 07:42:42 2021
