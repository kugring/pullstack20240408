<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="frontproject.vo.SampleTBVO" %>
<%
   
   SampleTBVO svo = (SampleTBVO)request.getAttribute("svo");
	System.out.println("제발");
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>sampleTB 상세페이지!</h2>
   <table>
      <thead>
         <tr>
            <th align="right">글제목:</th>
            <td><%=svo.getTitle() %></td>
         </tr>
         <tr>
            <th align="right">작성자:</th>
            <td><%=svo.getWriter() %></td>
         </tr>
         <tr>
            <th align="right">작성일:</th>
            <td><%=svo.getRdate() %></td>
         </tr>
         <tr>
            <th align="right">내용:</th>
            <td><%=svo.getBody() %></td>
         </tr>
      </thead>
   </table>
   <button onclick="location.href='sampleTBmodify.do?sno=<%=svo.getSno()%>'">수정</button>
   <button onclick="location.href='sampleTBlist.do'">목록</button>
</body>
</html>