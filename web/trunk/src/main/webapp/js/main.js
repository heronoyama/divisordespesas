function Page(data){
	var self = this;
	self.page = data.page;
	self.view = data.view;
	
	self.getUrl = function(){ return '#'+ self.page+'/'+self.view; };
	self.getTemplateLocation = function(){ return 'templates/'+self.view + '.html'};
};

var defaultPage = new Page({page: 'Eventos', view:'eventosView'});

function HeaderViewModel(){
	var self = this;
	self.pages = ko.observableArray(
			[ defaultPage,
			  new Page({page: 'Participantes', view:'participantesView'})
			]);
	self.currentPage = ko.observable();
	
	self.setPage = function(page,view){
		 var pageToLoad  = $.grep(self.pages(), function(element){
	        	return element.page == page && element.view == view;
	        })[0]; //TODO is fucking ugly
		 if(!pageToLoad) //TODO
			 console.log('TODO: Tratamento 404');
		 self.currentPage(pageToLoad);
		 $('#content').load(pageToLoad.getTemplateLocation());
	};
	
};

var headerModel  = new HeaderViewModel();
ko.applyBindings(headerModel,$('#headerController')[0]);

Sammy(function (){
	this.get('#:page/:view',function(){
		headerModel.setPage(this.params['page'],this.params['view']);
	});   
}).run(defaultPage.getUrl());



