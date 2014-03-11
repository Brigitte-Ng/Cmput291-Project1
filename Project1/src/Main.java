import java.sql.*;
import java.io.*;

public class Main{

    public static void main(String[] args)
    {
        String m_url="dbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
        String m_driverName="oracle.jdbc.driver.OracleDriver";
        Console cns = System.console();
        String m_username = grabUsername(cns);
        String m_password = grabPassword(cns);
        boolean c_password = false;

        while (true) {
        	while (c_password == false) {
		        try{
		            Class drvClass = Class.forName(m_driverName);
		            Connection con = DriverManager.getConnection(m_url,
		                                m_username,m_password);
		            con.close();
		            c_password = true;
		        }
		        catch(Exception e){
		        	cns.printf("Wrong username or password.\n");
		        	grabUsername(cns);
		            grabPassword(cns);
		        }
        	}
        }
    }
    
    public static String grabUsername(Console cns) {
        return cns.readLine("Username: ");
    }
    
    public static String grabPassword(Console cns) {
        return new String(cns.readPassword("Password: "));
    }
}
