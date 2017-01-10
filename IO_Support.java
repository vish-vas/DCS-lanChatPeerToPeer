
/**
 * class IO_Support made to facilitate file and system input and output processes.
 * 
 * @author Vova Handa
 * @version 0.0
 */
import java.util.*;
import java.io.*;

public class IO_Support
{
    //create a scanner to support user input.
    private static Scanner in = new Scanner(System.in);
    
    public static void print(String s)
    {
        System.out.println(s);
    }
    
    public static String getString(String out)
    {
        System.out.print(out+" ");
        return in.nextLine();
    }
    
    public static ArrayList<String> readFile(String fileName) throws IOException
    {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        
        String temp = reader.readLine();
        while(temp!=null)
        {
            data.add(temp);
            temp = reader.readLine();
        }
        reader.close();
        return data;
    }
    
    public static void saveFile(String fileName, ArrayList<String> data) throws IOException
    {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for(String s: data)
        {
            writer.println(s);
        }
        writer.close();
    }
}
