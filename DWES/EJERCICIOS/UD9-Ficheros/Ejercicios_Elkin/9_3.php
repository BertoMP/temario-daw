<?php
    $strUbicacion = isset($_GET["dir"])?$_GET["dir"]:getcwd();
    if(is_dir($strUbicacion)){
        $strArrListado=scandir($strUbicacion);
        foreach($strArrListado as $strValor)
            mostrar($strUbicacion, $strValor, 0);}
    

    function mostrar(string $strUbicacion, string $strElemento, int $intTabulaciones){
        $strUbic =  $strUbicacion . '\\' . $strElemento;
        if(is_file($strUbic) || is_dir($strUbic) && 
           $strElemento!='..' && $strElemento!='.'){
                echo tabula($intTabulaciones) . "$strElemento<br />\n";
                if(is_dir($strUbic) ){
                        $strArrListado=scandir($strUbic);
                        foreach($strArrListado as $strValor)
                            mostrar($strUbic, $strValor, ($intTabulaciones+1));
                }
        }
    }

    function tabula(int $intTabulaciones):string{
        $strDevuelve='';
        for($intCont=0; $intCont<$intTabulaciones; $intCont++)
            $strDevuelve .= '&nbsp;&nbsp;&nbsp;&nbsp;';

        return  $strDevuelve;
    }
?>