import java.util.Enumeration;
import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClienteMulticast {

  public static void main(String[] args) {

      while(true) {
        try {
          String host = "239.1.1.1";
          int port = 12347;
          
          MulticastSocket mcs = new MulticastSocket();
          //InetAddress grp = InetAddress.getByName("239.0.0.1");
          NetworkInterface nif = NetworkInterface.getByName("eth2");
          
          mcs.joinGroup(new InetSocketAddress(host, port), nif);
          byte rec[] = new byte[256];
          DatagramPacket pkg = new DatagramPacket(rec, rec.length);
          mcs.receive(pkg);

          String data = new String(pkg.getData());
          System.out.println("Dados recebidos:" + data);
          mcs.close();
      }
      catch(Exception e) {
        System.out.println("Erro: " + e.getMessage());
      }
    }
  }
}