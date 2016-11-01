var app = angular.module("xivdashboard", ['gridstack-angular','ngRoute']);

app.controller("bodyCtrl", function($scope, serviceAjax, $log, $compile) {
	var loadContainers = function() {
		serviceAjax.getContent().success(function(data){
			$scope.containers = data;
			//$scope.containers = [{ x:0, y:0, width:1, height:1 }, { x:0, y:0, width:3, height:1 }];
		})		
	}
	$scope.pageChanged = function() {
		loadContainers();
	}
	
	$scope.options = {
            cellHeight: 200,
            verticalMargin: 10,
            resizable: { handles: 'none'}
        };
        $scope.addWidget = function() {
            var newWidget = { x:0, y:0, width:1, height:1 };
            $scope.containers.push(newWidget);
        };
        $scope.removeWidget = function(w) {
            var index = $scope.containers.indexOf(w);
            $scope.containers.splice(index, 1);
        };
        $scope.onChange = function(event, items) {
        	serviceAjax.setContent($scope.containers).success(function(data) {
        	});
            $log.log("onChange event: "+event+" items:"+items);
        };
        $scope.onDragStart = function(event, ui) {
            $log.log("onDragStart event: "+event+" ui:"+ui);
        };
        $scope.onDragStop = function(event, ui) {
            $log.log("onDragStop event: "+event+" ui:"+ui);
        };
        $scope.onResizeStart = function(event, ui) {
            $log.log("onResizeStart event: "+event+" ui:"+ui);
        };
        $scope.onResizeStop = function(event, ui) {
            $log.log("onResizeStop event: "+event+" ui:"+ui);
        };
        $scope.onItemAdded = function(item) {
            $log.log("onItemAdded item: "+item);
        };
        $scope.onItemRemoved = function(item) {
            $log.log("onItemRemoved item: "+item);
        };
	loadContainers();
});

app.factory('serviceAjax', function serviceAjax($http) {
	return{
		getContent: function() {
			return $http.get("http://127.0.0.1:8080/xivdashboard/s/index/content");
		},
		setContent: function(data) {
			return $http.post("http://127.0.0.1:8080/xivdashboard/s/index/content",data);
		}
	}
});

app.directive('widget', function factory() {
	var directiveDefinitionObject = {
	        restrict: 'E',
	        scope: false,
	        link: function(scope, element, attrs) {
	            scope.contentUrl = '../templates/' + $scope + '.html';
	            attrs.$observe("attrs.type",function(v){
	                scope.contentUrl = '../templates/' + v + '.html';
	            });
	        },
	        template: '<div ng-include="contentUrl"></div>',
	        replace: true,
	    };
	    return directiveDefinitionObject; 
})