/**
 * Created by enHui.Chen on 2017/9/19.
 */
/* 自定义指令 */
actionApp.directive('datePicker',function () {// 定义指令名称
   return{
       restrict: "AC",// 定义指令作用范围
       link:function (scope,elem,attrs) {// 定义指令行为
           elem.datepicker();// 渲染日期
       }
   }
});
