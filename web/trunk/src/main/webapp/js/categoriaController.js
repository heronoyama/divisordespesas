function CategoriaController($scope ,$http, $location){
	$http({ url : "http://localhost:8080/divisorDespesas-web/servicos/categorias", method: 'GET'}).success(function(data){
		$scope.categorias = data;
	}).error(function(){
		$scope.categorias = [{nomeCategoria:'erro'}];
	});
	
	$scope.postar = function(){
		$http({ url : "http://localhost:8080/divisorDespesas-web/servicos/categorias", method: 'Post', data:{nome:$scope.nomeCategoria}})
			.success(function(data){
				//redirect
			})
			.error(function(){
				//criar controle de erro
				
			});
	};
	
	$scope.categoriaSelecionada = $location.search().id;
	
}