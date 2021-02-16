package com.billies_works.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.billies_works.demo.model.Emp;
import com.billies_works.demo.model.Dept;
import com.billies_works.demo.model.GetDeptListLogic;

@WebServlet("/NewEmp")
public class NewEmp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        GetDeptListLogic getDeptListLogic =
            new GetDeptListLogic();
        
        List<Dept> deptList = getDeptListLogic.execute();

        request.setAttribute("deptList", deptList);
        
        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/newEmp.jsp");
        dispatcher.forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        String empnoStr = request.getParameter("empno");
        int empno = Integer.parseInt( empnoStr );
        
        String ename = request.getParameter("ename");
        
        String job = request.getParameter("job");
        
        String salStr = request.getParameter("sal");
        int sal = Integer.parseInt( salStr );
        
        String ageStr = request.getParameter("age");
        int age = Integer.parseInt( ageStr );
        
        String deptnoStr = request.getParameter("deptno");
        int deptno = Integer.parseInt( deptnoStr );

        Emp emp = new Emp( empno, ename, job, sal, age, deptno );

        System.out.println(emp);

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/useOracleUCP/Main");
        dispatcher.forward( request, response );

    }
}




// 修正時刻: Tue Feb 16 16:14:29 2021
