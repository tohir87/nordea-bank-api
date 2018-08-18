
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Account.:Nordea Bank</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<meta http-equiv="refresh" content="5">-->
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/angular-busy.min.css">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/angular.min.js"></script>
        <script type="text/javascript" src="js/angular-busy.min.js"></script>
        <script src="js/banking.js"></script>
    </head>

    <body>
        <nav class="navbar">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img src="https://vignette.wikia.nocookie.net/logopedia/images/4/44/Nordea_logo.png/revision/latest?cb=20160612064603" alt="" width="" height=""></a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <section>
            <div class="subheader">
                <div class="container">
                    <div class="cent">
                        <h1 class="">Personal Banking Portal</h1>
                    </div>
                </div>
            </div>
        </section>

        <section>
            <div class="row">
                <%@include file="main_menu.html" %>

                <div class="col-md-9">
                    <%@include file="top_menu.html" %>
                    
                    <div class="row">
                        <div class="col-md-6">
                            <div class="box box-bordered">
                                <div class="box-title">
                                    <h4>Open Additional Account</h4>
                                </div>
                                <div class="box-content">
                                    <form method="get" id="new_account_frm" class="form-horizontal" action="api/account/new">
                                        <div class="form-group">
                                            <label for="account_type">Account Type</label>
                                            <br>
                                            <select required id='account_type' name="account_type" class="form-control">
                                                <option value="">Select Account Type</option>
                                                <option value="1">Savings</option>
                                                <option value="2">Current</option>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <input type="button" id='btn_new_Account' class="btn btn-danger" value="Create">
                                            <input type="hidden" id='customer_id' name="customer_id" value="2">
                                            
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5" ng-app='banking' ng-controller="accountCtrl">
                            <h4>Existing Accounts</h4>
                            <table class="table table-stripped table-condensed table-bordered">
                                <thead>
                                    <tr>
                                        <th>Account Type</th>
                                        <th>Account Number</th>
                                        <th>Sort Code</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr ng-repeat="acct in accounts">
                                        <td>{{account_types[acct.accountType]}}</td>
                                        <td>{{acct.accountNo}}</td>
                                        <td>{{acct.sortCode}}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
                    
        <%@include file="footer.html" %>

    </body>
</html>
