<?php
if($_SESSION['tipo'] === 'deposito')
    borradoUltimoId();
header('Location: index.php');
