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
    <jsp:include page="/style.jsp" /> 
  </head>
  <body>
    <div id="wrapper">
      <h1>社員一覧</h1>
      <nav>
        <ul>
          <li><a href="/useOracleUCP/EmpDeptMain">社員一覧</a></li>
          <li><a href="/useOracleUCP/Main">社員編集</a></li>
          <li><a href="/useOracleUCP/DeptMain">所属部編集</a></li>
        </ul>
      </nav>
      <p>担当: 総務部 <%= name %></p>
      <time><%= today %></time>
      <jsp:include page="/footer.jsp" />
    </div>
  </body>
</html>

<!-- 修正時刻: Wed Feb 17 16:18:33 2021 -->
