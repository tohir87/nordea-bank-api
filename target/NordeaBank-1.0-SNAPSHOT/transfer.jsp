
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Transfer.:Nordea Bank</title>
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
                        <h1 class="">Fund Transfer</h1>
                    </div>
                </div>
            </div>
        </section>

        <section>
            <div class="row">
                <%@include file="main_menu.html" %>

                <div class="col-md-9">
                    <%@include file="top_menu.html" %>
                    
                    <div class="row" ng-app='banking' ng-controller="transferCtrl">
                        <div class="col-md-5">
                            <div class="box box-bordered">
                                <div class="box-title">
                                    <h4>Fund Transfer</h4>
                                </div>
                                <div class="box-content">
                                    <form method="get" id="new_account_frm" class="form-horizontal">
                                        <div class="form-group">
                                            <label for="account_type">Amount</label>
                                            <br>
                                            <input type="text" id="amount" name="amount" placeholder="500" />
                                        </div>
                                        <div class="form-group">
                                            <label for="account_type">Recipient</label>
                                            <br>
                                            <select required id='account_type' name="account_type" class="form-control">
                                                <option value="">Select Recipient</option>
                                                <option ng-repeat="acct in accounts" value="{{acct.accountNo}}">{{acct.accountNo}}</option>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <button type="button" id='btn_transfer' class="btn btn-danger" value="Create">Transfer</button>
                                            <input type="hidden" id='customer_id' name="customer_id" value="2">
                                            
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h4>Recent Transactions</h4>
                            <table class="table table-stripped table-condensed table-bordered">
                                <thead>
                                    <tr>
                                        <th>Date</th>
                                        <th>Transaction Type</th>
                                        <th>Amount</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr ng-repeat="trans in transactions">
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
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
