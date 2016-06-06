var usecase=angular.module('usecase', ['ngMaterial', 'ngMessages'])
usecase.service('MyService', ['$window',function ($window) {
	var service = {
			store: store,
			retrieve: retrieve,
			clear: clear,
			clearAll: clearAll
	};

	return service;


	function store(key, value) {
		$window.sessionStorage.setItem(key, angular.toJson(value, false));
	}

	function retrieve(key) {
		return angular.fromJson($window.sessionStorage.getItem(key));
	}

	function clear(key) {
		$window.sessionStorage.removeItem(key);
	}

	function clearAll() {
		$window.sessionStorage.clear();
	}


}]);