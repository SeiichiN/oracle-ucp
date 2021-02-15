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
import com.billies_works.demo.model.UpdateEmpLogic;
import com.billies_works.demo.model.GetEmpListLogic;

@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        String empnoStr = request.getParameter("empno");
        int empno = Integer.parseInt( empnoStr );

        String ename = request.getParameter("ename");
        System.out.println("UpdateEmp -- doPost -- ename: " + ename);
        
        String job = request.getParameter("job");
        System.out.println("UpdateEmp -- doPost -- job: " + job);

        String salStr = request.getParameter("sal");
        int sal = Integer.parseInt( salStr );

        String ageStr = request.getParameter("age");
        int age = Integer.parseInt( ageStr );

        String deptnoStr = request.getParameter("deptno");
        int deptno = Integer.parseInt( deptnoStr );
        
        Emp emp = new Emp( empno, ename, job, sal, age, deptno );
        
        UpdateEmpLogic updateEmpLogic =
            new UpdateEmpLogic();

        String msg = null;
        if (updateEmpLogic.execute( emp )) {
            msg = "更新しました";
        } else {
            msg = "更新に失敗しました";
        }
        request.setAttribute("msg", msg);
        // response.sendRedirect("/useOracleUCP/Main");

        GetEmpListLogic getEmpListLogic =
            new GetEmpListLogic();
        List<Emp> empList = getEmpListLogic.execute();
        request.setAttribute( "empList", empList );

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/mainDisp.jsp");
        dispatcher.forward( request, response );

    }
}



// 修正時刻: Mon Feb 15 20:57:13 2021
