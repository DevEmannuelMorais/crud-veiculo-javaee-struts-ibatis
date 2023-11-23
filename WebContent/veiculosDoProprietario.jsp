<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet" type="text/css" href="style/listar.css">
<meta charset="ISO-8859-1">
<title>Lista de Veiculos</title>
</head>
<body>

<h1>Lista de Veiculos do Proprietario</h1>


<table border=2>
	<thead>
		<tr>
			<th>Veiculo Id</th>
			<th>placa</th>
			<th>renavam </th>
		
			
			<th></th>
		</tr>
	</thead>
	
	<tbody>
	
	<logic:iterate id="veic" name="veiculos">
		<tr>
			<td>${veic.id}</td>
			<td>${veic.placa}</td>
			<td>${veic.renavam}</td>
			
			
		</tr>
	</logic:iterate>
	</tbody>
</table>

<a class="button" href="/detran-crud-strutsibatis/listarVeiculos.do">Retornar</a>
</body>
</html>