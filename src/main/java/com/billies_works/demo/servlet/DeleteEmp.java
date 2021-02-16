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
import com.billies_works.demo.model.DeleteEmpLogic;

@WebServlet("/DeleteEmp")
public class DeleteEmp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        String empnoStr = request.getParameter("empno");
        int empno = Integer.parseInt( empnoStr );
        System.out.println("empno:" + empno);

        DeleteEmpLogic deleteEmpLogic =
            new DeleteEmpLogic();

        String msg = null;
        
        if (deleteEmpLogic.execute( empno )) {
            msg = "削除しました";
        } else {
            msg = "削除に失敗しました";
        }

        response.sendRedirect("/useOracleUCP");
    }
}


// 修正時刻: Tue Feb 16 12:10:32 2021
