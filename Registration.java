package pClient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.text.MessageFormat;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import org.json.simple.JSONObject;

import java.awt.Component;
import java.awt.Toolkit;

public class Registration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldFirstName;
	private JTextField fieldLastName;
	private JTextField fieldEMail;
	private JPasswordField passwordField;
	private JPasswordField passwordComfirm;
	public static Registration frame;
	private JTextField fieldLOGO;
	private static JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JLabel lblInfo;
	private JLabel lblPuzza;
	public static String password;
	public void Alert(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/pizza_logo1.png")));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				try {
					Client.output.writeUTF(Client.ID + ": EXIT");
					Client.input.close();
					Client.output.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
			}
		});
		setTitle("REGISTRATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setBounds(454, 107, 284, 273);
		contentPane.add(panel);
		panel.setLayout(null);

		fieldFirstName = new JTextField();
		fieldFirstName.setFont(new Font("Rockwell", Font.PLAIN, 14));
		fieldFirstName.setCaretColor(Color.WHITE);
		fieldFirstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (fieldFirstName.getText().equals("firstname"))
					fieldFirstName.setText("");
				fieldFirstName.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (fieldFirstName.getText().equals(""))
					fieldFirstName.setText("firstname");
			}
		});
		fieldFirstName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (fieldFirstName.getText().equals("firstname"))
					fieldFirstName.setText("");
				fieldFirstName.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if (fieldFirstName.getText().equals(""))
					fieldFirstName.setText("firstname");
			}
		});
		fieldFirstName.setBackground(new Color(0, 0, 0, 0));
		fieldFirstName.setForeground(new Color(255, 255, 255));
		fieldFirstName.setText("firstname");
		fieldFirstName.setBounds(10, 11, 264, 30);
		panel.add(fieldFirstName);
		fieldFirstName.setColumns(10);

		fieldLastName = new JTextField();
		fieldLastName.setFont(new Font("Rockwell", Font.PLAIN, 14));
		fieldLastName.setCaretColor(Color.WHITE);
		fieldLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (fieldLastName.getText().equals("lastname"))
					fieldLastName.setText("");
				fieldLastName.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (fieldLastName.getText().equals(""))
					fieldLastName.setText("lastname");
			}
		});
		fieldLastName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (fieldLastName.getText().equals("lastname"))
					fieldLastName.setText("");
				fieldLastName.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if (fieldLastName.getText().equals(""))
					fieldLastName.setText("lastname");
			}
		});
		fieldLastName.setBackground(new Color(0, 0, 0, 65));
		fieldLastName.setForeground(new Color(255, 255, 255));
		fieldLastName.setText("lastname");
		fieldLastName.setColumns(10);
		fieldLastName.setBounds(10, 54, 264, 30);
		panel.add(fieldLastName);

		fieldEMail = new JTextField();
		fieldEMail.setFont(new Font("Rockwell", Font.PLAIN, 14));
		fieldEMail.setCaretColor(Color.WHITE);
		fieldEMail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (fieldEMail.getText().equals("email"))
					fieldEMail.setText("");
				fieldEMail.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (fieldEMail.getText().equals(""))
					fieldEMail.setText("email");
			}
		});
		fieldEMail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (fieldEMail.getText().equals("email"))
					fieldEMail.setText("");
				fieldEMail.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if (fieldEMail.getText().equals(""))
					fieldEMail.setText("email");
			}
		});
		fieldEMail.setBackground(new Color(0, 0, 0, 65));
		fieldEMail.setForeground(new Color(255, 255, 255));
		fieldEMail.setText("email");
		fieldEMail.setColumns(10);
		fieldEMail.setBounds(10, 140, 264, 30);
		panel.add(fieldEMail);

		passwordField = new JPasswordField("");
		passwordField.setFont(new Font("Rockwell", Font.PLAIN, 14));
		passwordField.setCaretColor(Color.WHITE);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				passwordField.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				passwordField.setBackground(new Color(0, 0, 0, 65));
			}
		});
		passwordField.setBackground(new Color(0, 0, 0, 65));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBounds(10, 194, 125, 20);
		panel.add(passwordField);

		passwordComfirm = new JPasswordField();
		passwordComfirm.setFont(new Font("Rockwell", Font.PLAIN, 14));
		passwordComfirm.setCaretColor(Color.WHITE);
		passwordComfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {

				}

			}
		});
		passwordComfirm.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				passwordComfirm.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// passwordComfirm.setBackground(new Color(0,0,0,65));
			}
		});
		passwordComfirm.setBackground(new Color(0, 0, 0, 65));
		passwordComfirm.setForeground(new Color(255, 255, 255));
		passwordComfirm.setBounds(149, 194, 125, 20);
		panel.add(passwordComfirm);

		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				btnNewButton.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
			}
		});
		btnNewButton.setBackground(new Color(255, 102, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sendFilledForm();
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(70, 225, 147, 37);
		panel.add(btnNewButton);

		fieldLOGO = new JTextField();
		fieldLOGO.setFont(new Font("Rockwell", Font.PLAIN, 14));
		fieldLOGO.setCaretColor(Color.WHITE);
		fieldLOGO.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (fieldLOGO.getText().equals("username"))
					fieldLOGO.setText("");
				fieldLOGO.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (fieldLOGO.getText().equals(""))
					fieldLOGO.setText("username");
			}
		});
		fieldLOGO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (fieldLOGO.getText().equals("username"))
					fieldLOGO.setText("");
				fieldLOGO.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if (fieldLOGO.getText().equals(""))
					fieldLOGO.setText("username");
			}
		});
		fieldLOGO.setBackground(new Color(0, 0, 0, 65));
		fieldLOGO.setForeground(new Color(255, 255, 255));
		fieldLOGO.setText("username");
		fieldLOGO.setColumns(10);
		fieldLOGO.setBounds(10, 97, 264, 30);
		panel.add(fieldLOGO);

		lblPassword = new JLabel("password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(11, 180, 108, 14);
		panel.add(lblPassword);

		lblConfirmPassword = new JLabel("confirm password");
		lblConfirmPassword.setForeground(new Color(255, 255, 255));
		lblConfirmPassword.setBounds(151, 180, 123, 14);
		panel.add(lblConfirmPassword);
		Image img = new ImageIcon(this.getClass().getResource("/bg2.png")).getImage();
		Image img1 = new ImageIcon(this.getClass().getResource("/pizza_logo2.png")).getImage();

		lblInfo = new JLabel("SignUP to");
		lblInfo.setForeground(new Color(255, 140, 0));
		lblInfo.setFont(new Font("Century Gothic", Font.BOLD, 33));
		lblInfo.setBounds(463, 11, 148, 68);
		contentPane.add(lblInfo);

		lblPuzza = new JLabel("");
		lblPuzza.setHorizontalAlignment(SwingConstants.CENTER);
		Image img2 = new ImageIcon(this.getClass().getResource("/puzza.png")).getImage();
		lblPuzza.setIcon(new ImageIcon(img2));
		lblPuzza.setBounds(596, 52, 128, 55);
		contentPane.add(lblPuzza);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setAlignmentX(0.5f);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 750, 489);
		contentPane.add(lblNewLabel);
	}

	public void sendFilledForm() {
		try {
			if (fieldFirstName.getText().equals("")) {
				Alert("Fill the first name field");
			} else if (fieldLastName.getText().equals("")) {
				Alert("Fill the Last name field");
			} else if (fieldLOGO.getText().equals("")) {
				Alert("Please, fill the username field");
			} else if (!checkIsItEmailOrNot(fieldEMail.getText())) {
				Alert("Pease, fill the Email field correctly");
			} else
				if (passwordField.getText().equals(passwordComfirm.getText()) && !passwordField.getText().equals("")) {
				JSONObject obj = new JSONObject();
				obj.put("FName", fieldFirstName.getText());
				obj.put("LName", fieldLastName.getText());
				obj.put("logo", fieldLOGO.getText());
				obj.put("Email", fieldEMail.getText());
				obj.put("psw", passwordField.getText());
				obj.put("pswc", passwordComfirm.getText());
				password = passwordField.getText();
				Client.output.writeUTF("REG|" + obj);
			} else
				Alert("Password is not confirmed!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkIsItEmailOrNot(String email) {
		return email.matches("\\S+@+\\w[a-zA-Z]+.+\\w[a-z]");
	}

}
