import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
class StatementDemo
{
	public static void main(String dt[])
	{
		Connection con=null;
		Statement stnt=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql:///empdb";
			con=DriverManager.getConnection(url,"root","");
			stnt=con.createStatement();
			int result=stnt.executeUpdate("insert into empmaster values(101,'Akshay',15000)");//manupilation ,returns how many row effected;
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