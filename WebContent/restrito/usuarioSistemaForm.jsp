<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Criar Usuario</title>
</head>
<body>
<f:view>
	<h:form>
	
		<h:outputLabel>Nome do Usuario</h:outputLabel><br>
		<h:inputText value="#{usuarioSistemaManagedBean.usuario.nome}"/><br>
		
		<h:outputLabel>Senha</h:outputLabel><br>
		<h:inputText value="#{usuarioSistemaManagedBean.usuario.senha}"/><br>
		
		<h:commandButton value="Salvar" action="#{usuarioSistemaManagedBean.salvar}"/>
		<h:commandButton value="Voltar" action="raiz" />
	</h:form>
</f:view>
</body>
</html>