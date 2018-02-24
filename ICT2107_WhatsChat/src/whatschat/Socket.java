package whatschat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public final class Socket {

	static String WKA = "230.1.1.1";
	static int port = 6789;
	static MulticastSocket multicastSocket = null;
	static InetAddress multicastGroup = null;

	public static void runSocket() {
		try {
			// Set multicast socket
			multicastGroup = InetAddress.getByName(WKA);
			multicastSocket = new MulticastSocket(port);
			multicastSocket.joinGroup(multicastGroup);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public static void dgpSend(String string) {
		byte[] buf = string.getBytes();
		DatagramPacket dgpConnected = new DatagramPacket(buf, buf.length, multicastGroup, port);
		try {
			multicastSocket.send(dgpConnected);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static String dgpRecieve() {
		byte buf[] = new byte[1000];
		DatagramPacket dgpReceived = new DatagramPacket(buf, buf.length);
		String msg = "";
		try {
			multicastSocket.receive(dgpReceived);
			byte[] receivedData = dgpReceived.getData();
			int length = dgpReceived.getLength();
			msg = new String(receivedData, 0, length);
			return msg;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}
}
