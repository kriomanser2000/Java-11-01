<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Filter</title>
</head>
<body>
<h1>Car Filter</h1>
<form action="/filterCars" method="get">
    <label for="manufacturer">Manufacturer: </label>
    <input type="text" name="manufacturer" id="manufacturer">
    <br><br>
    <label for="color">Color: </label>
    <input type="text" name="color" id="color">
    <br><br>
    <label for="type">Type: </label>
    <input type="text" name="type" id="type">
    <br><br>
    <label for="minCapacity">Min Capacity: </label>
    <input type="number" step="0.1" name="minCapacity" id="minCapacity">
    <br>
    <label for="maxCapacity">Max Capacity: </label>
    <input type="number" step="0.1" name="maxCapacity" id="maxCapacity">
    <br><br>
    <button type="submit">Filter</button>
</form>
</body>
</html>
