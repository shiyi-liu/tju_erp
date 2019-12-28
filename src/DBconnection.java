import java.sql.*;

public class DBconnection {

	private static Connection conn = null;
	
	public static void main(String args[]) throws Exception {  
        DBconnection dbc=new DBconnection();  
        dbc.ConnectAccessFile();  
        
    }  
	
    public static void ConnectAccessFile() throws Exception {  
        Class.forName("com.hxtt.sql.access.AccessDriver");  
        conn = DriverManager.getConnection("jdbc:Access:///c:/Database.mdb");  
        
        /**
        Statement stmt = conn.createStatement();  
        ResultSet rs = stmt.executeQuery("select 收货单位码 from 收货单位");  
        
        while (rs.next()) {  
            System.out.println(rs.getString(1));  
        }  
        rs.close();  
        stmt.close();  
        conn.close();  
        */
    }
    
    public static Connection getConn(){
    	return conn;
    }
    
}  
