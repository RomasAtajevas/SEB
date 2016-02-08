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
                $(".save-button").on("click", function () {
                    var input = $(this).siblings("input");
                    var value = input.val().trim().replace(",", ".");
                    
                    if (!value) {
                        alert("Value can't be empty...");
                    } else if (!$.isNumeric(value)) {
                        alert("Value must be a number...");
                    } else {
                        $.ajax({
                            url: "${rca.contextPath}/updateRate?currency=" + input.attr("id") + "&value=" + value,
                            type: "POST",
                            contentType: "application/javascript",
                            success: function (data) {
                                alert("Value updated...");
                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                alert("Update failed...");
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
                <a href="${rca.contextPath}/chart">Chart</a>
            </div>
            <form id="filter-form" class="form-inline" action="${rca.contextPath}/secondPage" method="get">
                <label>Currency:</label>
                <#if currency??>
                    <input type="text" name="currency" value="${currency}" />
                <#else>
                    <input type="text" name="currency" />
                </#if>
                <button type="submit" class="btn btn-default">Find</button>
            </form>
            <table class="table table-hover table-bordered">
                <tr>
                    <th>Date</th>
                    <th>Currency</th>
                    <th>Quantity</th>
                    <th>Rate</th>
                    <th>Unit</th>
                </tr>
                <#list items as item>
                    <tr>
                        <td class="center-aligned">${item.date}</td>
                        <td class="center-aligned">${item.currency}</td>
                        <td class="right-aligned">${item.quantity}</td>
                        <td class="right-aligned">
                            <input type="text" style="width: 60px;" id="${item.currency}" value="${item.rate?string['0.0000']}" class="right-aligned" />
                            <input type="image" src="http://icons.primail.ch/save.gif" class="save-button" />
                        </td>
                        <td>${item.unit}</td>
                    </tr>
                </#list>
            </table>
        </div>
    </body>
</html>
