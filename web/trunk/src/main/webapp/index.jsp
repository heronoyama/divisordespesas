<!DOCTYPE html>
<html data-ng-app>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Billing managament 1.0</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
<link href="css/variables.less" rel="stylesheet" media="screen">
<link href="css/bootswatch.less" rel="stylesheet" media="screen">

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.min.js"></script>
<script type="text/javascript" src="js/categoriaController.js"></script>

</head>
<body>
	<div class="container">
		<header class="jumbotron subhead" id="overview">
			<h1>Billing Manament</h1>
			<div class='navbar'>
				<div class='navbar-inner nav-collapse' style="height: auto;">
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#categorias">Categorias</a></li>
						<li><a href="#">Page Two</a></li>
					</ul>
				</div>
			</div>
		</header>
		<section id="categorias" data-ng-controller="CategoriaController">
			<div class="page-header">
				<h1> Categorias</h1>
				<div data-ng-repeat="categoria in categorias">
					<p>{{categoria.nomeCategoria}}</p>
				</div>
				<form class="well form-horizontal" data-ng-submit="postar()">
					<fieldset>
					<legend> Criar uma nova categoria</legend>
					<div class="control-group">
						<label> Nome </label>
						<input type="text" class="input-large" id="nomeCategoria" name="nomeCategoria" data-ng-model="nomeCategoria"/>
					</div>
						
					<div class="form-actions">
						<input type="submit" class="btn btn-primary"/>
					</div>	
					</fieldset>							
				</form>
			</div>
		</section>
	</div>
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
