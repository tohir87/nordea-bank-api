var bankingApp = angular.module('banking', []);

bankingApp.controller('accountCtrl', function ($scope, $http) {


    $scope.blank = {};
    $scope.accounts = [];
    $scope.account_types = {1 : 'Savings', 2 : 'Current'};

    var getSiteUrl = function () {
        return window.location.protocol + '//' + window.location.host + '/';
    };

    $scope.fetchAccounts = function () {

        $scope.myPromise = $http.get(getSiteUrl() + 'api/account/all')
                .success(function (response) {
                    console.log(response);
                    $scope.accounts = response;
                }).error(function (response) {
            console.log("Unable to load customers accounts");
        });
    };

    $scope.fetchAccounts();


});

bankingApp.controller('transferCtrl', function ($scope, $http) {


    $scope.blank = {};
    $scope.accounts = [];
    $scope.transaction_types = {1 : 'Credit', 2 : 'Debit'};

    var getSiteUrl = function () {
        return window.location.protocol + '//' + window.location.host + '/';
    };

    $scope.fetchAccounts = function () {

        $scope.myPromise = $http.get(getSiteUrl() + 'api/account/all')
                .success(function (response) {
                    console.log(response);
                    $scope.accounts = response;
                }).error(function (response) {
            console.log("Unable to load customers accounts");
        });
    };

    $scope.fetchAccounts();


});

// jquery scripts
function showRegistrationForm() {
    $("#login_frm_div").hide();
    $("#signup_frm_div").show();

}

function showLogInForm() {
    $("#signup_frm_div").hide();
    $("#login_frm_div").show();

}

$(document).ready(function () {
    $("#currentDate").text(Date());

    $("#btn_new_Account").click(function () {
        var account_type_ = $("#account_type").val();
        var customer_id_ = $("#customer_id").val();
        
        console.log(account_type_, customer_id_);
        
        $.ajax({
            url: 'http://localhost:49000/api/account/new',
            data: {
                'account_type' : account_type_,
                'customer_id' : customer_id_,
            },
            success: function(e){
                alert("Account added successfully" +  e);
            },
            error: function(e){
                alert("Account added successfully");
            },
//            dataType: dataType
        });
        location.reload();
    });
    
    $("#btn_signup").click(function(){
        //api/customers/new
        
        // check if both password match
        var pass = $("#password").val();
        var pass2 = $("#password2").val();
        if (pass !== pass2) {
            alert("Passwords do not match, please ensure both passwords match");
            return false;
        }
        formData = $("#signup_frm").serializeArray();
        console.log(formData);
         $.ajax({
            url: 'http://localhost:49000/api/customers/new',
            data: formData,
            success: function(e){
                alert("Registration Completed successfully");
                self.location = 'http://localhost:49000/dashboard.jsp';
            },
            error: function(e){
                console.log(e);
                alert("Registration Completed successfully, you can now proceed to Internet banking");
                self.location = 'http://localhost:49000/dashboard.jsp';
            }
        });
        
    });
});