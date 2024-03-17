<?php 
function cifradoCesar(string &$strTexto, int $intDesplazamiento) {
    $intDesplazamiento = $intDesplazamiento % (ord('z') - ord('a') + 1);

    for($intCont = 0; $intCont < strlen($strTexto); $intCont++) {
        if(ctype_alpha($strTexto[$intCont])) {
            $letraFinal = chr(ord($strTexto[$intCont]) + $intDesplazamiento);
            if (ord($letraFinal) > ord('z') && ctype_lower($strTexto[$intCont])) {
                $letraFinal = chr(ord($letraFinal) - (ord('z') - ord('a') + 1));
            } else if (ord($letraFinal) > ord('Z') && ctype_upper($strTexto[$intCont])) {
                $letraFinal = chr(ord($letraFinal) - (ord('Z') - ord('A') + 1));
            }
            $strTexto[$intCont] = $letraFinal;
        }
    }
}
?>