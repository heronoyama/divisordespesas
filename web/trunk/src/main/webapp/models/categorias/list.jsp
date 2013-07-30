<section id="categorias" data-ng-controller="CategoriaController">
	<div class="page-header">
		<h1>Categorias</h1>
		<ul class="nav nav-tabs">
		  <li class="active"><a href="/divisorDespesas-web?model=categorias&file=list">Home</a></li>
		  <li><a href="/divisorDespesas-web?model=categorias&file=create">Criar Nova Categoria</a></li>
		</ul>

		<a class="btn btn-primary" href="/divisorDespesas-web?model=categorias&file=create">Nova Categoria</a>
		<div class="list-group">
			<div class="list-group-item" data-ng-repeat="categoria in categorias">
				<a  href="/divisorDespesas-web?model=categorias&file=create&id={{categoria.id}}"> {{categoria.nomeCategoria}}</a>
			</div>
		</div>
	</div>
</section>
