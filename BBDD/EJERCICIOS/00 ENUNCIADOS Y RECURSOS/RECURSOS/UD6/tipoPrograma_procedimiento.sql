create or replace procedure info_constraints_tabla(p_tabla varchar2)
as
prueba number;
begin
   dbms_output.put_line('CONSTRAINTS DE LA TABLA '||p_tabla||':');
   dbms_output.put_line(' - Tipo P: '||cuenta_constraints(p_tabla,'P'));
   dbms_output.put_line(' - Tipo R: '||cuenta_constraints(p_tabla,'R'));
   dbms_output.put_line(' - Tipo C: '||cuenta_constraints(p_tabla,'C'));
   dbms_output.put_line(' - Tipo U: '||cuenta_constraints(p_tabla,'U'));
end;
/