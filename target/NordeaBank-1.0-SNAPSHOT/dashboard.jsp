

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>My Internet Banking</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<meta http-equiv="refresh" content="5">-->
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="js/switchForm.js"></script>
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
                   
                    <div class="row-fluid">
                        <div class="col-md-6">
                            <div class="box box-bordered">
                                <div class="box-title">
                                    <h4>Recent Transaction</h4>
                                </div>
                                <div class="box-content">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Date</th>
                                                <th>Type</th>
                                                <th>Description</th>
                                                <th>Amount(EUR)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>12/08/2018</td>
                                                <td>Debit</td>
                                                <td>House Rent</td>
                                                <td>300</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <div class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-xs-12">
                        <p style="text-align: center">&copy; 2018 NCIR Project | Developed by Paul, Killian, Borja. All Rights Reserved.</p>
                    </div>

                </div>
            </div>

        </div>


    </body>
</html>
