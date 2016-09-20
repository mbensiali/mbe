// si vous ne mettez pas les dependances
// cela veu dire que vous ne creer pas un module
// mais recupérer un module déjà creer
// constant permet de definie une constante, que vous ouvez par la suite
// injecter dans les controller, filtre, service, etc... de votre module
angular.module("ThePicture")
       .constant("orderColumnClass" , "btn-primary")
       .constant("photoUrl", "http://localhost:8080/galeriephoto/photo")
       .controller("photoCtrl", function($scope, $http, photoUrl, orderColumnClass) {
       // la variable $scope
       // c'est un contexte, zone de stockage de mon controlleur
       //
       // <div ng-controller="produitCtrl">         -->  $scope
       // ...   {{mydata.message}}         <--           $scope.mydata.message
       //  <input type="text" ng-model="mydata.nom" <->  $scope.mydata.nom
       // </div>
       //
       // on peu utiliser des filtres
       // qui permette de traiter, directement dans le html, les données
       // avant affichage : par exemple currency
       // donne | filter
       // pour chainer plusieur filtres
       // si on veu passer un parametre en 'dur', il faut le mettre en ''
       // sinon, angular assume que c'est une propriété du scope
       // <tr ng-repeat="produit in data.produits | orderBy: 'poids' | noStock: data.isStockFilterActive">

/*
*     <div class="row alert alert-danger" ng-show="data.error">
                Error {{data.error.status}}. try loading again
            </div>
          
*/

       $scope.data = {"message" : "vive les photos",
                      "photos" : []};

        // recupération des produits depuis le serveur tomcat
        $http.get(photoUrl)
             .then(function (response) {
                 $scope.data.photos = response.data;
                 $scope.data.columns = [];
                 for (col in $scope.data.photos[0]){
                    if (col != "id")
                        $scope.data.columns.push(col);
                 }
             }, function(response) {
                 $scope.data.error = response.status;
             });

        $scope.selectOrderColumn = function(col) {
            $scope.data.filterColumn = col;
        }
        $scope.getOrderColumnClass = function(col) {
            if (col == $scope.data.filterColumn)
                return orderColumnClass;
            else
                return "";
        }
    });