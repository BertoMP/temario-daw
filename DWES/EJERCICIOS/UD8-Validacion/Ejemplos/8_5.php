<?php
    $intNumero = 123.4567;
    printf("Con 2 decimales: %.2f<br />Sin decimales: %.0f<br />", $intNumero, $intNumero);
    
    $str1 = "Hello";
    $str2 = "Hello world!";
    printf("1º[%s]<br>",$str1);
    printf("2º\"%8s\"<br>",$str1);
    printf("3º\"%-8s\"<br>",$str1);
    printf("4º\"%08s\"<br>",$str1);
    printf("5º\"%'*8s\"<br>",$str1);
    printf("6º\"%8.8s\"<br>",$str2);

    $rlnNumeros = [0.001, 0.002, 0.003, 0.004, 0.005, 0.006, 0.007, 0.008, 1234.009];
foreach ($rlnNumeros as $rlnValor)
	print $rlnValor."->".number_format($rlnValor, 2, '\'', '.')."<br>";

?>