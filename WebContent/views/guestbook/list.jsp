<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.bit2015.mysite.vo.GuestbookVo"%>
<%

	List<GuestbookVo> list = 
	(List<GuestbookVo>)request.getAttribute( "list" );
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/views/include/header.jsp" flush="false"></jsp:include>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite/guest" method="post">
					<input type="hidden" name="a" value="listadd">
					<table>
						<tr>
							<td>이름</td><td><input type="text" name="name"></td>
							<td>비밀번호</td><td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="message" id="message"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>

				</ul>
					<%
						int countTotal = list.size();
						int index = 0;
						for( GuestbookVo vo : list ) {
					%>				
					<li>
						<table>
							<tr>
								<td>[<%=countTotal-index++ %>]</td>
								<td><%=vo.getName() %></td>
								<td><%=vo.getReg_date() %></td>
								<td><a href="/mysite/guest?a=deleteform	&no=<%=vo.getNo() %>">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4>
								<%=vo.getMessage().replaceAll("\n", "<br>") %>
								</td>
							</tr>
						</table>
						<br>
					</li>
					<%
						}
					%>
			</div>
		</div>
		<jsp:include page="/views/include/navication.jsp" flush="false"></jsp:include>
		<jsp:include page="/views/include/footer.jsp" flush="false"></jsp:include>
	</div>
</body>
</html>