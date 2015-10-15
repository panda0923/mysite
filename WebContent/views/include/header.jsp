<%@page import= "com.bit2015.mysite.vo.MemberVo "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    MemberVo vo=(MemberVo)session.getAttribute("authUser");
    
    %>
<div id="header">
			<h1>MySite</h1>
			<ul>
				<%
				if(vo==null){
				%>
				<li><a href="/mysite/member?a=loginform">로그인</a><li>
				<li><a href="/mysite/member?a=joinform">회원가입</a><li>
				<%
					} else{
					
				   String name= vo.getName();
				%>
				<li><a href="">회원정보수정</a><li>
				<li><a href="/mysite/member?a=logout">로그아웃</a><li>
				<li>${authUser.name}님 안녕하세요 ^^;</li>
<%-- 		세개다 사용가능<li>${sessionScope.authUser.name}님 안녕하세요 ^^;</li> --%>				
<%-- 				<li><%=name %>님 안녕하세요 ^^;</li> --%>
				<%
				}
				%>
			</ul>
		</div>