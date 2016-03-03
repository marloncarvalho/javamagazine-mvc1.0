<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<header> </header>
<body>
	<h1>Cadastrar Produto</h1>
	<div>
		<table>
			<c:forEach var="erro" items="${erros}">
				<tr>
					<td style="color: red">${erro.message}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <br> <br>

		<form method="POST" action="">
			Código: <input type="text" name="codigo" id="codigo" value="${produto.codigo}" /><br> 
			Nome: <input type="text" name="nome" id="nome" value="${produto.nome}" /><br> 
			Preço: <input type="text" name="preco" id="preco" value="${produto.preco}" /><br>
			Descrição: <input type="text" name="descricao" id="descricao" value="${produto.descricao}" /><br>
			<button type="submit">Enviar</button>
		</form>
		
	</div>
</body>
</html>