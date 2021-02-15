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
  </head>
  <body>
    <h1>所属部編集</h1>
    <table>
      <form action="/useOracleUCP/UpdateDept" method="post">
        <tr>
          <th>所属No</th>
          <td><input type="number" min="1" name="deptno" value="${dept.deptno}"/></td>
        </tr>
        <tr>
          <th>所属部名</th>
          <td><input type="text" name="dname" value="${dept.dname}"/></td>
        </tr>
        <tr>
          <th>電話番号</th>
          <td><input type="text" name="telno" value="${dept.telno}"/></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="OK"/></td>
        </tr>
      </form>
    </table>
    <p><a href="/useOracleUCP">戻る</a></p>
    <jsp:include page="/footer.jsp" /> 
  </body>
</html>

<!-- 修正時刻: Tue Feb 16 07:54:29 2021 -->
