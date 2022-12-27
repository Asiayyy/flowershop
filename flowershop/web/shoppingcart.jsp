
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Floral Shop, Shopping Cart, Online Store</title>
    <meta name="keywords" content="free template, shopping cart, floral, ecommerce, online, store" />
    <meta name="description" content="Floral, Shopping Cart, free template for ecommerce websites." />
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
        //判断提交
        function checkNull(){
            //获取到所有的复选框控件
            var ones =  document.getElementsByName("one")
            var count = 0 ;
            for (var i = 0; i < ones.length; i++) {
                if(ones[i].checked)
                    count++
            }
            if(count == 0) {
                alert("请至少选择一个鲜花")
                return false
            }else
                return true
        }
        //实现数量添加功能
        function jia(fid){
            //alert("jia")
            //获取当前鲜花的数量控件
            var c  = document.getElementById("quantity1"+fid) ;
            //获取到库存控件
            var kuncun =   document.getElementById("count" + fid)
            //获取总价控件
            var sumone =   document.getElementById("sum" + fid) ;
            //获取到单价控件
            var price =  document.getElementById("price" + fid)
            //修改数量控件的值的数据类型为数字类型
            var count = parseInt(c.value) ;
            //如果当前数量小于库存的时候，可以自增
            if(count < kuncun.value )
                //点击一次自加一次
                count++ ;
            else
                //如果数量=库存，或者>库存的时候，数量值即为库存值
                count = kuncun.value
            //修改数量控件的值
            c.value = count ;
            //修改总价
            sumone.value = count * parseInt(price.value)
        }
        //实现减少功能
        function jian(fid) {
            //获取当前鲜花的数量操作
            var c=document.getElementById("quantity1"+fid)
            //获取到库存控件
            var kuncun=document.getElementById("count"+fid)
            //获取总价控件
            var sumone=document.getElementById("sum"+fid)
            //获取单价控件
            var price=document.getElementById("price"+fid)

            //修改数量控件的值的数据类型为数字类型
            var count=parseInt(c.value)
            //如果当前数量大于0的时候，可以自减
            if(count>0)
                count--
            else
                //如果当前数量为0，数量值就为0
                count=0
            //修改数量控件的值
            c.value = count
            //修改总价
            sumone.value=count*parseInt(price.value)
        }

        //实现全选功能
        function checkAll(){
            //获取到全选控件,根据控件id值得到控件
            var all = document.getElementById("all")
            //获取到所有可以选中的复选框
            var ones =  document.getElementsByName("one")
            for(var i = 0 ; i < ones.length ; i++){
                //将所有复选框的状态与全选的状态保持一致
                ones[i].checked = all.checked ;
            }
        }
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
                    <li><a href="products.jsp" class="selected">产品</a></li>
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
            <a href="#" title="免费的图像"  class="site_repeat" ><img src="images/top_repeat.png" title="免费的图像"  /></a><!-- end of templatemo_menu -->

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
                <h2>购物车</h2>
                <form action="checkout" method="post" onsubmit="return checkNull()">
                    <table width="700" border="0" cellpadding="5" cellspacing="0">
                        <tr bgcolor="#395015">
                            <th width="168" align="center"> <input type="checkbox" onclick="checkAll()" id = "all"/>全选</th>
                            <th width="168" align="center">鲜花图片</th>
                            <th width="188" align="left">鲜花名称</th>
                            <th width="60" align="center">购买数量</th>
                            <th width="80" align="right">单价</th>
                            <th width="80" align="right">总计</th>
                            <th width="64"> </th>
                        </tr>
                        <c:forEach items="${flowers}" var="flower">
                            <input type="hidden" name="count" id="count${flower.flowerid}"
                                   value = "${flower.count}"/>
                            <tr bgcolor="#41581B">
                                <td align="center"><input type = "checkbox" name = "one" value = "${flower.flowerid}"/></td>
                                <td><img src="${flower.pic}" alt="flower image 1" style="width: 200px;height: 180px"/></td>
                                <td>${flower.flowername}</td>
                                <td align="center">
                                    <input type = "button" value = "+" onclick="jia(${flower.flowerid})"/>
                                    <input type="text" id="quantity1${flower.flowerid}" name="quantity1${flower.flowerid}"value="1" size="3" maxlength="3" />
                                    <input type="button" value="-"onclick="jian(${flower.flowerid})"/></td></td>
                                <td align="right">$<input type = "text" value = "${flower.price}"
                                                          id="price${flower.flowerid}"size="3" maxlength="5" readonly/></td>
                                <td align="right">$<input type = "text"   id = "sum${flower.flowerid}" name="sum${flower.flowerid}"
                                                          value ="${flower.price}" size="3" maxlength="5" readonly/></td>
                                <td align="center"> <a href="/DeleteCarServlet?deletefid=${flower.flowerid}"><img src="images/remove.png" alt="remove" /><br />Remove</a> </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="cleaner h20"></div>

                    <div class="right"><input type = "submit" value="确认提交"/> </div>
                    <div class="cleaner h20"></div>
                    <div class="blank_box">
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
