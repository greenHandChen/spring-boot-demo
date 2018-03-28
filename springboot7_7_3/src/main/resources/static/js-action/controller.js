/**
 * Created by enHui.Chen on 2017/9/19.
 */
/* 控制器定义 */
actionApp.controller('View1Controller', ['$rootScope', '$scope', '$http',//注入这三个参数
    function ($rootScope, $scope, $http) {
        $scope.person = {
            name:"5",
            age:15,
            address:"ss"
        };
        $scope.$on('$viewContentLoaded', function () { // 监听$viewContentLoaded事件，当页面完成加载时触发
            console.log('页面加载完成');
        });
        $scope.search = function () {// 定义方法
            personName = $scope.personName;//获取对应的ng-model的值
            $http.get('search', {// 向服务器发送请求，请求路径为search
                params: {personName: personName}// 发送的数据
            }).then(function (data) {// 回调
                $scope.person = data.data;
                // 强制刷新$scope的数据模型
                $scope.$digest();
            });
        };
    }]);

actionApp.controller('View2Controller', ['$rootScope', '$scope',//注入这三个参数
    function ($rootScope, $scope) {
    }]);