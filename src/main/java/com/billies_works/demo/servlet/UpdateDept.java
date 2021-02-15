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
import com.billies_works.demo.model.UpdateDeptLogic;
import com.billies_works.demo.model.GetDeptListLogic;

@WebServlet("/UpdateDept")
public class UpdateDept extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        String deptnoStr = request.getParameter("deptno");
        int deptno = Integer.parseInt( deptnoStr );

        String dname = request.getParameter("dname");
        System.out.println("UpdateDept -- doPost -- dname: " + dname);
        
        String telno = request.getParameter("telno");
        System.out.println("UpdateDept -- doPost -- telno: " + telno);

        Dept dept = new Dept( deptno, dname, telno );
        
        UpdateDeptLogic updateDeptLogic =
            new UpdateDeptLogic();

        String msg = null;
        if (updateDeptLogic.execute( dept )) {
            msg = "更新しました";
        } else {
            msg = "更新に失敗しました";
        }
        request.setAttribute("msg", msg);
        // response.sendRedirect("/useOracleUCP/Main");

        GetDeptListLogic getDeptListLogic =
            new GetDeptListLogic();
        List<Dept> deptList = getDeptListLogic.execute();
        request.setAttribute( "deptList", deptList );

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/deptDisp.jsp");
        dispatcher.forward( request, response );

    }
}



// 修正時刻: Tue Feb 16 07:59:38 2021
