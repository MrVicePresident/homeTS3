package supertask;
//1 to 3

import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomeTaskDone extends JFrame {

	public HomeTaskDone() {
		//JLabel label = new JLabel(setDriver());
		URL url = this.getClass().getClassLoader().getResource("images/test.jpg");
		JLabel label = new JLabel(new ImageIcon(url));
		add(label);
		setSize(2000,2000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public String setDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {		
		}
		
		Connection conn = null;
	
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/mymavendb?" +
		                                   "user=root&password=");

		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("select * from Puge where Name = 'Deadpool'");

		    if (rs.next()) {
		        return rs.getString("Power");
		    }

		    
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return "ERROR";
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		new HomeTaskDone();

	}

}
