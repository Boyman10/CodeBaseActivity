<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>HEADER</h1>
<nav>
<a href="/">Home</a>
</nav>
    <s:if test="#session.user">
            Utilisateur connecté :
            <s:property value="#session.user.pseudo" />

            <s:a action="logout">Déconnexion</s:a>
    </s:if>
    <s:else>
        <s:a action="login">Connexion</s:a>
    </s:else>