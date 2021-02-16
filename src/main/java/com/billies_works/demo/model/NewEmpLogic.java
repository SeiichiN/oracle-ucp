package com.billies_works.demo.model;

import com.billies_works.demo.dao.EmpDao;
import com.billies_works.demo.model.Emp;

public class NewEmpLogic {
    public boolean execute (Emp emp) {
        EmpDao dao = new EmpDao();
        return dao.createEmp( emp );
    }
}

// 修正時刻: Tue Feb 16 18:34:21 2021
