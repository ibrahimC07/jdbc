package jdbc;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","ibrahim5613");
        Statement st = con.createStatement();

        //1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan number_of_employees değerlerini 16000 olarak UPDATE edin.

        String sql1 = "update companies\n" +
                "set number_of_employees = 1600\n" +
                "where number_of_employees < (select avg(number_of_employees) from companies)";

        int ubdateSatirSayisi = st.executeUpdate(sql1);

        System.out.println("ubdateSatirSayisi = " + ubdateSatirSayisi);

        String sql2 = "Select * from companies";
       ResultSet result01 =  st.executeQuery(sql2);

       while (result01.next()){
           System.out.println(result01.getInt(1)+"--"+result01.getString(2)+"--"+result01.getInt(3));
       }

       con.close();
       st.close();
    }
}
