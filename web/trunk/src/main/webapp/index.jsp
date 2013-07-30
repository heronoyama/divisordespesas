<!DOCTYPE html>
<html data-ng-app="divisorDespesas-web">
<head>
<base href="/divisorDespesas-web/"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Billing managament 1.0</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
<link href="css/variables.less" rel="stylesheet" media="screen">
<link href="css/bootswatch.less" rel="stylesheet" media="screen">

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.min.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript" src="js/categoriaController.js"></script>
<script type="text/javascript" src="js/participanteController.js"></script>

</head>
<body>
	<div class="container">
		<header class="jumbotron subhead" id="overview">
			<h1>Billing Manament</h1>
			<div class='navbar'>
				<div class='navbar-inner nav-collapse' style="height: auto;">
					<ul class="nav">
						<li class="active"><a href="/divisorDespesas-web">Home</a></li>
						<li><a href="/divisorDespesas-web?model=categorias&file=list">Categorias</a></li>
						<li><a href="/divisorDespesas-web?dir=models&file=participantes">Participantes</a></li>
					</ul>
				</div>
			</div>
		</header>
		
		<%
			String parametroDiretorio = request.getParameter("model");
		 	String diretorio = parametroDiretorio == null ? "models" : "models/"+parametroDiretorio;
		 
		 	String parametroArquivo = request.getParameter("file");
		 	String arquivo = parametroArquivo == null ? "home" : parametroArquivo;
		 	
		 	String caminhoCompleto = diretorio+"/"+arquivo+".jsp"; 
		%>    
		
		<jsp:include page="<%=caminhoCompleto%>" flush="true"/>
		
		
	</div>
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>