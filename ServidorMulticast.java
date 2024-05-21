import java.io.*;
import java.net.*;


public class ServidorMulticast {

  public static void main(String[] args) {

    if(args.length != 3) {
      System.out.println("Digite <endereco multicast> <porta> <mensagem>");
      System.exit(0);
    }

    try {
      byte[] b = args[2].getBytes();
      InetAddress addr = InetAddress.getByName(args[0]);
      DatagramSocket ds = new DatagramSocket();
      DatagramPacket pkg = new DatagramPacket(b, b.length, addr, Integer.parseInt(args[1]));
      ds.send(pkg);
    }
    catch(Exception e) {
      System.out.println("Nao foi possivel enviar a mensagem");
    }
  }
}