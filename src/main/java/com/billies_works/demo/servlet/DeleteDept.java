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

import com.billies_works.demo.model.Dept;
import com.billies_works.demo.model.DeleteDeptLogic;

@WebServlet("/DeleteDept")
public class DeleteDept extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        String deptnoStr = request.getParameter("deptno");
        int deptno = Integer.parseInt( deptnoStr );
        System.out.println("deptno:" + deptno);

        DeleteDeptLogic deleteDeptLogic =
            new DeleteDeptLogic();

        String msg = null;
        
        if (deleteDeptLogic.execute( deptno )) {
            msg = "削除しました";
        } else {
            msg = "削除に失敗しました";
        }

        response.sendRedirect("/useOracleUCP");
    }
}


// 修正時刻: Tue Feb 16 20:11:08 2021
