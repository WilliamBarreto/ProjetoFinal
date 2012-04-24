<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Logado!!</h1>
	<f:view>
		
		<h:outputText value="Supermercado On Line"
			style="font: 18px Arial; font-weight: bold;" />
		<p />
		<h:outputText value="Manuten&ccedil;&atilde;o" escape="false"
			style="font: 16px Arial; font-weight: bold; color: gray;" />
		<p />
		
		
		<h:form style="font: 14px Arial;">
			<h:commandLink value="Produto" action="#{produtoManagedBean.listar}" />
			<br />
			<h:commandLink value="Usuarios" action="#{usuarioManagedBean.listar}" />
			<br />
			<h:commandLink value="Clientes" action="#{clienteManagedBean.listar}" />

		</h:form>

	</f:view>
</body>
</html>