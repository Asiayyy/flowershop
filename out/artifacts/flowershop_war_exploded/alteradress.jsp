<%--
  Created by IntelliJ IDEA.
  User: 30862
  Date: 2022/8/22
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: 30862
  Date: 2022/8/19
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Floral Shop, Check Out, Web Store</title>
    <meta name="keywords" content="free template, floral shop, ecommerce, online shopping, store" />
    <meta name="description" content="Floral Shop, Check Out, free template for ecommerce websites." />
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
            <div id="site_title"><a href="#" title=""></a></div>
            <div id="templatemo_menu" class="ddsmoothmenu">
                <ul>
                    <li><a href="main.jsp">主页</a></li>
                    <li><a href="login.jsp">登录注册</a></li>
                    <li><a href="products.jsp">产品</a></li>
                    <li><a href="checkout.jsp" class="selected">结账</a></li>
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
            <a href="#" title=""  class="site_repeat" target="_blank"><img src="images/top_repeat.png" title=""  /></a><!-- end of templatemo_menu -->

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
                            <li><a href="/DecorateTypeServlet">花篮装饰</a></li>
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

                <h2>修改地址</h2>
            <div class="register w3layouts agileits">
                <form action="/AlterAddress" method="post">
                    <p>地址</p>
                    <input type="text" Name="address" placeholder="修改地址" required=""maxlength="40" />
                     <p>城市</p>
                    <input type="text" Name="city" placeholder="修改城市" required=""maxlength="40" />
                    <p>国家</p>
                    <input type="text" Name="country" placeholder="修改国家" required=""maxlength="40" />
                    <p>点击修改</p>
                    <input type="submit"  value="确认修改">
                </form>
                    </div>

                    <div class="cleaner h40"></div>

                    <h3>购物卡</h3>
                    <h4>共计: <strong>$${sum}</strong></h4>
                    <p><input name="terms" type="checkbox" id="terms" />
                        我已经阅读并接受了<a href="#">使用条款</a></p>
                    <input type="submit" value="确认支付"/>
                    <a href="#"><img src="images/free_shipping.jpg" alt="Free Shipping" /></a>
            </div>
        </div>
        </form>
        <div class="cleaner"></div>
    </div> <!-- END of main -->
</div> <!-- END of main wrapper -->


</div>

</body>
<script type='text/javascript' src='js/logging.js'></script>
</html>

