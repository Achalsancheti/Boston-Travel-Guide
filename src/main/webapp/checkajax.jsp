<%@ page import="java.sql.*" %> 
<%
String name = request.getParameter("e").toString();
System.out.println(name);
String data ="";
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from usertable where userName='"+name+"'");
int count=0;
while(rs.next())
{

count++;
}

if(count>0)
{
data="Username Already Exists!";
}
else
{
data="You Can Register Now!!!!";
}
out.println(data);
System.out.println(data);
}
catch (Exception e) {
System.out.println(e);
}
%>