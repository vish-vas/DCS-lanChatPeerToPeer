import java.util.*;
import java.io.*;
/**
 * class ServerThread is server module of the project it listens to a specific port, receives messages sent from approved peers.
 * 
 * @author Vova Handa 
 * @version 0.0
 */
public class ServerThread
{
    private ArrayList<Peer> approvedPeers;
    private ArrayList<Peer> unauthorizedPeers;
    public ServerThread()
    {
        approvedPeers = new ArrayList<Peer>();
        unauthorizedPeers = new ArrayList<Peer>();
        try
        {
            readPeersFromFile();
        }
        catch(Exception e)
        {
            IO_Support.print("Failed reading peers from file");
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
        ArrayList<String> dat = IO_Support.readFile("Unauthorized Peer List.txt");
        for(String s : dat)
        {
            Peer p = new Peer(s);
            this.unauthorizedPeers.add(p);
        }
    }
    
    private void saveBadPeersToFile() throws IOException
    {
        ArrayList<String> dat = new ArrayList<String>();
        for(Peer p : unauthorizedPeers)
        {
            p.addUnapprovedPeer(dat);
        }
        IO_Support.saveFile("Unauthorized Peer List.txt",dat);
    }
    
    public void messageReceived(String ip, String message)
    {
        //check if the message is received from the approved peers then display it.
        for(Peer p : approvedPeers)
        {
            if (ip.equals(p.getPeerIP()))
            {
                IO_Support.print(p.getPeerName()+" <"+p.getPeerIP()+"> "+message);
                return;
            }
        }
        //check if the message sender is already in bad ip list.
        for(Peer p : unauthorizedPeers)
        {
            if(ip.equals(p.getPeerIP()))
            {
                return;
            }
        }
        //if not found create new peer and add it to bad ip list.
        IO_Support.print("Unauthorized chat request from <IP "+ip+">");
        Peer p = new Peer(ip);
        this.unauthorizedPeers.add(p);
        try
        {
        saveBadPeersToFile();
        }
        catch(Exception e)
        {
            IO_Support.print("Failed to save Bad IP to the file");
        }
        return;
    }
}
