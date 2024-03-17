<form action="./Controlador/inserciones.php" method="get">
    <p><label for="litros">Litros</label>
    <input type="number" name="litros" id="litros"></p>

    <label for="tipo_combustible">tipo de combustible</label>
    <select name="tipo_combustible" id="tipo_combustible">
        <option value="" disabled selected>--seleccionar--</option>
        <option value="gasoil">gasoil</option>
        <option value="gasolina_95">gasolina 95</option>
        <option value=" gasolina_98"> gasolina 98</option>
        <option value="gasoil_agricola">gasoil agrícola</option>
    </select>

    <p><label for="importeTotal">Importe total</label>
    <input type="number" name="importeTotal" id="importeTotal"></p>

    <input type="submit" value="Enviar">
</form>