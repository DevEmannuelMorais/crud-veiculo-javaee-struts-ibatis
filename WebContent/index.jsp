<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet" type="text/css" href="style/index.css">
<meta charset="UTF-8">
<title>CRUD Veiculos e Proprietarios</title>
</head>
<body>
<h1>CRUD Veiculos e Proprietarios</h1>
<div class="form-container">

<form action="/detran-crud-strutsibatis/listarProprietario.do" method="post">
        <button type="submit">Proprietário</button>
    </form>
    <form action="/detran-crud-strutsibatis/listarVeiculos.do" method="post">
        <button type="submit">Veiculo</button>
    </form>
   
</div>
	

</body>
</html>