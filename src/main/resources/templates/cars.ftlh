<!DOCTYPE html>
<html>
<head>
    <title>BuyCar</title>
</head>
<body>
<h1>BuyCar</h1><hr>
<form method="get" action="/">
    Поиск: <input type="text" name="search_request" value="${search_request?if_exists}">
    <button type="submit">Поиск</button>

</form>
<#list cars as car>
    <p><a href="/${car.id}"><b> ${car.brand}</b></a> | ${car.model} | ${car.ls} | ${car.toplivo} | ${car.price} ₽ </p>
</#list>
<hr>
<h3>Добовление нового Авто:</h3>
<form action="/" method="post">
    Бренд: <input type="text" name="brand">
    <br><br>
    Модель: <input type="text" name="model">
    <br><br>
    ЛС: <input type="text" name="ls">
    <br><br>
    Топливо: <input type="text" name="toplivo">
    <br><br>
    Цена: <input type="text" name="price">
    <br><br>
    <button type="submit">Добавить</button>
</form>
</body>
</html>