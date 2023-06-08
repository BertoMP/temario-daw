create or replace function cuenta_constraints(p_tabla varchar2,p_tipo char) return number
as
   v_constraints number(2) := 0;
begin
   select count(*) into v_constraints from user_constraints where table_name=p_tabla and constraint_type=p_tipo;
   return v_constraints;
end;
/