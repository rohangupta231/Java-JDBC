import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
class PreparedStatementDemo1
{
	public static void main(String dt[])
	{
		Connection con=null;
		PreparedStatement stnt=null;
		ResultSet rs=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql:///empdb";
			con=DriverManager.getConnection(url,"root","");
			stnt=con.prepareStatement("select * from empmaster");
			rs=stnt.executeQuery();
			while(rs.next())
			{
				System.out.println("id is "+rs.getInt(1));
				System.out.println("name is "+rs.getString(2));//getColumnIndex
				System.out.println("Salary is "+rs.getDouble(3));
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
				rs.close();
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