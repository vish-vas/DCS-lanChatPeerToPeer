import java.util.ArrayList;
/**
 * Peer used to support peer data management for the program.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Peer
{
    private String peerIP;
    private String peerName;
    
    public Peer(String peerData)
    {
        if(peerData.contains(","))
        {
        String[] list = peerData.split(",");
        this.peerName = list[0];
        this.peerIP = list[1];
       }
       else
       {
        this.peerIP = peerData;
       }
    }
    
    public String getPeerName()
    {
        return peerName;
    }
    
    public String getPeerIP()
    {
        return peerIP;
    }
    
    public void addApprovedPeer(ArrayList<String> data)
    {
        data.add(this.peerName+","+this.peerIP);
    }
    
    public void  addUnapprovedPeer(ArrayList<String> data)
    {
        data.add(this.peerIP);
    }
}
