<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.billies_works.demo.model.Emp" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>所属部編集</title>
    <jsp:include page="/style.jsp" /> 
  </head>
  <body>
    <div id="wrapper">
      <h1>所属部編集</h1>
      <table>
        <tr>
          <th>所属No</th>
          <th>所属部名</th>
          <th>電話番号</th>
          <th></th>
          <th></th>
        </tr>
        <c:forEach var="dept" items="${deptList}">
          <tr>
            <td>${dept.deptno}</td>
            <td>${dept.dname}</td>
            <td>${dept.telno}</td>
            <td>
              <form action="/useOracleUCP/EditDept" method="post">
                <input type="hidden" name="deptno" value="${dept.deptno}"/>
                <button class="pencil" type="submit">
                  <i class="fas fa-pencil-alt"></i></button>
              </form>
            </td>
            <td>
              <form action="/useOracleUCP/DeleteDept" method="post"
                    onSubmit="return kakunin()">
                <input type="hidden" name="deptno" value="${dept.deptno}"/>
                <button class="trash" type="submit">
                  <i class="fas fa-trash-alt"></i></button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </table>
      <p><a href="/useOracleUCP/NewDept">新規作成</a></p>
      <p><a href="/useOracleUCP">戻る</a></p>
      <jsp:include page="/footer.jsp" /> 
      <script src="js/confirm.js"></script>
    </div>
  </body>
</html>

<!-- 修正時刻: Wed Feb 17 16:00:33 2021 -->
