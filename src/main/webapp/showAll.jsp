<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<jsp:useBean id="storage" class="com.example.servletjspfood.service.StorageService" scope="application"/>

<tbody>
<%
	int id=0;
	for(com.example.servletjspfood.domain.Food food : storage.getAllFood()){
	id=food.getId();
	%>
	<tr>
	<td>
	<%
	out.println("<p>Nazwa ...... " + food.getName() + "</p>");
	%>
	</td>
	<td>
	<%
	out.println("<p>Typ ........ " + food.getTyp() + "</p>");
	%>
	</td>
	<td>
	<%
	out.println("<p>Sklad ...... " + food.getSklad() + "</p>");
	%>
	</td>
	<td>
	<%
	out.println("<p>Cena ....... " + food.getCena() + "</p>");
	%>
	</td>
	<%
	out.println("<td><a href=\"deleteFood?foodId="+String.valueOf(food.getId())+"\">Delete</a></td>");
	out.println("<td><a href=\"updateFoodForm?foodId="+String.valueOf(food.getId())+"&name="+String.valueOf(food.getName())+"&Typ="+String.valueOf(food.getTyp())+"&sklad="+String.valueOf(food.getSklad())+"&Cena="+Float.valueOf(food.getCena())+"\">Update</a></td></tr>");
	
}

%>
<p>
	<a href="getFoodData.jsp">Add new food</a><br/>
	<a href="index.jsp">Back to main page</a>
</p>

</body>
</html>