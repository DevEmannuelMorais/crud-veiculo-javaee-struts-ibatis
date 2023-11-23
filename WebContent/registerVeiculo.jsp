<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/style.css">
<title>Registrar Veiculo</title>
</head>
<body>
<h1>Cadastrar Novo Veiculo</h1>
    <form action="<c:choose>
                 <c:when test='${empty veiculo.placa}'>/detran-crud-strutsibatis/cadastrarVeiculo.do</c:when>
                 <c:otherwise>/detran-crud-strutsibatis/updateVeiculo.do</c:otherwise>
               </c:choose>" method="post">
      <table>
      	<tr>
			<td><input type="hidden" name="id"  value="<c:out value="${veiculo.id}"/>"></td>
		</tr>
 
      	<tr>
      		<td> Placa: <input type="text" id="placa" name="placa" required value="<c:out value="${veiculo.placa}"/>"> </td>
      	</tr>
	        
        <tr>
        	<td>Renavam: <input type="text" id="renavam" name="renavam" required value="<c:out value="${veiculo.renavam}"/>"></td>
        </tr>
        
        <tr>
        	<td>Proprietario Id: <input type="text" id="id_prop" name="id_prop" required value="<c:out value="${veiculo.id_prop}"/>"></td>
        </tr>
    
      </table>
        
        
        <button type="submit"><c:choose>
                          <c:when test='${empty veiculo.placa}'>Cadastrar</c:when>
                          <c:otherwise>Atualizar</c:otherwise>
                        </c:choose></button>
     <c:choose>
    <c:when test='${not empty message}'>
        <div class="erro">${message}</div>
    </c:when>
</c:choose>               
    </form>
    <p><a href="/detran-crud-strutsibatis/listarVeiculos.do">Retornar ao inicio</a>
	

</body>
</html>