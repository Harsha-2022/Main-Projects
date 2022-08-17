<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List</title>
</head>
<body>
<br>
<a href="HomePage.jsp" style="color:black;text-decoration:none;font-size:35px;font-weight:bold;">FlyAway</a>
<br><br>
<%
	@SuppressWarnings("unchecked")
	List<String[]> flights=(List<String[]>)session.getAttribute("flights");
	if(flights!=null){
%>

<h1>Available Flights</h1>

<center>
<table border="1" cellpadding=10 cellspacing=0>
<tr>
	<th>Name</th>
	<th>From</th>
	<th>To</th>
	<th>Depature</th>
	<th>Time</th>
	<th>Price</th>
</tr>

<%
	for(String[] flight:flights){
%>

<tr>
<td><%=flight[0]%></td>
<td><%=flight[1]%></td>
<td><%=flight[2]%></td>
<td><%=flight[3]%></td>
<td><%=flight[4]%></td>
<td><%=flight[5]%></td>
</tr>
</table>
</center>
<center><a href="ConfirmList.jsp">Book Now </a> </center>
<%
	}
%>

<%
	}
	else{
%>
<h1>There are no available flights</h1>
<%
	}
%>
</body>
</html>