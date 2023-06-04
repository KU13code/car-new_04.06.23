<!DOCTYPE html>
<html>
<head>
    <title>BuyCar</title>
</head>
<body>
<h1>BuyCar</h1><hr>
<form method="get" action="/search">
    Поиск: <input type="text" name="search_request">
    <button type="submit">Поиск</button>

</form>
<#list cars as car>
    <p>${car.brand} | ${car.model} | ${car.ls} | ${car.toplivo} | ${car.price} ₽ </p>
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