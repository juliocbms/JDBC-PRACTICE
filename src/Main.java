import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

//        Connection conn = null;
//        Statement st = null;
//        ResultSet rs = null;
//
//        try {
//            conn = DB.getConnection();
//
//            st = conn.createStatement();
//
//          rs =  st.executeQuery("select * from department");
//
//          while (rs.next()){
//              System.out.println(rs.getInt("Id")+ ", "+ rs.getString("Name"));
//          }
//
//        } catch (SQLException e) {
//            throw new DbException(e.getMessage());
//        }
//        finally {
//            DB.closeResultSet(rs);
//            DB.closeStatement(st);
//            DB.closeConnection();
//        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/*

        //INSERIR DADOS
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + "VALUES "
                    + "(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1,"Carl Purple");
            st.setString(2,"carl@gmail.com");
            st.setDate(3,new  java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4,3000.0);
            st.setInt(5,4);

            st = conn.prepareStatement(
                    "insert into department (Name) values ('D1'),('D2')",
                    Statement.RETURN_GENERATED_KEYS);

           int rowsAffected = st.executeUpdate();

           if (rowsAffected > 0 ){
              ResultSet rs =   st.getGeneratedKeys();
              while (rs.next()){
                  int id = rs.getInt(1);
                  System.out.println("Done! Id = "+ id);
              }
           }else {
               System.out.println("No rows affected!");
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
        */

        //ATUALIZAR DADOS
        /*Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary = BaseSalary + ? "
                    + "WHERE "
                    + "(DepartmentId = ?)");
            st.setDouble(1,200.0);
            st.setInt(2,2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows Affected: "+ rowsAffected);
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
*/

        /*
    //DELETAR DADOS
     Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "DELETE FROM department "
                    + "WHERE "
                    + "Id = ?");

            st.setInt(1,2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows Affected: "+ rowsAffected);
        }catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
*/

/*

        //TRANSAÇÕES
        Connection conn = null;
       Statement st = null;

        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

//            int x =1;
//            if (x<2){
//                throw new SQLException("Fake error");
//            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("rows1 = "+rows1);
            System.out.println("rows2 = "+rows2);

        }catch (SQLException e){
            try {
                conn.rollback();
                throw  new DbException("transaction rolled back! Caused by: "+ e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying to rollback! Caused by: "+ex.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

 */
    }
}