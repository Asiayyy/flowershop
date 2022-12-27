package com.etc.flowershop.dao.daoImpl;

import com.etc.flowershop.dao.TuserDao;
import com.etc.flowershop.entity.Address;
import com.etc.flowershop.entity.Flower;
import com.etc.flowershop.entity.Torder;
import com.etc.flowershop.entity.Tuser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TuserDaoImpl extends BaseDaoImpl implements TuserDao {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       List<Torder> orders= new TuserDaoImpl().getOrders("hello",null,null);
    }
    //实现登录功能
    @Override
    public Tuser login(String username, String pwd) throws SQLException, ClassNotFoundException {
        //打开数据库
        openDB();
        //使用?表示变量
        String sql = "SELECT * from tuser where username = ? and pwd = ?" ;
        //预编译SQL语句
        ps = con.prepareStatement(sql) ;
        //有占位符就需要处理占位符
        ps.setString(1 , username);
        ps.setString(2 , pwd);
        //执行SQL,实现查询操作调用executeQuery,rs即ResultSet表示结果集
        rs = ps.executeQuery() ;
        Tuser tuser = null ;
        if(rs.next()){
            tuser = new Tuser() ;
            // 从数据库中得到数据存储到tuser对象中
            tuser.setTuserid(rs.getInt("tuserid"));
            tuser.setEmail(rs.getString("email"));
            tuser.setPhone(rs.getString("phone"));
            tuser.setPwd(rs.getString("pwd"));
            tuser.setRole(rs.getInt("role"));
            tuser.setUsername(rs.getString("username"));
        }

        return tuser;
    }
    //显示鲜花
    @Override
    public List<Flower> getAll(int p,int i) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="select *from flower limit ?,?";
        //预编译SQL
        ps=con.prepareStatement(sql);
        //设置当前页面的起始索引
        ps.setInt(1,(p-1)*i);
        //设置每页多少记录
        ps.setInt(2,i);
        //执行SQL
        rs=ps.executeQuery();
        List<Flower>flowers=new ArrayList<>();
        while(rs.next()){
            Flower flower=new Flower();
            flower.setFlowerid(rs.getInt("flowerid"));
            flower.setFlowername(rs.getString("flowername"));
            flower.setPic(rs.getString("pic"));
            flower.setPrice(rs.getInt("price"));
            flower.setCount(rs.getInt("count"));
            flower.setShow(rs.getString("showflower"));
            flower.setType(rs.getString("type"));
            flowers.add(flower);
        }
        return flowers;
    }
    //显示某个鲜花详情
    @Override
    public Flower getOne(int fid) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="select *from flower where flowerid=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,fid);
        rs=ps.executeQuery();
        Flower flower=null;
        if(rs.next()){
            flower=new Flower();
            flower.setFlowerid(rs.getInt("flowerid"));
            flower.setFlowername(rs.getString("flowername"));
            flower.setPic(rs.getString("pic"));
            flower.setPrice(rs.getInt("price"));
            flower.setCount(rs.getInt("count"));
            flower.setShow(rs.getString("showflower"));
            flower.setType(rs.getString("type"));
        }
        return flower;
    }
    //判断购物车是否有此花
    @Override
    public Boolean judge(Tuser tuser, int flowerid) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="select *from shopcar where tuserid= ? and flowerid=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,tuser.getTuserid());
        ps.setInt(2,flowerid);
        rs=ps.executeQuery();
        Boolean flag=false;
        if(rs.next())
            flag=true;
        return flag;
    }
    //添加购物车中
    @Override
    public void addCar(Tuser tuser, int flowerid) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="INSERT into shopcar(tuserid,flowerid)VALUES(?,?)";
        ps=con.prepareStatement(sql);
        ps.setInt(1,tuser.getTuserid());
        ps.setInt(2,flowerid);
        ps.executeUpdate();
    }
    //显示购物车
    @Override
    public List<Flower> showCar(Tuser tuser) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="SELECT s.flowerid,f.flowername,f.pic,f.count,f.price,f.showflower,f.type FROM shopcar s,flower f where s.tuserid=? AND s.flowerid=f.flowerid";
        ps=con.prepareStatement(sql);
        ps.setInt(1,tuser.getTuserid());
        rs=ps.executeQuery();
        List<Flower>flowers=new ArrayList<>();
        while(rs.next()){
            Flower flower=new Flower();
            flower.setFlowerid(rs.getInt("flowerid"));
            flower.setFlowername(rs.getString("flowername"));
            flower.setPic(rs.getString("pic"));
            flower.setPrice(rs.getInt("price"));
            flower.setCount(rs.getInt("count"));
            flower.setShow(rs.getString("showflower"));
            flower.setType(rs.getString("type"));
            flowers.add(flower);
        }
        return flowers;
    }
    //观赏类
    public List<Flower>showtype() throws SQLException, ClassNotFoundException {
        openDB();
        String sql="SELECT *FROM flower where type=\"观赏类\";";
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        List<Flower>flowers=new ArrayList<>();
        while(rs.next()){
            Flower flower=new Flower();
            flower.setFlowerid(rs.getInt("flowerid"));
            flower.setFlowername(rs.getString("flowername"));
            flower.setPic(rs.getString("pic"));
            flower.setPrice(rs.getInt("price"));
            flower.setCount(rs.getInt("count"));
            flower.setShow(rs.getString("showflower"));
            flower.setType(rs.getString("type"));
            flowers.add(flower);
        }
        return flowers;

    }
    //居家类
    @Override
    public List<Flower> hometype() throws SQLException, ClassNotFoundException {
        openDB();
        String sql="SELECT *FROM flower where type=\"居家类\";";
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        List<Flower>flowers=new ArrayList<>();
        while(rs.next()){
            Flower flower=new Flower();
            flower.setFlowerid(rs.getInt("flowerid"));
            flower.setFlowername(rs.getString("flowername"));
            flower.setPic(rs.getString("pic"));
            flower.setPrice(rs.getInt("price"));
            flower.setCount(rs.getInt("count"));
            flower.setShow(rs.getString("showflower"));
            flower.setType(rs.getString("type"));
            flowers.add(flower);
        }
        return flowers;
    }

    @Override
    public List<Flower> environmentaltype() throws SQLException, ClassNotFoundException {
        openDB();
        String sql="SELECT *FROM flower where type=\"环保类\";";
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        List<Flower>flowers=new ArrayList<>();
        while(rs.next()){
            Flower flower=new Flower();
            flower.setFlowerid(rs.getInt("flowerid"));
            flower.setFlowername(rs.getString("flowername"));
            flower.setPic(rs.getString("pic"));
            flower.setPrice(rs.getInt("price"));
            flower.setCount(rs.getInt("count"));
            flower.setShow(rs.getString("showflower"));
            flower.setType(rs.getString("type"));
            flowers.add(flower);
        }
        return flowers;
    }
    //药用类
    @Override
    public List<Flower> medicinetype() throws SQLException, ClassNotFoundException {
        openDB();
        String sql="SELECT *FROM flower where type=\"药用类\";";
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        List<Flower>flowers=new ArrayList<>();
        while(rs.next()){
            Flower flower=new Flower();
            flower.setFlowerid(rs.getInt("flowerid"));
            flower.setFlowername(rs.getString("flowername"));
            flower.setPic(rs.getString("pic"));
            flower.setPrice(rs.getInt("price"));
            flower.setCount(rs.getInt("count"));
            flower.setShow(rs.getString("showflower"));
            flower.setType(rs.getString("type"));
            flowers.add(flower);
        }
        return flowers;
    }
    //花篮类
    @Override
    public List<Flower> baskettype() throws SQLException, ClassNotFoundException {
        openDB();
        String sql="SELECT *FROM flower where type=\"花篮类\";";
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        List<Flower>flowers=new ArrayList<>();
        while(rs.next()){
            Flower flower=new Flower();
            flower.setFlowerid(rs.getInt("flowerid"));
            flower.setFlowername(rs.getString("flowername"));
            flower.setPic(rs.getString("pic"));
            flower.setPrice(rs.getInt("price"));
            flower.setCount(rs.getInt("count"));
            flower.setShow(rs.getString("showflower"));
            flower.setType(rs.getString("type"));
            flowers.add(flower);
        }
        return flowers;
    }
    //修改账户余额
    @Override
    public void updateUser(Tuser tuser, int pay) throws SQLException {
        //因为使用了事务，所以不需要在此打开数据库
        String sql="update tuser set paycount=paycount-? where tuserid=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,pay);
        ps.setInt(2,tuser.getTuserid());
        ps.executeUpdate();
    }
    //修改鲜花数量
    @Override
    public void updateFlower(int i, int count) throws SQLException {
        String sql="update flower set count=count-? where flowerid=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,count);
        ps.setInt(2,i);
        ps.executeUpdate();
    }
    //生成订单
    @Override
    public void addOrder(String orderid, Tuser tuser, int pay) throws SQLException {
        String sql="insert into torder values(?,?,now(),?)";
        ps=con.prepareStatement(sql);
        ps.setString(1,orderid);
        ps.setInt(2,tuser.getTuserid());
        ps.setInt(3,pay);
        ps.executeUpdate();
    }
    //添加鲜花详情
    @Override
    public void addDetail(String orderid, int i, int payone, int count) throws SQLException {
        String sql="insert into detail(torderid,flowerid,payone,onecount) values(?,?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setString(1,orderid);
        ps.setInt(2,i);
        ps.setInt(3,payone);
        ps.setInt(4,count);
        ps.executeUpdate();
    }
    //清空购物车
    @Override
    public void deletCar(Tuser tuser, int i) throws SQLException {
        String sql="delete from shopcar where tuserid=? and flowerid=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,tuser.getTuserid());
        ps.setInt(2,i);
        ps.executeUpdate();
    }
    //计算一共有多少页
    @Override
    public int getTotal(int i) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="select count(*) from flower";
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        int count=0;
        if(rs.next()){
            //1表示第一列数据
            count=rs.getInt(1);
        }
        int page=0;
        if(count%i==0){
            page=count/i;
        }else{
            page=count/i+1;
        }
        return page;
    }

    @Override
    public Address getAddress(int tuserid) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="SELECT *FROM address WHERE tuserid=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,tuserid);
        rs=ps.executeQuery();
        Address address=null;
        if (rs.next()){
            address=new Address();
            address.setAddressid(rs.getInt("adressid"));
            address.setCity(rs.getString("city"));
            address.setCoutry(rs.getString("country"));
            address.setAddress(rs.getString("address"));
        }
        return address;
    }

    @Override
    public Flower getSearch(String flowername) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="SELECT *FROM flower WHERE flowername=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,flowername);
        rs=ps.executeQuery();
        Flower flower=null;
        if(rs.next()){
            flower=new Flower();
            flower.setType(rs.getString("type"));
            flower.setShow(rs.getString("showflower"));
            flower.setPrice(rs.getInt("price"));
            flower.setPic(rs.getString("pic"));
            flower.setFlowername(rs.getString("flowername"));
            flower.setFlowerid(rs.getInt("flowerid"));
            flower.setCount(rs.getInt("count"));
        }
        return flower;
    }
    //多条件查询订单
    @Override
    public List<Torder> getOrders(String name, Date start, Date end) throws SQLException, ClassNotFoundException {
        openDB();
        //多条件查询，即用户可能没有输入任何条件，也可能输入一个或多个条件
        //需要使用Statement的方式来执行sql

        String sql = "select * from torder where 1 = 1 " ;
        if(name != null && !"".equals(name)){
            sql += "  and  tuserid in (select tuserid from tuser where username like '%"+name+"%')" ;
        }
        //在dao层的对象都是java.sql包下的对象，所以需要将java.util包下的对象修改为java.sql包下的对象
        if(start != null){
            sql += " and odate >= '"+new java.sql.Date(start.getTime())+"'" ;
            //new java.sql.Date(start.getTime()) ;
        }
        if (end != null){
            sql += " and odate <= '"+new java.sql.Date(end.getTime())+"'" ;
        }
        //根据连接数据库的对象创建Statement对象
        st = con.createStatement() ;
        //执行SQL
        rs = st.executeQuery(sql) ;
        List<Torder> torders = new ArrayList<>() ;
        while (rs.next()){
            Torder torder = new Torder() ;
            torder.setDate(rs.getDate("odate"));
            torder.setPaysum(rs.getInt("paysum"));
            torder.setOrderid(rs.getString("torderid"));
            Tuser tuser = new Tuser() ;
            tuser.setTuserid(rs.getInt("tuserid"));
            torder.setTuser(tuser);
            torders.add(torder) ;
        }
        return torders;
    }
    //得到用户购物车里的花
    @Override
    public List<Flower> getTuserflower(Tuser tuser) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="SELECT s.flowerid,f.flowername,f.pic,f.count,f.price,f.showflower,f.type FROM shopcar s,flower f where s.tuserid=? AND s.flowerid=f.flowerid";
        ps=con.prepareStatement(sql);
        ps.setInt(1,tuser.getTuserid());
        rs=ps.executeQuery();
        List<Flower>flowers=new ArrayList<>();
        while(rs.next()){
            Flower flower=new Flower();
            flower.setFlowerid(rs.getInt("flowerid"));
            flower.setFlowername(rs.getString("flowername"));
            flower.setPic(rs.getString("pic"));
            flower.setPrice(rs.getInt("price"));
            flower.setCount(rs.getInt("count"));
            flower.setShow(rs.getString("showflower"));
            flower.setType(rs.getString("type"));
            flowers.add(flower);
        }
        return flowers;
    }
    //删除购物车里的花
    public void deletCarone(Tuser tuser, int i) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="delete from shopcar where tuserid=? and flowerid=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,tuser.getTuserid());
        ps.setInt(2,i);
        ps.executeUpdate();
    }
    //添加新用户
    @Override
    public void addUser(String name, String email, String pwd, String number) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="insert into tuser(username,email,pwd,phone) values(?,?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,pwd);
        ps.setString(4,number);
        ps.executeUpdate();
    }

    @Override
    public void UpdateAddress(int id, String address) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="update address set address=? where tuserid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,address);
        ps.setInt(2,id);
        ps.executeUpdate();
    }

    @Override
    public void UpdateCity(int id, String city) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="update address set city=? where tuserid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,city);
        ps.setInt(2,id);
        ps.executeUpdate();
    }

    @Override
    public void UpdateCountry(int id, String country) throws SQLException, ClassNotFoundException {
        openDB();
        String sql="update address set country=? where tuserid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,country);
        ps.setInt(2,id);
        ps.executeUpdate();
    }
}
