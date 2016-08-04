function AppModel(){

	var self = this;
	self.currentModel = ko.observable();
    self.currentView = ko.observable();
    self.views = ko.observableArray([
        {name:'Eventos', model : new EventosModel()},
        {name: 'Participantes', model : new ParticipantesModel()}
        ]);

    self.setCurrentModel = function(view){
        var objectToLoad = $.grep(self.views(), function(element){
        	return element.name == view;
        })[0]; //TODO is fucking ugly
        
        self.currentModel(objectToLoad.model);
        self.currentView(view);
    };
    
}

var appModel = new AppModel();
ko.applyBindings(appModel);

Sammy(function (){
	this.get('/#:view',function(){
        appModel.setCurrentModel(this.params.view);
	});   
}).run('#Eventos');