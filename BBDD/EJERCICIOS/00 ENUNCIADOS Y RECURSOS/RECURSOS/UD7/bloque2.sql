declare
   v_empleado emple_hijos2%rowtype;
begin
        select * into v_empleado from emple_hijos2 where idpersona=&idpersona;
        dbms_output.put_line('Hijos del empleado '||v_empleado.nombre||' '||v_empleado.apellido1||' '||v_empleado.apellido2||':');
        for i in v_empleado.hijos.first .. v_empleado.hijos.last loop
         dbms_output.put_line(v_empleado.hijos(i));
        end loop;
end;
/