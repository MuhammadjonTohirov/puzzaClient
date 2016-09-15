package pClient;

import java.net.*;
import java.security.Signature;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.json.simple.parser.JSONParser;

import org.json.simple.*;

import java.util.ArrayList;
import java.awt.Color;
import java.io.*;

public class Client {
	private Socket socket;
	public static DataInputStream input;
	public static DataOutputStream output;
	private String ipAdress;
	private int Port;
	private Thread connThread;
	private static boolean serverStatus;
	private static String message = "message from server";
	public static List<Pizzas> pizzas;
	public static int l = 0;

	public Client() {
		setIpAdress("127.0.0.1");
		setPort(identification.port);
		pizzas = new ArrayList<Pizzas>();
	}

	public void setConnection() {
		connThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					socket = new Socket(getIpAdress(), getPort());
					input = new DataInputStream(socket.getInputStream());
					output = new DataOutputStream(socket.getOutputStream());
					output.writeUTF("I set the conection");
					setServerStatus(true);
					while (!getMessage().contains("EXIT")) {
						try {
							setMessage(input.readUTF().toString());

							System.out.println("SERVER: " + getMessage());
							decodeMessage(getMessage());
						} catch (Exception e) {
							System.out.println(e.getMessage());
							break;
						}

					}
					setServerStatus(false);

				} catch (Exception ex) {
					System.out.println(ex.getMessage() + " :ERROR");
				}
			}
		});
		connThread.start();
	}

	public Thread messageThread;

	public void waitMessage() {
		messageThread = new Thread(new Runnable() {
			@Override
			public void run() {
			}
		});
	}

	public static boolean siginSuccesfull = false;
	public static String ID = "";
	public static String Name;
	public static String LastName;
	public static String UserName;
	public static String Email;
	public int pizzTempid = 0;

	public void decodeMessage(String MESS) {

		if (MESS.startsWith("ID|")) {
			ID = MESS.substring(3);
			System.out.println(ID);
		}

		if (MESS.equals("WELLCOME")) {
			identification.frame.dispose();
			MainClientFrame f = new MainClientFrame();
			f.setVisible(true);
			siginSuccesfull = true;

		}
		if (MESS.startsWith("ANOTHERUSERISUSINGFROMYOUaccounT")) {
			JOptionPane.showMessageDialog(null, "Currently " + UserName + " is being used by someone !!!");
		}
		if (MESS.equals("WSORRY"))
			JOptionPane.showMessageDialog(null, "Error! Please check your password and Login");
		if (MESS.contains("REGSUCCESFULL")) {
			Registration.frame.dispose();
			JOptionPane.showMessageDialog(null, "Congratulations, You have successfully registered");
			identification.frame.setVisible(true);
			siginSuccesfull = true;

		}

		if (MESS.contains("REGUNSUCCESFULL")) {
			siginSuccesfull = false;
			JOptionPane.showMessageDialog(null, "• The username is already taken, please enter another one");
		}

		{
			if (MESS.startsWith("credentials|")) {
				MESS = MESS.substring(12);
				JSONParser pr = new JSONParser();
				JSONObject obj = new JSONObject();
				try{
					obj = (JSONObject)pr.parse(MESS);
					Name = (String)obj.get("FName");
					UserName = (String)obj.get("UserName");
					LastName = (String)obj.get("LName");
					Email = (String)obj.get("Email");
				}catch(Exception ex){
					
				}
			}
		
		}
		String type = "";
		String price = "";// pizzalar|n|p|i|numberPic
		String ingi = "";
		String spic = "";
		int pic = 0;

		if (siginSuccesfull)
			if (MESS.startsWith("PIZZALAR|")) {
				MESS = MESS.substring(9);
				for (int i = 0; i < MESS.length(); i++) {
					type += MESS.charAt(i);
					if (MESS.charAt(i) == '|') {
						MESS = MESS.substring(i + 1);
						type = type.replace("|", "");
						break;
					}
				}
				for (int i = 0; i < MESS.length(); i++) {
					price += MESS.charAt(i);
					if (MESS.charAt(i) == '|') {
						MESS = MESS.substring(i + 1);
						price = price.replace("|", "");
						break;
					}
				}
				for (int i = 0; i < MESS.length(); i++) {
					ingi += MESS.charAt(i);
					if (MESS.charAt(i) == '|') {
						MESS = MESS.substring(i + 1);
						ingi = ingi.replace("|", "");
						break;
					}
				} // PIZZALAR|type|cost|ingi|img100|img200
				for (int i = 0; i < MESS.length(); i++) {
					spic += MESS.charAt(i);
					if (MESS.charAt(i) == '|') {
						MESS = MESS.substring(i + 1);
						spic = spic.replace("|", "");
						break;
					}
				}
				pic = Integer.parseInt(spic);
				spic = "";
				int pic1 = 0;
				for (int i = 0; i < MESS.length(); i++) {
					spic += MESS.charAt(i);
					if (MESS.charAt(i) == '|') {
						MESS = MESS.substring(i + 1);
						spic = spic.replace("|", "");
						break;
					}
				}
				pic1 = Integer.parseInt(spic);
				spic = "";
				l = 0;

				for (int i = 0; i < MESS.length(); i++) {
					spic += MESS.charAt(i);
					if (MESS.charAt(i) == '|') {
						MESS = MESS.substring(i + 1);
						spic = spic.replace("|", "");
						break;
					}
				}
				l = Integer.parseInt(spic);

				byte[] bytes = new byte[pic];
				byte[] bytes1 = new byte[pic1];
				try {
					for (int i = 0; i < pic; i++) {
						bytes[i] = input.readByte();
					}
					for (int i = 0; i < pic1; i++) {
						bytes1[i] = input.readByte();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				pizzas.add(new Pizzas(pizzTempid, type, Float.parseFloat(price), ingi, false, bytes, bytes1));
				System.out.println(type + "/" + price + "/" + ingi + "/" + pic + "/" + pic1);
				System.out.println(bytes[0] + " " + bytes[pic - 1]);
				System.out.println(bytes1[0] + " " + bytes1[pic - 1]);
				if (pizzas.size() == l) {
					System.out.println(Client.pizzas.size());
				}
				pizzTempid++;
			}
	}

	public String getID() {
		return ID;
	}

	public DataInputStream getInputStream() {
		return input;
	}

	public DataOutputStream getOutputStream() {
		return output;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public int getPort() {
		return Port;
	}

	public void setPort(int port) {
		Port = port;
	}

	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		Client.message = message;
	}

	public boolean isServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(boolean serverStatus) {
		Client.serverStatus = serverStatus;
	}
}
