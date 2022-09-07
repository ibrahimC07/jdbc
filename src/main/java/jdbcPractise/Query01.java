package jdbcPractise;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","ibrahim5613");
        Statement st = con.createStatement();
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        //Sonuçları Al
        while (veri.next()){

            //index kullanarak
            //System.out.println(veri.getInt(1) + veri.getString(2) +
            //        veri.getString(3) + veri.getString(4));

            //sutun ismi kullanarak
            //System.out.println(veri.getInt("okul_no") + veri.getString("ogrenci_ismi")
            //+ veri.getString("sinif") + veri.getString("cinsiyet"));

            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4));
        }

        //6) Kapatma
        con.close();
        st.close();
        veri.close();
    }
}
