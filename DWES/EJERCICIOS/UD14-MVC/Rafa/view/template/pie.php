<?php
if (isset($_SESSION['logueado']) && $_SESSION['logueado'] == 'verdadero') {
?>
        <br><br>
        <a href="index.php?controller=ControladorLogin&action=close">Cerrar Sesión</a>
<?php
} ?>
        </div>
    </body>
</html>