<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Login</title>
</head>
<body>
<f:view>
	<h:outputText value="Área Restrita"/><br><br>
	<h:form>
	
		<h:outputLabel>Login : </h:outputLabel><br>
		<h:inputText value="#{usuarioManagedBean.usuario.nome}"/><br>
		
		<h:outputLabel>Senha : </h:outputLabel><br>
		<h:inputSecret value="#{usuarioManagedBean.usuario.senha}"/><br><br>
		
		<h:commandButton value="Entrar" action="#{usuarioManagedBean.isLogin}"/>
	
	</h:form>
	
	
</f:view>
</body>
</html>