package Java;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL {
    public static class HandleSql { //创建 HandleSql 类

        static Connection con = null; //声明 Connection 对象
        static PreparedStatement pStmt;//声明预处理 PreparedStatement 对象
        static ResultSet res;//声明结果 ResultSet 对象
        static String driver = "com.mysql.cj.jdbc.Driver";
        static String url = "jdbc:mysql://45.32.250.195/work";
        static String user = "ls";
        static String password = "12345678";

        public Connection getConnection() {//建立返回值为 Connection 的方法

            //代码块（1）：加载数据库驱动类
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("数据库驱动加载成功");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //代码块（2）：通过访问数据库的URL获取数据库连接对象
            try {
                con = DriverManager.getConnection(url, user, password);
                System.out.println("数据库连接成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return con;
        }

        public static void main(String[] args) {//主方法
            HandleSql h = new HandleSql();//创建本类对象
            con = h.getConnection();//与数据库建立连接


        }

    }
    public int save(Students student) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into students values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getStudentName());
            ps.setString(3, student.getSex());
            ps.setString(4, student.getPhoneNo());
            ps.setString(5, student.getAddress());
            ps.setDate(6, (Date) student.getBirthday());
            int row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, ps, null);
        }
        return 0;
    }
　　　　　　//删除
    @Override
    public int delete(int studentId) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from students where studentId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            int row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, ps, null);
        }
        return 0;
    }
　　　　//更新
    @Override
    public int update(int studentId, Students student) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update students set studentName=?,sex=?,phoneNo=?,address=?,birthday=? where studentId=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getSex());
            ps.setString(3, student.getPhoneNo());
            ps.setString(4, student.getAddress());
            ps.setDate(5, ((Date) student.getBirthday()));
            ps.setInt(6, studentId);
            int row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, ps, null);
        }
        return 0;
    }
　　　　　　//查找一条数据
    @Override
    public Students getByStudentId(int studentId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from students where studentId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            rs = ps.executeQuery();
            if(rs.next()) {
                Students student = new Students();
                student.setStudentId(rs.getInt("studentId"));
                student.setStudentName(rs.getString("studentName"));
                student.setSex(rs.getString("sex"));
                student.setPhoneNo(rs.getString("phoneNo"));
                student.setAddress(rs.getString("address"));
                student.setBirthday(rs.getDate("birthday"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, ps, rs);
        }
        return null;
    }
　　　　　　//查找所有数据
    @Override
    public List<Students> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from students";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Students> studentsList = new ArrayList<>();
            while(rs.next()) {
                Students student = new Students();
                student.setStudentId(rs.getInt("studentId"));
                student.setStudentName(rs.getString("studentName"));
                student.setSex(rs.getString("sex"));
                student.setPhoneNo(rs.getString("phoneNo"));
                student.setAddress(rs.getString("address"));
                student.setBirthday(rs.getDate("birthday"));
                studentsList.add(student);
            }
            return studentsList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, ps, rs);
        }
        return null;
    }}
}
