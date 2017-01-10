
/**
 * Write a description of class QuoteServer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;

public class QuoteServer 
{
    public static void main(String[] args) throws IOException
    {
        new QuoteServerThread().start();
    }
}