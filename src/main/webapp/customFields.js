function CustomFieldsCtrl($scope, $http) {
	$scope.fields = [];

	$scope.configureNumber = function () {
		$http.post('cqrs/perform/ConfigureNumberCustomField', {
			"guid":new Date().getTime(),
			"context":"context",
			"name":"distance",
			"locale":"en_AU",
			"label":"Distance",
			"hintText":"Distance to home in metres",
			"unitOfMeasure":"length-metre"
		}).success(function () {
				$scope.refresh();
			});
	};

	$scope.configureBoolean = function () {
		$http.post('cqrs/perform/ConfigureBooleanCustomField', {
			"guid":new Date().getTime(),
			"context":"context",
			"name":"married",
			"locale":"en_AU",
			"label":"Married",
			"hintText":"Are you married?"
		}).success(function () {
				$scope.refresh();
			});
	};

	$scope.configureSingleLineText = function () {
		$http.post('cqrs/perform/ConfigureSingleLineTextCustomField', {
			"guid":new Date().getTime(),
			"context":"context",
			"name":"nickname",
			"locale":"en_AU",
			"label":"Nickname",
			"hintText":"What's your nickname? 3-6 letters.",
			"minLength":"3",
			"maxLength":"6"
		}).success(function () {
				$scope.refresh();
			});
	};

	$scope.refresh = function () {
		$http.get('cqrs/view/CustomFieldGroup?context=context').success(function (data) {
			$scope.fields = data;
		});
	};

	$scope.refresh();
}