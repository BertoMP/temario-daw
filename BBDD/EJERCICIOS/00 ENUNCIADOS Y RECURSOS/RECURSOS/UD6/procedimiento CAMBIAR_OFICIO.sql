create or replace procedure cambiar_oficio (num_empleado number, nuevo_oficio varchar2)
as
  v_anterior_oficio emple.oficio%type;
begin
  select oficio into v_anterior_oficio from emple where emp_no=num_empleado;
  update emple set oficio=nuevo_oficio where emp_no=num_empleado;
    dbms_output.put_line('Antiguo oficio: '||v_anterior_oficio||' Nuevo oficio: '||nuevo_oficio);
end cambiar_oficio;
/