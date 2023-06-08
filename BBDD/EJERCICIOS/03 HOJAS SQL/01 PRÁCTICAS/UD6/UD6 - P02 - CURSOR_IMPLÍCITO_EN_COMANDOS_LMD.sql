BEGIN
    UPDATE EMPLE
        SET COMISION = COMISION + 100
        WHERE COMISION IS NOT NULL
            AND COMISION < 1000;
    DBMS_OUTPUT.PUT_LINE('Se ha cambiado la comisión a ' 
        || SQL%ROWCOUNT || ' empleados.');
END;
/
