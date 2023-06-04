<!DOCTYPE html>
<html>
<head>
    <title>Car-info</title>
</head>

<body>
<h2>Результаты Поиска:</h2>
    <#list search_result as car>
        <p>${car.brand} | ${car.model} | ${car.ls} | ${car.toplivo} | ${car.price} ₽ </p>
    </#list>
</body>
</html>
