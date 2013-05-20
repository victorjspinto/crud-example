angular.module("crudexample",[]).config(function($routeProvider) {
	$routeProvider
		.when('/employee', { controller : EmployeeListCtrl, templateUrl : 'view/employee-list.html' })
		.when('/employee/new', { controller : EmployeeNewCtrl, templateUrl : 'view/employee-detail.html' })
		.when('/department', { controller : DepartmentListCtrl, templateUrl : 'view/department-list.html' })
		
		.otherwise({ redirectTo : '/' });
});


function EmployeeListCtrl($scope)
{
	$scope.employees;
}

function EmployeeNewCtrl($scope, $location)
{
	var self = this;
	
	
	
	$scope.save = function(){
		$location.path("/employee");
	}
	
	$scope.isClean = function(){
		angular.equals(self.original, $scope.employee);
	}
}

function EmployeeEdit($scope, $location, $routeParams)
{
	
}

function DepartmentListCtrl($scope)
{
	$scope.departments;
}
