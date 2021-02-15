package com.billies_works.demo.model;

import com.billies_works.demo.dao.EmpDao;

public class UpdateEmpLogic {
    public boolean execute (Emp emp) {
        EmpDao dao = new EmpDao();
        if (dao.updateEmp(emp)) {
            ;
        } else {
            return false;
        }
        return true;
    }
}

// 修正時刻: Mon Feb 15 13:33:06 2021
