function Evento(data){
	this.nome = ko.observable(data.nome);
	this.id = ko.observable(data.id);
}

function EventosModel(){
	var self = this;
	//Data-binding

	self.eventos = ko.observableArray([]);
	self.nome = ko.observable('nome');

	self.criaEvento = function(formElement){
		$.ajax('servicos/eventos',{
			data : ko.toJSON( {nome: self.nome()}),
			type : 'post',
			contentType: 'application/json',
			success: function(result) { 
				var eventos = self.eventos();
				ko.utils.arrayPushAll(eventos,[new Evento(result)]);
				self.eventos.valueHasMutated();
				self.nome(null);
				location.hash = 'Eventos';
			},
			error: function(result) { console.log(result);}
		});
	};

	$.getJSON(
		'servicos/eventos',
		function(allData){
			var mappedEventos = $.map(allData, function(item) { return new Evento(item); });
			self.eventos(mappedEventos);
		});

	self.nome(null);


}

//ko.applyBindings(new EventosControllerModel() ,$('#EventoList')[0]);