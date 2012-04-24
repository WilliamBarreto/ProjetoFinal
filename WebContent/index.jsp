<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	a {
	font: 12px  Arial, Verdana,Helvetica,sans-serif;
	color: #000;
	text-decoration: none;
	background:  #FFC50C;
	text-align: center; 
	padding: 5px 20px;
	margin-right:1px;
	border: 1px solid #000;
	}
	a:hover {
	color: #666;
	background: #FCFCFC;
	border: 1px solid #666;
	}
	
</style>
</head>
<body style="background: #828282">
	<f:view>
		<h:outputLink style="text-align:right">Area Restrita</h:outputLink>
		<div style="text-align: center;">
			<h:graphicImage value="/img/banner.jpg"/>
		</div>
		<br>
		<br>
		<div style="text-align: center;">
			<h:outputLink >Home</h:outputLink>
			<h:outputLink >Produtos</h:outputLink>
			<h:outputLink >Localização</h:outputLink>
			<h:outputLink >Contato</h:outputLink>
			<h:outputLink >Cadastro</h:outputLink>
		</div>
		
	</f:view>
</body>
</html>