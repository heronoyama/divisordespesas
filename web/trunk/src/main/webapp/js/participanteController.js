function ParticipanteController($scope ,$http){
	$scope.participantes = [{nome:'TESTE'}];
	$http({ url : "http://localhost:8080/divisorDespesas-web/servicos/participantes", method: 'GET'}).success(function(data){
		$scope.participantes = data;
	}).error(function(){
		$scope.participantes= [{nome:'erro'}];
	});
	
//	$scope.postar = function(){
//		$http({ url : "http://localhost:8080/divisorDespesas-web/servicos/categorias", method: 'Post', data:{nome:$scope.nomeCategoria}});
//	};
	
}