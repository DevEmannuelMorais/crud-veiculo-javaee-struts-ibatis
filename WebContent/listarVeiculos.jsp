<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<style>
    .error-message {
        color: red; 
        font-weight: bold; /* Texto em negrito */
    }
</style>
<link rel="stylesheet" type="text/css" href="style/listar.css">
<meta charset="ISO-8859-1">
<title>Lista de Veiculos</title>
</head>


<h1>Lista de Veiculos</h1>
<h2>
    <c:choose>
        <c:when test='${not empty ERROR}'>
           <span class="error-message">${ERROR}</span>
        </c:when>
    </c:choose>
</h2>
<body>


	<form action="/detran-crud-strutsibatis/listarVeiculos.do?param=placa" method="post">
		<input type="text" name="placa" placeholder="Nome">
        <button type="submit">Buscar</button>
    </form>
    <form action="/detran-crud-strutsibatis/gerarRelatorioVeiculo.do?action=selectAll" method="post">
		<input type="hidden" name="nome">
		<button type="submit">Gerar Relatório</button>
	</form>
	

<table border=2>
	<thead>
		<tr>
			<th>Veiculo Id</th>
			<th>placa</th>
			<th>renavam </th>
			<th>Proprietario Id</th>
			<th colspan=3>Action</th>
			<th></th>
		</tr>
	</thead>
	
	<tbody>
	
	<logic:iterate id="veic" name="veiculos">
		<tr>
			<td>${veic.id}</td>
			<td>${veic.placa}</td>
			<td>${veic.renavam}</td>
			<td>${veic.id_prop}</td>
			<td class="actions">
				<form action="/detran-crud-strutsibatis/updateVeiculo.do?param=findby" method="post">
					<input type="hidden" name="id" value="${veic.id}">
        			<button type="submit">update</button>
    			</form>
    			<form action="/detran-crud-strutsibatis/deleteVeiculo.do" method="post">
    			<input type="hidden" name="id" value="${veic.id}">
        			<button type="submit">delete</button>
    			</form>
    			<form action="/detran-crud-strutsibatis/listarVeiculos.do?param=findPlaca" method="post">
    			<input type="hidden" name="placa" value="${veic.placa}">
        			<button type="submit">proprietario</button>
    			</form>
			</td>

		</tr>
	</logic:iterate>
	</tbody>
</table>
<a class="button" href="/detran-crud-strutsibatis/registerVeiculo.jsp">Add Veiculo</a>

<a class="button" href="index.jsp">Retornar</a>
</body>
</html>