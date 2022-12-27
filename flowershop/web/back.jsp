<%--
  Created by IntelliJ IDEA.
  User: 30862
  Date: 2022/8/21
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Floral Shop, Ecommerce, Online Shopping, Web Store</title>
    <meta name="keywords" content="free template, floral shop, ecommerce, online shopping, store" />
    <meta name="description" content="Floral Shop is free website template for ecommerce or online shopping websites. Products, Shopping Cart, FAQs and Checkout pages are included." />
    <link href="templatemo_style.css" rel="stylesheet" type="text/css" />

    <link rel="stylesheet" href="css/orman.css" type="text/css" media="screen" />


    <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/ddsmoothmenu.js">

        /***********************************************
         * Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
         * This notice MUST stay intact for legal use
         * Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
         ***********************************************/

    </script>

    <script type="text/javascript">

        ddsmoothmenu.init({
            mainmenuid: "templatemo_menu", //menu DIV id
            orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
            classname: 'ddsmoothmenu', //class added to menu's outer DIV
            //customtheme: ["#1c5a80", "#18374a"],
            contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
        })

        function clearText(field)
        {
            if (field.defaultValue == field.value) field.value = '';
            else if (field.value == '') field.value = field.defaultValue;
        }

    </script>

    <link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen" />
    <script type="text/JavaScript" src="js/slimbox2.js"></script>


</head>

<body>

<div >
    <div  >
        <div >
            <div id="site_title"><a href="" title=""></a></div>

            <div style="height: 50px"></div>
            <div align="center">
                <h1 style="align-items: center">天天花店后台系统</h1>
            </div>
            <div style="height: 80px">
            </div>
            <div align="center">
                <!-- 多条件查询订单-->
                <form action="getMore" method="post">
                    <table border="1">
                        <tr>
                            <td>用户名<input type = "text" name="uname"/></td>
                            <td>起始日期<input type="date" name="startdate" /></td>
                            <td>结束日期<input type = "date" name="enddate"/></td>
                            <td><input type = "submit" value="开始查询"/></td>
                        </tr>
                    </table>
                </form>
                <table border="1">
                    <tr>
                        <td>用户ID</td>
                        <td>订单编号</td>
                        <td>订单日期</td>
                        <td>支付总额</td>
                    </tr>
                    <c:forEach items="${orders}" var="o">
                        <tr>
                            <td> ${o.tuser.tuserid}</td>
                            <td>${o.orderid}</td>
                            <td>${o.date}</td>
                            <td>${o.paysum}</td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="main.jsp">退出后台管理系统</a>
            </div>

            <script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
            <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>

        </div> <!-- END of header -->
    </div> <!-- END of header wrapper -->

</div> <!-- END of main wrapper
-->

</div>

</body>
<script type='text/javascript' src='js/logging.js'></script>
</html>