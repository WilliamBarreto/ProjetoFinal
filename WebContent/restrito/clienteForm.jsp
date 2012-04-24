<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
	<f:view>
		<h:form> 
				<h:outputLabel value="Nome" for="nome" />
				<h:inputText id="nome" value="#{clienteManagedBean.cliente.nome}" /><br><br>
	
				<h:outputLabel value="Endereço" for="endereco" />
				<h:inputText id="marca" value="#{clienteManagedBean.cliente.endereco}" /><br><br>
	
				<h:outputLabel value="CPF" for="cpf" />
				<h:inputText id="preco" value="#{clienteManagedBean.cliente.cpf}" /><br><br>
				
				<h:outputLabel value="Cidade" for="cidade" />
				<h:inputText id="preco" value="#{clienteManagedBean.cliente.cidade}" /><br><br>
				
				<h:outputLabel value="estado" for="estado" />
				<h:inputText id="preco" value="#{clienteManagedBean.cliente.estado}" /><br><br>
				
				<h:outputLabel value="cep" for="cep" />
				<h:inputText id="preco" value="#{clienteManagedBean.cliente.cep}" /><br><br>
				
				<h:outputLabel value="E-mail" for="email" />
				<h:inputText id="preco" value="#{clienteManagedBean.cliente.email}" /><br><br>
	
				<h:commandButton value="Salvar" action="#{clienteManagedBean.salvar}" />
		</h:form>
	</f:view>

</f:view>
</body>
</html>