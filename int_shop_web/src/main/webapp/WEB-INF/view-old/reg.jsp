<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>

<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <form action="\registration" method="post" accept-charset="UTF-8">
        <b>Логин</b><input type="text" name="login" maxlength="30"/>
        <b>Password</b><input type="password" name="password" maxlength="20"/>
        <b>E-mail</b><input type="email" name="e_mail" maxlength="50"/><br/>
        <input type="submit" value="Зарегистрироваться">
    </form>
    <form action="frontController?command=login" method="post" accept-charset="UTF-8">
        <input type="submit" value="Вход">
    </form>
</div>
