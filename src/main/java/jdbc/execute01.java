package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1. Adim : Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2.adim:Databas'e baglan
      Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","ibrahim5613");

        //3.adim : statement olustur.

        Statement st = con.createStatement();

        // 4.Adim: Query calistir.
        //1.Example: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
        String sql1 = "CREATE TABLE workers(worker_id varchar(50), worker_name varchar(50), worker_salary int)";
       boolean result = st.execute(sql1);
        System.out.println(result); // False return yapar, cunku data cagrilmadi.

        //2.Örnek: Alter table by adding worker_address column into the workers table

        String sql2= "Alter table workers add worker_address varchar(80)";
        st.execute(sql2);

        //3.example : drop workers table
        String sql3 = "drop table workers";
        st.execute(sql3);

        //5.adim: baglanti ve statementi kapat.

        con.close();
        st.close();


    }
}
