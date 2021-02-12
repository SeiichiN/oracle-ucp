package com.billies_works.demo.model;

import java.util.List;
import com.billies_works.demo.dao.EmpDao;

public class GetEmpDeptListLogic {
    public List<EmpDept> execute () {
        EmpDao dao = new EmpDao();
        List<EmpDept> empDeptList = dao.findEmpDeptAll();
        return empDeptList;
    }
}

// 修正時刻: Wed Feb 10 11:59:35 2021
