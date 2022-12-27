
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Floral Shop, Ecommerce, Online Shopping, Web Store</title>
    <meta name="keywords" content="free template, floral shop, ecommerce, online shopping, store" />
    <meta name="description" content="Floral Shop is free website template for ecommerce or online shopping websites. Products, Shopping Cart, FAQs and Checkout pages are included." />
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

    <link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen" />
    <script type="text/JavaScript" src="js/slimbox2.js"></script>


</head>

<body>

<div id="templatemo_wrapper_h">
    <div id="templatemo_header_wh">
        <div id="templatemo_header" class="header_home">
            <div id="site_title"><a href="" title=""></a></div>
            <div id="templatemo_menu" class="ddsmoothmenu">
                <ul>
                    <li><a href="main.jsp">主页</a></li>
                    <li><a href="login.jsp">登录注册</a></li>
                    <li><a href="products.jsp">产品</a></li>
                    <li><a href="checkout.jsp">结账</a></li>
                    <li><a href="contact.jsp">关于我们</a></li>
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
            <a href="#" title="visit "  class="site_repeat" target="_blank"><img src="images/top_repeat.png"  alt="visit " /></a><!-- end of templatemo_menu -->

            <div class="slider-wrapper theme-orman">
                <div class="ribbon"></div>
                <div id="slider" class="nivoSlider">
                    <img src="images/portfolio/01.jpg" alt="slider image 1" />
                    <img src="images/portfolio/02.jpg" alt="slider image 2" />
                    <img src="images/portfolio/03.jpg" alt="slider image 3" />
                    <img src="images/portfolio/04.jpg" alt="slider image 4"  />
                    <img src="images/portfolio/05.jpg" alt="slider image 5"  />
                </div>

            </div>
            <script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
            <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
            <script type="text/javascript">
                $(window).load(function() {
                    $('#slider').nivoSlider({
                        controlNav:false
                    });
                });
            </script>
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
                    <h3>本周特价</h3>
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
                <h2>欢迎来到花店</h2>
                <p>这花可太漂亮了</p>

                <div class="product_box">
                    <a href="/GetOneServlet?fid=2"><img src="images/product/观赏类/月季花.jpg" alt="鲜花图片" style="width: 150px;height: 150px" /></a>
                    <h3>月季花</h3>
                    <p class="product_price">$30</p>
                    <p class="add_to_cart">
                        <a href="/GetOneServlet?fid=2">这是观赏类</a>
                        <a href="/GetOneServlet?fid=2">添加至购物车</a>
                    </p>
                </div>


            </div>
            <div class="blank_box">
                <a href="#"><img src="images/free_shipping.jpg" alt="Free Shipping" /></a>
            </div>
        </div>
        <div class="cleaner"></div>

    </div> <!-- END of main -->
</div> <!-- END of main wrapper -->


</div>

</body>
<script type='text/javascript' src='js/logging.js'></script>
</html>


