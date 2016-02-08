<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>First Page</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/css/bootstrap-datepicker.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/css/bootstrap-datepicker3.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/js/bootstrap-datepicker.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/locales/bootstrap-datepicker.lt.min.js"></script>
        <style>
            .right-aligned {
                text-align: right;
            }
            .left-aligned {
                text-align: left;
            }
            .center-aligned {
                text-align: center;
            }
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
        </style>
        <script>
            $(document).ready(function () {
                $(".date-picker").datepicker({
                    format: "yyyy-mm-dd",
                    language: "lt",
                    endDate: "2014-12-31"
                });
            });
        </script>
    </head>
    <body>
        <div id="container">
            <div class="center-aligned">
                <a href="${rca.contextPath}/secondPage">Second Page</a>
                <span> | </span>
                <a href="${rca.contextPath}/chart">Chart</a>
            </div>
            <form id="filter-form" class="form-inline" action="${rca.contextPath}/firstPage" method="get">
                <label>Date:</label>
                <input data-provide="datepicker" class="form-control date-picker" name="date" value="${date}">
                <button type="submit" class="btn btn-default">Filter</button>
            </form>
            <table class="table table-hover table-bordered">
                <tr>
                    <th>Currency</th>
                    <th>Previous Rate</th>
                    <th>Current Rate</th>
                    <th>Increase/Decrease</th>
                </tr>
                <#list differences as difference>
                    <tr>
                        <td class="center-aligned">${difference.currency}</td>
                        <td class="right-aligned">${difference.prevRate?string["0.0000"]}</td>
                        <td class="right-aligned">${difference.curRate?string["0.0000"]}</td>
                        <td class="right-aligned">${difference.difference?string["0.00"]}%</td>
                    </tr>
                </#list>
            </table>
        </div>
    </body>
</html>
