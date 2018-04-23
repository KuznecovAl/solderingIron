
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>

<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <form action="frontController?command=settings" method="post" accept-charset="UTF-8" enctype="application/x-www-form-urlencoded">
        <table style="text-align: left">
            <tr>
                <td><b>ID</b></td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td><b>Login</b></td>
                <td><b>${user.login}</b></td>
            </tr>
            <tr>
                <td><b>Password</b></td>
                <td><input type="password" name="password" maxlength="20" placeholder="новый пароль"/></td>
            </tr>
            <tr>
                <td><b>E-mail</b></td>
                <td><input type="email" name="e_mail" maxlength="50" placeholder="е-мэил" value="${user.email}" /></td>
            </tr>
            <tr>
                <td><b>Имя</b></td>
                <td><input type="text" name="name" maxlength="50" placeholder="Имя" value="${user.firstname}" /></td>
            </tr>
            <tr>
                <td><b>Фамилья</b></td>
                <td><input type="text" name="lname" maxlength="50" placeholder="Фамилия" value="${user.lastname}" /></td>
            </tr>
            <tr>
                <td><b>Телефон</b></td>
                <td><input type="text" name="phone" maxlength="50" placeholder="Телефон" value="${user.phone}" /></td>
            </tr>
            <tr>
                <td><b>Город</b></td>
                <td><input type="text" name="address_city" maxlength="50" placeholder="Город"
                           value="${user.address.city}" /></td>
            </tr>
            <tr>
                <td><b>Улица</b></td>
                <td><input type="text" name="address_street" maxlength="50" placeholder="Улица"
                           value="${user.address.street}" /></td>
            </tr>
            <tr>
                <td><b>Дом</b></td>
                <td><input type="text" name="address_building" maxlength="50" placeholder="Дом"
                           value="${user.address.building}" /></td>
            </tr>
            <tr>
                <td><b>Квартира</b></td>
                <td><input type="text" name="address_flat" maxlength="50" placeholder="Квартира"
                           value="${user.address.flat}"></td>
            </tr>
            <tr>
                <td><b>Индекс</b></td>
                <td><input type="text" name="address_index" maxlength="50" placeholder="Индекс"
                           value="${user.address.index}" /></td>
            </tr>
            <tr>
                <td><b>Дата рождения</b></td>
                <td><input type="date" name="birthday" value="${user.birthday}" /></td>
            </tr>
        </table>

        <input type="submit" value="Сохранить!">
    </form>


</div>
