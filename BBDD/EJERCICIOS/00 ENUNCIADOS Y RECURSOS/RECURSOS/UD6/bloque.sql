declare
  v_num_empleados number(2);
begin
  insert into depart values (99,'PROVISIONAL',NULL);
  update emple set dept_no=99 where dept_no=20;
  v_num_empleados := SQL%ROWCOUNT;
  delete from depart where dept_no=20;
  dbms_output.put_line(v_num_empleados || ' empleados ubicados en PROVISIONAL');
exception
 when others then raise_application_error(-20000,'Error en aplicación');
end;
/
