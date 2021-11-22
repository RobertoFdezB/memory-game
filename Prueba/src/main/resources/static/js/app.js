var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/juego',{
            templateUrl: 'juego.html',
            controller: 'juegoController'
        })
        .when('/fin',{
            templateUrl: 'ranking.html',
            controller: 'rankingController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

