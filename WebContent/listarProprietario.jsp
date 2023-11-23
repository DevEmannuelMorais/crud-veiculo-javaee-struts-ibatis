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

<h1>Lista de Proprietários</h1>
<form action="/detran-crud-strutsibatis/listarProprietario.do?param=nomeCpf" method="post">
	<input type="text" name="nome" placeholder="Nome">
	<button type="submit">Buscar</button>
</form>
<form action="/detran-crud-strutsibatis/gerarRelatorioProprietario.do?action=selectAll" method="post">
	<input type="hidden" name="nome">
	<button type="submit">Gerar Relatório</button>
</form>

<table border=2>
	<thead>
		<tr>
			<th>Proprietario Id</th>
			<th>Nome</th>
			<th>CPF/CNPJ </th>
			<th>Endereço</th>
			<th colspan=3>Action</th>
			<th></th>
		</tr>
	</thead>
	
	<tbody>
	
	<logic:iterate id="propri" name="proprietarios">
		<tr>
			<td>${propri.id}</td>
			<td>${propri.nome}</td>
			<td>${propri.cpf_cnpj}</td>
			<td>${propri.endereco}</td>
			<td class="actions">
				<form action="/detran-crud-strutsibatis/updateProprietario.do?param=findby" method="post">
					<input type="hidden" name="id" value="${propri.id}">
        			<button type="submit">update</button>
    			</form>
    			<form action="/detran-crud-strutsibatis/deleteProprietario.do" method="post">
    			<input type="hidden" name="id" value="${propri.id}">
        			<button type="submit">delete</button>
    			</form>
    			<form action="/detran-crud-strutsibatis/listarVeiculos.do?param=veiculos" method="post">
    			<input type="hidden" name="id_prop" value="${propri.id}">
        			<button type="submit">veiculos</button>
    			</form>
			</td>

		</tr>
	</logic:iterate>
	</tbody>
</table>
<a class="button" href="/detran-crud-strutsibatis/register.jsp">Add Proprietário</a>

<a class="button" href="index.jsp">Retornar ao inicio</a>
</body>
</html>