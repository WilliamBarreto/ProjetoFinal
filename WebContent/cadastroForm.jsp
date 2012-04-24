<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadatro de Cliente</title>
</head>
<body>
<f:view>
	
	<h:form>
		
		<h:outputLabel>Dados Pessoais</h:outputLabel><br><br>
		
		<h:outputLabel>Nome : </h:outputLabel>
		<h:inputText value="#{clienteManagedBean.cliente.nome}"/><br>
		
		<h:outputLabel>CPF : </h:outputLabel>
		<h:inputText value="#{clienteManagedBean.cliente.cpf}"/><br><br>
		
		<h:outputLabel>E-mail : </h:outputLabel>
		<h:inputText value="#{clienteManagedBean.cliente.email}"/><br>
		
		<h:outputLabel>Endereço</h:outputLabel><br><br>
		
		<h:outputLabel>Logradouro</h:outputLabel>
		<h:inputText value="#{clienteManagedBean.cliente.logradouro}"/><br>
		
		<h:outputLabel>Bairro</h:outputLabel>
		<h:inputText value="#{clienteManagedBean.cliente.bairro}"/><br>
		
		<h:outputLabel>Cidade</h:outputLabel>
		<h:inputText value="#{clienteManagedBean.cliente.cidade}"/><br>
		
		<h:outputLabel>UF</h:outputLabel>
		<h:inputText value="#{clienteManagedBean.cliente.uf}"/><br>
		
		<h:outputLabel>CEP</h:outputLabel>
		<h:inputText value="#{clienteManagedBean.cliente.cep}"/>	<br>
		
		<h:commandButton value="Salvar" action="#{clienteManagedBean.salvar}"/>
	
	</h:form>
	
</f:view>
</body>
</html>