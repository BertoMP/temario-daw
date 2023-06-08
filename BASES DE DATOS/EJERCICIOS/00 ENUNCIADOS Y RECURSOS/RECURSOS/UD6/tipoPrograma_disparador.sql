create or replace trigger prueba_trigger
before insert on emple
for each row
begin
 dbms_output.put_line('ENHORABUENA, HAS CONTRATADO AL NUEVO EMPLEADO: '||:new.apellido||'.');
 --En este ejemplo solo se muestra un texto, pero podría hacerse cualquier acción en la BD (actualización de tablas...)
END;
/