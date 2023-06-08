CREATE OR REPLACE
PROCEDURE modificar_precio_producto (p_numproducto NUMBER, p_nuevoprecio NUMBER)
AS
	v_precioant NUMBER; --precio anterior
BEGIN
	select precio_uni into v_precioant from productos
		where producto_no = p_numproducto;
	IF (v_precioant * 0.20) > (p_nuevoprecio - v_precioant) THEN
update productos SET precio_uni = p_nuevoprecio where producto_no = p_numproducto;
	ELSE
		dbms_output.put_line ('Error, la modificación supera el 20%');
	END IF;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		dbms_output.put_line('No encontrado producto '||p_numproducto);
END modificar_precio_producto;
/
