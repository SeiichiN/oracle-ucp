<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="/common.jsp" %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日");
String today = sdf.format(date);
%>
<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8"/>
    <title>社員一覧</title>
  </head>
  <body>
    <h1>社員一覧</h1>
    <nav>
      <li><a href="/useOracleUCP/EmpDeptMain">社員一覧</a></li>
      <li><a href="/useOracleUCP/Main">社員編集</a></li>
      <li><a href="/useOracleUCP/DeptMain">所属部編集</a></li>
    </nav>
    <p>担当: 総務部 <%= name %></p>
    <time><%= today %></time>
    <jsp:include page="/footer.jsp" /> 
  </body>
</html>

<!-- 修正時刻: Sat Feb 13 07:41:27 2021 -->
