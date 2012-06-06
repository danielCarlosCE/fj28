<%-- 
    Document   : cabecalho
    Created on : 06/06/2012, 11:41:58
    Author     : danielcarlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<c:url value="../css/base.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="../css/menu.css" />" />
        <title>FJ28</title>
    </head>
    <body>
        <div class='cssmenu'>
            <ul>
                <li class='active '><a href='#'><span>Home</span></a></li>
                <li><a href='lista'><span>Lista de Produtos</span></a></li>
                <li><a href='formulario'><span>Novo Produto</span></a></li>
                <li><a href='#'><span>Contato</span></a></li>
            </ul>
        </div>
