import java.net.*;

public class TestCode
{
   public static void main(String ar[])
   {
     /*  try
       {
       InetAddress IP=InetAddress.getLocalHost();
       System.out.println("IP of my system is := "+IP.getHostAddress());
       InetAddress IPp=InetAddress.getLocalHost();
       System.out.println(IPp.toString());
    }
    catch(Exception e)
    {
    System.out.println(e);
    }*/
    ar[1] = "hello";
    System.out.println(ar[0]);
    ar[1]=IO_Support.getString("input something:");
    IO_Support.print(ar[1]);
    
}
}
