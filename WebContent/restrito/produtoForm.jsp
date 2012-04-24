<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos</title>
</head>
<body>
	<f:view> 
		<h:form>
				<h:outputLabel value="Nome" for="nome" />
				<h:inputText id="nome" value="#{produtoManagedBean.produto.nome}" /><br><br>
	
				<h:outputLabel value="Marca" for="marca" />
				<h:inputText id="marca" value="#{produtoManagedBean.produto.marca}" /><br><br>
	
				<h:outputLabel value="Preço" for="preco" />
				<h:inputText id="preco" value="#{produtoManagedBean.produto.preco}" /><br><br>
	
				<h:commandButton value="Salvar" action="#{produtoManagedBean.salvar}" />
		</h:form>
	</f:view>
</body>
</html>