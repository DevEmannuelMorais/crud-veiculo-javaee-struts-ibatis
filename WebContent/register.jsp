<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1"/>
<link rel="stylesheet" type="text/css" href="style/style.css">
    <title>CRUD de Proprietários</title>
</head>
<body>
	<h1>Cadastrar Novo Proprietário</h1>
	 
    <form action="<c:choose>
                 <c:when test='${empty proprietario.nome}'>/detran-crud-strutsibatis/cadastrarProprietario.do</c:when>
                 <c:otherwise>/detran-crud-strutsibatis/updateProprietario.do</c:otherwise>
               </c:choose>" method="post">
      <table>
      	<tr>
			<td><input type="hidden" name="id"  value="<c:out value="${proprietario.id}"/>"></td>
		</tr>
 
      	<tr>
      		<td> Nome: <input type="text" id="nome" name="nome" required maxlength="20" minlength="3" value="<c:out value="${proprietario.nome}"/>"> </td>
      	</tr>
	        
        <tr>
        	<td>CPF/CNPJ: <input type="text" id="cpfCnpj" name="cpf_cnpj" required maxlength="14" minlength="11" value="<c:out value="${proprietario.cpf_cnpj}"/>"></td>
        </tr>
        
        <tr>
        	<td>Endereço: <input type="text" id="endereco" name="endereco" required value="<c:out value="${proprietario.endereco}"/>"></td>
        </tr>
    
      </table>
        
        
        <button type="submit"><c:choose>
                          <c:when test='${empty proprietario.nome}'>Cadastrar</c:when>
                          <c:otherwise>Atualizar</c:otherwise>
                        </c:choose></button>
                        <c:choose>
    <c:when test='${not empty message}'>
        <div class="erro">${message}</div>
    </c:when>
</c:choose>
    </form>
    <p><a href="index.jsp">Retornar ao inicio</a>
</body>
</body>
</html>