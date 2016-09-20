angular.module("ThePicture")
        .controller("navigationCtrl", function($scope) {

            var views = ['photosView.html'];

            $scope.currentView = 0;

            $scope.getViewAdress = function() {
                return 'views/' + views[$scope.currentView];
            };

            $scope.setCurrentView = function(novue) {
                $scope.currentView = novue;
            };
        });