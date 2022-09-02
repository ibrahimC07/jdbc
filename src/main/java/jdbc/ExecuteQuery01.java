package jdbc;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","ibrahim5613");
        Statement st = con.createStatement();


        //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.

        //1. Yol OFFSET ve FETCH NEXT kullanarak

        String sql1 = "select company, number_of_employees from companies\n" +
                "order by number_of_employees desc\n" +
                "offset 1 ROW\n" +
                "fetch next 1 row only";
      ResultSet result1 =  st.executeQuery(sql1);

      while (result1.next()){

          System.out.println(result1.getString("company")+"-->"+result1.getString("number_of_employees"));
      }

        String sql2 = "SELECT company, number_of_employees\n" +
                "FROM companies\n" +
                "WHERE number_of_employees = (SELECT  MAX(number_of_employees)\n" +
                "                             FROM companies\n" +
                "                             WHERE number_of_employees < (SELECT MAX(number_of_employees)\n" +
                "                             FROM companies))";
      ResultSet result02 = st.executeQuery(sql2);

      while (result02.next()){

          System.out.println(result02.getString("company")+"--"+result02.getString("number_of_employees"));
      }

      con.close();
      st.close();
      result02.close();
      result1.close();



    }
}
