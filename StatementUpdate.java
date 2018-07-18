import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
class StatementUpdate
{
	public static void main(String dt[])
	{
		Connection con=null;
		Statement stnt=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//forname static method includes class at run time
			String url="jdbc:mysql:///empdb";// port number and ip adress /// means default ip and port number 3306
			con=DriverManager.getConnection(url,"root","");//same as request in socket by socket constructor
			stnt=con.createStatement();
			int result=stnt.executeUpdate("insert into empmaster values(1,'Ak',10000)");//manupilation ,returns how many row effected;
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