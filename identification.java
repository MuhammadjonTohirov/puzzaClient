package pClient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.MessageFormat;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class identification extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2472156484106403170L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private static Client client;
	/**
	 * Launch the application.
	 */
	public static identification frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new identification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Registration registration;
	public static int port = 1500;
	public static String ipaddRess = "127.0.0.1";


	public identification() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/pizza_logo1.png")));
		setResizable(false);
		setTitle("Sign In");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 473);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Image img = new ImageIcon(this.getClass().getResource("/labelLogin.png")).getImage();
		contentPane.setLayout(null);
		Image img1 = new ImageIcon(this.getClass().getResource("/labelPassword.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/PagBgLogin.jpg")).getImage();

		Panel panel = new Panel();
		panel.setBounds(0, 0, 654, 455);
		panel.setBackground(Color.WHITE);

		passwordField = new JPasswordField("password");
		passwordField.setBorder(null);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					try {
						getClient().getOutputStream().writeUTF(
								MessageFormat.format("LOGIN|{0}|{1}", txtUsername.getText(), passwordField.getText()));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

			}
		});
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (passwordField.getText().equals("password"))
					passwordField.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (passwordField.getText().equals(""))
					passwordField.setText("password");
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (passwordField.getText().equals("password"))
					passwordField.setText("");
			}
			// @Override
			// public void mouseExited(MouseEvent arg0) {
			// if(passwordField.getText().equals(""))
			// passwordField.setText("password");

		});
		passwordField.setEchoChar('*');
		passwordField.setToolTipText("");
		passwordField.setForeground(new Color(50, 205, 50));
		passwordField.setBounds(379, 198, 265, 37);

		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setBounds(538, 104, 106, 49);
		lblSignIn.setForeground(new Color(50, 205, 50));
		lblSignIn.setFont(new Font("Rockwell", Font.PLAIN, 30));

		JLabel label_2 = new JLabel("");
		label_2.setBounds(145, 121, 0, 0);
		panel.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					try {
						getClient().getOutputStream().writeUTF(
								MessageFormat.format("LOGIN|{0}|{1}", txtUsername.getText(), passwordField.getText()));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

			}
		});
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (txtUsername.getText().equals("username"))
					txtUsername.setText("");
			}
			// @Override
			// public void mouseExited(MouseEvent arg0) {
			// if(txtUsername.getText().equals(""))
			// txtUsername.setText("username");

		});
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtUsername.getText().equals("username"))
					txtUsername.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtUsername.getText().equals(""))
					txtUsername.setText("username");
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/or1.png")).getImage();

		JLabel lblLogin = new JLabel("");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					getClient().getOutputStream().writeUTF(
							MessageFormat.format("LOGIN|{0}|{1}", txtUsername.getText(), passwordField.getText()));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogin.setBounds(326, 322, 156, 49);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblLogin.setBounds(328, 322, 156, 49);
			}
		});

		JLabel lblSignup = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/signup.png")).getImage();
		lblSignup.setIcon(new ImageIcon(img5));
		lblSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration.frame = new Registration();
				Registration.frame.setVisible(true);
				frame.dispose();
			}

			public void mouseEntered(MouseEvent arg0) {
				lblSignup.setBounds(495, 322, 156, 49);
			}

			public void mouseExited(MouseEvent e) {
				lblSignup.setBounds(493, 322, 156, 49);
			}
		});

		JLabel lblOr = new JLabel("");
		lblOr.setIcon(new ImageIcon(img3));
		lblOr.setBounds(438, 293, 100, 104);
		panel.add(lblOr);
		lblSignup.setBounds(493, 322, 156, 49);
		panel.add(lblSignup);
		Image img4 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblLogin.setIcon(new ImageIcon(img4));
		lblLogin.setBounds(328, 322, 156, 49);
		panel.add(lblLogin);
		txtUsername.setForeground(new Color(50, 205, 50));
		txtUsername.setText("username");
		txtUsername.setBounds(379, 154, 265, 37);
		txtUsername.setFont(new Font("Rockwell", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		panel.add(txtUsername);

		JLabel lblQ = new JLabel("");
		lblQ.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ.setIcon(new ImageIcon(img));
		lblQ.setBounds(333, 154, 46, 37);
		panel.add(lblQ);
		panel.add(label_2);
		// Image img5 = new
		// ImageIcon(this.getClass().getResource("/signup.png")).getImage();
		panel.add(passwordField);
		panel.add(lblSignIn);
		contentPane.add(panel);

		JLabel lblQ_1 = new JLabel("");
		lblQ_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ_1.setIcon(new ImageIcon(img1));
		lblQ_1.setBounds(333, 198, 46, 37);
		panel.add(lblQ_1);

		JLabel label_1 = new JLabel("OFF");
		label_1.setBounds(589, 403, 21, 17);
		panel.add(label_1);
		label_1.setForeground(Color.RED);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Calibri", Font.BOLD, 13));

		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(255, 255, 255));
		Image img6 = new ImageIcon(this.getClass().getResource("/pizza_logo120.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img6));
		lblLogo.setBounds(424, 20, 120, 120);
		panel.add(lblLogo);

		// Image img3 = new
		// ImageIcon(this.getClass().getResource("/or1.png")).getImage();

		JLabel lblQ_2 = new JLabel("");
		lblQ_2.setBounds(0, -1, 653, 445);
		panel.add(lblQ_2);
		lblQ_2.setIcon(new ImageIcon(img2));

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					setClient(new Client());
					getClient().setConnection();
					checkServerStatus(label_1);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}

			public void windowActivated(WindowEvent arg0) {

			}

			public void windowClosing(WindowEvent arg0) {
				SendMessageToServer("EXIT");
				try {
					client.getInputStream().close();
					client.getOutputStream().close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public Thread readerThread;

	public void ReadMessage() {

	}


	public static Thread serverStatus;

	public static void checkServerStatus(JLabel lb) {
		serverStatus = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!Client.getMessage().equals("EXIT")) {
					
					if (getClient().isServerStatus()) {
						lb.setForeground(Color.green);
						lb.setText("ON");
						isServerOK = true;
					} else {
						isServerOK = false;
						lb.setForeground(Color.red);
						lb.setText("OFF");
					}
					try {
						Thread.sleep(1000);
					} catch (Exception ex) {
					}
				}
			}
		});
		serverStatus.start();
	}

	public static boolean isServerOK = false;

	public String Came = "";

	public void SendMessageToServer(String mess) {
		
		try {
			getClient().getOutputStream().writeUTF("Client " + getClient().getID() + ": " + mess);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Client getClient() {
		return client;
	}

	public static void setClient(Client client) {
		identification.client = client;
	}

	public static boolean isVerified = false;
}
