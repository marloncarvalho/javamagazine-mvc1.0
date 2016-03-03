<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head></head>
	<body>
		<h1>Listagem de Produtos</h1>
	
		<div>
			<table>
				<c:forEach var="produto" items="${produtos}">
					<tr>
						<td>${produto.codigo}</td>
						<td><a href="/mvc1.0/web/produtos/${produto.codigo}">${produto.nome}</a></td>
						<td>${produto.preco}</td>
						<td>${produto.descricao}</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<form method="GET" action="produtos/novo/">
				<button type="submit">Incluir</button>
			</form>
		</div>
	</body>
</html>