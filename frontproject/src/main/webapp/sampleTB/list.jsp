<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="frontproject.vo.SampleTBVO" %>
<%@ page import="frontproject.controller.SampleTBController" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    // 올바른 타입으로 캐스팅합니다.
    List<SampleTBVO> slist = (List<SampleTBVO>) request.getAttribute("slist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>sampleTB 목록 페이지</h2>
    <table border="1">
        <thead>
            <tr>    
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${slist}">
        	<td>${list.sno}</td>
        	<td><a>${list.title}</a></td>
        	<td></td>
        	<td></td>
        </c:forEach>
        <%
            if (slist != null) {
                for (int i = 0; i < slist.size(); i++) {
                    SampleTBVO svo = slist.get(i);
        %>
                    <tr>
                        <td><%=svo.getSno() %></td>
                        <td><a href="view.do?sno=<%=svo.getSno()%>"><%=svo.getTitle() %></a></td>
                        <td><%=svo.getWriter() %></td>
                        <td><%=svo.getRdate() %></td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="4">No data available</td>
                </tr>
        <%
            }
        %>
        </tbody>
    </table>
    
    <button onclick="location.href='sampleTB/sampleTBinsert.do'">등록</button>
    <!-- 
        등록 버튼 클릭시 게시글 등록 페이지를 띄웁니다.
        등록 페이지에서는 제목, 작성자, 내용을 입력할 수 있습니다.
        등록 페이지에서 저장 버튼 클릭시 실제 sampleTB 테이블에
        데이터가 insert 된 후 목록 페이지로 이동합니다.
     -->
    
</body>
</html>
