import java.util.ArrayList;
import java.io.*;
/**
 * class ClientThread sends messages to the approved peers on the network.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClientThread
{
    private ArrayList<Peer> approvedPeers;
    
    public ClientThread()
    {
        approvedPeers = new ArrayList<Peer>();
        try
        {
            readPeersFromFile();
        }
        catch(Exception e)
        {
            IO_Support.print("Failed reading approved peers from file");
        }
    }
    
    private void readPeersFromFile() throws IOException
    {
        ArrayList<String> data = IO_Support.readFile("Approved Peer List.txt");
        for(String s : data)
        {
            Peer p = new Peer(s);
            this.approvedPeers.add(p);
        }
    }
    
    public void sendMessage(String message)
    {
    }
}
