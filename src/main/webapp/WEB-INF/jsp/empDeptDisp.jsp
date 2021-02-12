<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.billies_works.demo.model.Emp" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>EMP</title>
  </head>
  <body>
    <h1>Emp List</h1>
    <table>
      <tr>
        <th>名前</th>
        <th>課</th>
        <th>年齢</th>
        <th>所属</th>
      </tr>
    <c:forEach var="empdept" items="${empDeptList}">
      <tr>
        <td>${empdept.ename}</td>
        <td>${empdept.job}</td>
        <td>${empdept.age}</td>
        <td>${empdept.dname}</td>
      </tr>
    </c:forEach>
    </table>
    <p><a href="/useOracleUCP">戻る</a></p>
  </body>
</html>

<!-- 修正時刻: Fri Feb 12 07:21:52 2021 -->