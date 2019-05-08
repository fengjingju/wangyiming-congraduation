<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> 微博原文展示 </title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body>
<div style="float: left;height: 100%;background-color: #1c2b36;width: 18%">
    <%@ include file="/jsp/index.jsp" %>
</div>

<div class="wrapper wrapper-content animated fadeInRight" style="float: left;width: 82%">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>微博原文展示
                    </h5>
                </div>
                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>用户</th>
                            <th>标题</th>
                            <th>内容</th>
                            <th>评论数量</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${weiboList }" var="weibo">
                            <tr class="gradeC">
                                <td style="width: 15%">${weibo.sender}</td>
                                <td style="width: 17%">
                                    <c:choose>
                                        <c:when test="${empty weibo.title}">
                                            无
                                        </c:when>
                                        <c:otherwise>
                                            ${weibo.title}
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td style="width: 60%">
                                    <c:choose>
                                        <c:when test="${empty weibo.content}">
                                            无
                                        </c:when>
                                        <c:otherwise>
                                            ${weibo.content}
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td style="width: 8%">${weibo.commentNum}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>


<script src="js/plugins/jeditable/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- 自定义js -->



<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {
        $('.dataTables-example').dataTable();

        /* Init DataTables */
        var oTable = $('#editable').dataTable();

        /* Apply the jEditable handlers to the table */
        oTable.$('td').editable('../example_ajax.php', {
            "callback": function (sValue, y) {
                var aPos = oTable.fnGetPosition(this);
                oTable.fnUpdate(sValue, aPos[0], aPos[1]);
            },
            "submitdata": function (value, settings) {
                return {
                    "row_id": this.parentNode.getAttribute('id'),
                    "column": oTable.fnGetPosition(this)[2]
                };
            },

            "width": "90%",
            "height": "100%"
        });


    });

    function fnClickAddRow() {
        $('#editable').dataTable().fnAddData([
            "Custom row",
            "New row",
            "New row",
            "New row",
            "New row"]);

    }
</script>


</body>

</html>
