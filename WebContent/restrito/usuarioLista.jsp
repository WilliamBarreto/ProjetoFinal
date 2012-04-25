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

<h:outputText value="Supermercado On Line"
			style="font: 18px Arial; font-weight: bold;" />
		<p />
		<h:outputText value="Listagem de Produtos"
			style="font: 16px Arial; font-weight: bold; color: gray;" />
		<p />
		<h:form>
			<h:messages layout="table" errorStyle="color: red"
				infoStyle="color: green" warnStyle="color: orange"
				fatalStyle="color: gray" style="font: 14px Arial;"
				showSummary="false" showDetail="true" />
			<h:dataTable value="#{usuarioSistemaManagedBean.usuarios}" var="item"
				border="1" style="font: 14px Arial;">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{item.nome}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Senha" />
					</f:facet>
					<h:outputText value="#{item.senha}" />
				</h:column>

				<h:column>
				<h:commandLink actionListener="#{usuarioSistemaManagedBean.excluir}">
					<f:attribute name="usuario" value="#{item}" />
					<h:graphicImage value="/img/excluir.png" title="Excluir"
						style="border: none" />
				</h:commandLink>
				</h:column>
				
				<h:column>
				<h:commandLink action="incluirEditar">
					<f:setPropertyActionListener value="#{item}"
						target="#{usuarioSistemaManagedBean.usuario}" />
					<h:graphicImage value="/img/editar.png" title="Editar"
						style="border: none" />
				</h:commandLink>
				</h:column>
			</h:dataTable>

			<p />
			<h:commandButton value="Incluir" action="incluirEditar" />
			<h:commandButton value="Voltar" action="raiz" />
		</h:form>

</f:view>
</body>
</html>