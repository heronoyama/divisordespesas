<section id="categorias" data-ng-controller="CategoriaController">
		<h1>Categorias</h1>
		<ul class="nav nav-tabs">
		  <li><a href="/divisorDespesas-web?model=categorias&file=list">Home</a></li>
		  <li class="active"><a href="/divisorDespesas-web?model=categorias&file=create">Criar Nova Categoria</a></li>
		</ul>
		<div class="page-header">
				<form class="well form-horizontal" data-ng-submit="postar()">
					<fieldset>
						<legend> Criar uma nova categoria</legend>
						<div class="control-group">
							<label> Nome </label> <input type="text" class="input-large"
								id="nomeCategoria" name="nomeCategoria"
								data-ng-model="nomeCategoria" />
						</div>
		
						<div class="form-actions">
							<input type="submit" class="btn btn-primary" />
						</div>
					</fieldset>
				</form>
		</div>

</section>
