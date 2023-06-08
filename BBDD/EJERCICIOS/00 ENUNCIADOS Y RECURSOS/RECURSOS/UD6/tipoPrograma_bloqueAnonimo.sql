declare
  v_tabla varchar2(30);
  v_constraints number(2) := 0;
begin
   v_tabla := upper('&tabla');
   dbms_output.put_line('CONSTRAINTS DE LA TABLA '||v_tabla||':');
   select count(*) into v_constraints from user_constraints where table_name=v_tabla and constraint_type='P';
   dbms_output.put_line(' - Tipo P: '||v_constraints);
   select count(*) into v_constraints from user_constraints where table_name=v_tabla and constraint_type='R';
   dbms_output.put_line(' - Tipo R: '||v_constraints);
   select count(*) into v_constraints from user_constraints where table_name=v_tabla and constraint_type='C';
   dbms_output.put_line(' - Tipo C: '||v_constraints);
   select count(*) into v_constraints from user_constraints where table_name=v_tabla and constraint_type='U';
   dbms_output.put_line(' - Tipo U: '||v_constraints);
end;
/