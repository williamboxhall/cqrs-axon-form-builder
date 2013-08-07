function CustomFieldsCtrl($scope, $http) {
	$scope.fields = [];
	$http.get('cqrs/view/CustomFieldGroup?context=context').success(function (data) {
		$scope.fields = data;
	});
}