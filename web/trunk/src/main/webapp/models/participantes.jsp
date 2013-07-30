<section id="participantes" data-ng-controller="ParticipanteController">
			<div class="page-header">
				<h1> Participantes</h1>
				<div data-ng-repeat="participante in participantes">
					<p>{{participante.nome}}</p>
				</div>
				<form class="well form-horizontal" data-ng-submit="postar()">
					<fieldset>
					<legend> Criar um novo participante</legend>
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