package com.billies_works.demo.model;

import com.billies_works.demo.dao.EmpDao;

public class DeleteEmpLogic {
    public boolean execute (int empno) {
        EmpDao dao = new EmpDao();
        return dao.deleteEmp(empno);
    }
}

// 修正時刻: Tue Feb 16 12:02:40 2021
