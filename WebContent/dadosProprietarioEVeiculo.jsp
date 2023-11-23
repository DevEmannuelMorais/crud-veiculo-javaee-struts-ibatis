<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet" type="text/css" href="style/listar.css">
<meta charset="ISO-8859-1">
<title>Lista de Proprietarios</title>
</head>
<body>

<h1>Dados do proprietário</h1>
<table border=2>
	<thead>
		<tr>
			<th>Nome</th>
			<th>CPF/CNPJ</th>
			<th>Endereço</th>
			<th>Placa</th>
			<th>Renavam</th>
			<th colspan=1>Action</th>
			
		</tr>
	</thead>
	
	<tbody>
	
	<logic:iterate id="veicProp" name="veiculoProp">
		<tr>
			<td>${veicProp.nome}</td>
			<td>${veicProp.cpf_cnpj}</td>
			<td>${veicProp.endereco}</td>
			<td>${veicProp.placa}</td>
			<td>${veicProp.renavam}</td>
			<td class="actions">
				<form action="/detran-crud-strutsibatis/listarVeiculos.do?param=veiculos&cpf=${veicProp.cpf_cnpj}" method="post">
    			<input type="hidden" name="id_prop" value="${veicProp.cpf_cnpj}">
        			<button type="submit">veiculos</button>
    			</form>
    			<form action="/detran-crud-strutsibatis/gerarRelatorioVeiculo.do?action=relVeiculoPlaca" method="post">
					<input type="hidden" name="placa" value="${veicProp.placa}">
					<button type="submit">Gerar Relatório</button>
				</form>
			</td>

		</tr>
	</logic:iterate>
	</tbody>
</table>

<a class="button" href="/detran-crud-strutsibatis/listarVeiculos.do">Retornar</a>
</body>
</html>