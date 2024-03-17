<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>MVC</title>
</head>
<body>
	<div>
		<header>
			<div style="margin-top: 58px;">
			<!--SE EJECUTA SI QUIERO QUE TENGA UN TITULO EN FUNCIÓN DE LA ACCIÓN EJECUTADA-->
				<h1><?php echo $controller->page_title; ?></h1>
				<h4>-</h4>
			</div>
		</header>