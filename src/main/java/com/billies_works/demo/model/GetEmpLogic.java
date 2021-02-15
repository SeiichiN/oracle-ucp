package com.billies_works.demo.model;

import com.billies_works.demo.dao.EmpDao;

public class GetEmpLogic {
    public Emp execute (int empno) {
        EmpDao dao = new EmpDao();
        Emp emp = dao.findEmp(empno);
        return emp;
    }
}

// 修正時刻: Mon Feb 15 11:19:36 2021
