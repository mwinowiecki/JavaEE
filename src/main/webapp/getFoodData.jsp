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

<jsp:useBean id="food" class="com.example.servletjspfood.domain.Food" scope="session" />


<form action="foodData">

	Nazwa: <input type="text" name="name" value="${food.name }"/><br/>
	Typ: <input type="radio" name="typ" value="Vegetarian"/>Vegetarian
		<input type="radio" name="typ" value="Normal"/>Normal<br/><br/>
	
	Sklad: <br><input type="checkbox" name="sklad" value="Salata">Salata<br/>
	<input type="checkbox" name="sklad" value="Ser"/>Ser<br>
	<input type="checkbox" name="sklad" value="Szynka">Szynka<br/><br/>
	
	Cena: <input type="float" name="cena" value="${food.cena }"/><br/>
	
	<input type="submit" value=" OK ">
</form>

</body>
</html>