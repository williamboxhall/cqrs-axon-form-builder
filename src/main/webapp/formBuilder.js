function FormBuilderCtrl($scope, $http) {
    $scope.fields = [];
    $scope.submissions = {};

    $scope.configureNumber = function () {
        $http.post('cqrs/perform/ConfigureNumberField', {
            "name": "distance" + $scope.fields.length,
            "label": "Distance",
            "hintText": "Distance to home in metres",
            "unitOfMeasure": "length-metre"
        }).success(function () {
                $scope.refresh();
            });
    };

    $scope.configureBoolean = function () {
        $http.post('cqrs/perform/ConfigureBooleanField', {
            "name": "confirm" + $scope.fields.length,
            "label": "Confirm",
            "hintText": "Tick to confirm"
        }).success(function () {
                $scope.refresh();
            });
    };

    $scope.configureSingleLineText = function () {
        $http.post('cqrs/perform/ConfigureTextField', {
            "name": "nickname" + $scope.fields.length,
            "label": "Nickname",
            "hintText": "Your nickname 3-6 letters.",
            "minLength": "3",
            "maxLength": "6"
        }).success(function () {
                $scope.refresh();
            });
    };

    $scope.refresh = function () {
        $http.get('cqrs/view/FormConfiguration').success(function (data) {
            $scope.fields = data;
        });
    };

    $scope.submit = function () {
        debugger;
        $http.post('cqrs/perform/SubmitForm', $scope.submissions)
            .success(function () {
                alert("Success!");
            })
            .error(function () {
                alert("Failed!");
            });
    }

    $scope.refresh();
}