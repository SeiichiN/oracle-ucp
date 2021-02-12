package com.billies_works.demo.model;

import java.util.List;
import com.billies_works.demo.dao.EmpDao;

public class GetEmpListLogic {
    public List<Emp> execute () {
        EmpDao dao = new EmpDao();
        List<Emp> empList = dao.findEmpAll();
        return empList;
    }
}

// 修正時刻: Thu Feb 11 22:09:28 2021
