/**
 * Created by enHui.Chen on 2017/9/19.
 */
/* 模块和路由定义 */
var actionApp = angular.module('actionApp', ['ngRoute']);// 定义actionApp模块,依赖于ngRoute路由
actionApp.config(['$routeProvider','$locationProvider', function ($routeProvider,$locationProvider) { // 配置路由,注入$routeProvider
    // 1.6版本以后，需要通过该方法来解决路由地址栏问题
    $locationProvider.hashPrefix('');

    $routeProvider.when('/oper', {// 路由名称
        controller: 'View1Controller',// 定义路由控制器名称
        templateUrl: 'views/view1.html'// 定义视图真实位置
    }).when('/directive', {
        controller: 'View2Controller',// 定义路由器控制名称
        templateUrl: 'views/view2.html'// 定义视图真实位置
    });
}]);
