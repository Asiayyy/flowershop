<%--
  Created by IntelliJ IDEA.
  User: 30862
  Date: 2022/8/22
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Floral Shop, Contact, Online Store</title>
    <meta name="keywords" content="free template, contact, floral shop, ecommerce, online store" />
    <meta name="description" content="Floral Shop, Contact Form, Location Maps, Addresses, free template for ecommerce websites." />
    <link href="templatemo_style.css" rel="stylesheet" type="text/css" />

    <link rel="stylesheet" href="css/orman.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />

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
        function judge(name) {
            if(name=="hello")
                return true
            else {
                alert("您没有权限")
                return false
            }
        }

    </script>


</head>

<body>

<div id="templatemo_wrapper_sp">
    <div id="templatemo_header_wsp">
        <div id="templatemo_header" class="header_subpage">
            <div id="site_title"><a href="" title=""></a></div>
            <div id="templatemo_menu" class="ddsmoothmenu">
                <ul>
                    <li><a href="main.jsp">主页</a></li>
                    <li><a href="login.jsp">登录注册</a></li>
                    <li><a href="products.jsp">产品</a></li>
                    <li><a href="checkout.jsp">结账</a></li>
                    <li><a href="contact.jsp" class="selected">关于我们</a></li>
                    <li><a href="faqs.jsp">常见问题</a></li>
                    <li><a href="back.jsp" onclick=" return judge(${tuser.username})">后台管理系统</a> </li>
                </ul>
                <div id="templatemo_search">
                    <form action="/SearchServlet" method="get">
                        <input type="text" value="查找" name="keyword" id="keyword" title="keyword"
                               onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
                        <input type="submit" name="Search" value="" alt="Search" id="searchbutton" title="Search" class="sub_btn" />
                    </form>
                </div>
                <br style="clear: left" />
            </div>
            <a href="#" title="#/"  class="site_repeat" target="_blank"><img src="images/top_repeat.png" title="#/"  /></a><!-- end of templatemo_menu -->

        </div> <!-- END of header -->
    </div> <!-- END of header wrapper -->
    <div id="templatemo_main_wrapper">
        <div id="templatemo_main">
            <div id="sidebar" class="left">
                <div class="sidebar_box"><span class="bottom"></span>
                    <h3>种类</h3>
                    <div class="content">
                        <ul class="sidebar_list">
                            <li><a href="/ShowTypeServlet">观赏类</a></li>
                            <li><a href="/HomeTypeServlet">居家类</a></li>
                            <li><a href="/EnvironmentalTypeServlet">环保类</a></li>
                            <li><a href="/MedicineTypeServlet">药用类</a></li>
                            <li><a href="/BasketServlet">花篮装饰</a></li>
                        </ul>
                    </div>
                </div>
                <div class="sidebar_box"><span class="bottom"></span>
                    <h3>每周特价</h3>
                    <div class="content special">
                        <img src="images/product/观赏类/月季花.jpg" alt="Flowers" style="width: 220px;height: 220px"/>
                        <a href="discount.jsp">特价月季花</a>
                        <p>
                            Price:
                            <span class="price normal_price">$50</span>&nbsp;&nbsp;
                            <span class="price special_price">$30</span>
                        </p>
                    </div>
                </div>
            </div>

            <div id="content" class="right">
                <h2>关于我们</h2>
                <p>公司环境好的一批
                </p>
                <div class="cleaner h20"></div>
                <div class="col col13">
                    <h4>公司地址</h4>
                    <h6><strong>一号办公室</strong></h6>
                    800-220  <br />
                    邮编, *****<br />
                    <br /><br />

                    <strong>电话:</strong> ***-***-****<br />
                    <strong>电子邮件:</strong> <a href="">******@******.com</a> <br />

                    <div class="cleaner h20"></div>

                    <h6><strong>二号办公室</strong></h6>
                    600-110 <br />
                    邮编, *****<br />
                    <br /><br />

                    <strong>电话:</strong> ***-***-****<br />
                    <strong>电子邮件:</strong> <a href="">****@*******.com</a> <br />


                </div>
                <div class="col col23 no_margin_right">
                    <div class="map_border">
                        <iframe width="430" height="340" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Central+Park,+New+York,+NY,+USA&amp;aq=0&amp;sll=14.093957,1.318359&amp;sspn=69.699334,135.263672&amp;vpsrc=6&amp;ie=UTF8&amp;hq=Central+Park,+New+York,+NY,+USA&amp;ll=40.778265,-73.96988&amp;spn=0.033797,0.06403&amp;t=m&amp;output=embed"></iframe></div>

                </div>
                <div class="cleaner h40"></div>

                <div class="cleaner h40"></div>
                <div class="blank_box">
                    <a href="#"><img src="images/free_shipping.jpg" alt="Free Shipping" /></a>
                </div>
                <div class="cleaner"></div>
            </div>
            <div class="cleaner"></div>
        </div> <!-- END of main -->
    </div> <!-- END of main wrapper -->


</div>

</body>
<script type='text/javascript' src='js/logging.js'></script>
</html>
