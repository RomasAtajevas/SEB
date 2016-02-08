<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Chart</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/css/bootstrap-datepicker.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/css/bootstrap-datepicker3.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/locale/lt.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.0.0-beta/Chart.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/js/bootstrap-datepicker.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/locales/bootstrap-datepicker.lt.min.js"></script>
        <style>
            #container {
                margin: 0 auto;
                width: fit-content;
            }
            #filter-form {
                padding-bottom: 5px;
            }
            body {
                padding: 15px;
            }
            .center-aligned {
                text-align: center;
            }
        </style>
        <script>
            $(document).ready(function () {
                $(".date-picker").datepicker({
                    format: "yyyy-mm-dd",
                    language: "lt",
                    endDate: "2014-12-31"
                });
                
                var chart;
                
                $("button").on("click", function () {
                    var currency = $("#currency option:selected").text();
                    var from = $("#from").val();
                    var to = $("#to").val();
                        
                    if (!currency || !from || !to) {
                        alert("Currency and both dates must be selected...");
                    } else {
                        $.ajax({
                            url: "${rca.contextPath}/chart/data?currency=" + currency + "&from=" + from + "&to=" + to,
                            type: "GET",
                            contentType: "application/javascript",
                            success: function (data) {
                                if (chart !== undefined) {
                                    chart.destroy();
                                }

                                chart = new Chart($("#my-chart"), {
                                    type: "line",
                                    data: data
                                });
                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                alert("There was an exception loading currencies...");
                            }
                        });
                    }
                });
            });
        </script>
    </head>
    <body>
        <div id="container">
            <div class="center-aligned">
                <a href="${rca.contextPath}/firstPage">First Page</a>
                <span> | </span>
                <a href="${rca.contextPath}/secondPage">Second Page</a>
            </div>
            <div class="form-inline">
                <label>Currency:</label>
                <select class="form-control" id="currency">
                    <#if currencies??>
                        <#list currencies.items as item>
                            <option>${item.currency}</option>
                        </#list>
                    </#if>
                </select>
                <label>From:</label>
                <input data-provide="datepicker" id="from" class="form-control date-picker">
                <label>To:</label>
                <input data-provide="datepicker" id="to" class="form-control date-picker">
                <button type="submit" class="btn btn-default">Show</button>
            </div>
            <canvas id="my-chart" width="500" height="500"></canvas>
        </div>
    </body>
</html>
