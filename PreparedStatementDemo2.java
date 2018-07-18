import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
class PreparedStatementDemo2
{
	public static void main(String dt[])
	{
		Connection con=null;
		PreparedStatement stnt=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql:///empdb";
			con=DriverManager.getConnection(url,"root","");
			stnt=con.prepareStatement("insert into empmaster values(?,?,?)");
			stnt.setInt(1,105);
			stnt.setString(2,"Arun");
			stnt.setDouble(3,25000);
			int result=stnt.executeUpdate();
			if(result>0)
			{
				System.out.println("Record inserted");
			}
			else
			{
				System.out.println("Record not inserted");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
		finally
		{
			try
			{
				stnt.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("Finally"+e);
			}
		}
	}
}