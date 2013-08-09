function CustomFieldsCtrl($scope, $http) {
	$scope.fields = [];
	$scope.submissions = {};

	$scope.configureNumber = function () {
		$http.post('cqrs/perform/ConfigureNumberCustomField', {
			"guid":$scope.fields.length,
			"context":"context",
			"name":"distance" + $scope.fields.length,
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
			"guid":$scope.fields.length,
			"context":"context",
			"name":"confirm" + $scope.fields.length,
			"locale":"en_AU",
			"label":"Confirm",
			"hintText":"Tick to confirm"
		}).success(function () {
				$scope.refresh();
			});
	};

	$scope.configureSingleLineText = function () {
		$http.post('cqrs/perform/ConfigureSingleLineTextCustomField', {
			"guid":$scope.fields.length,
			"context":"context",
			"name":"nickname" + $scope.fields.length,
			"locale":"en_AU",
			"label":"Nickname",
			"hintText":"Your nickname 3-6 letters.",
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