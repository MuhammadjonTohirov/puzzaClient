package pClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONObject;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class UpdateCredentials extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static UpdateCredentials frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UpdateCredentials();
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
	public UpdateCredentials() {
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Java_Update\\Java Mars 1.0\\PizzaShop\\Image\\editicon.png"));

		setFont(new Font("Consolas", Font.PLAIN, 12));
		setBackground(SystemColor.inactiveCaptionBorder);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("First Name");
		label.setBounds(10, 10, 77, 22);
		contentPane.add(label);
		
		TextField txtFN = new TextField();
		txtFN.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtFN.setBackground(SystemColor.inactiveCaptionBorder);
		txtFN.setBounds(111, 10, 234, 22);
		contentPane.add(txtFN);
		
		TextField txtLN = new TextField();
		txtLN.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtLN.setBackground(SystemColor.inactiveCaptionBorder);
		txtLN.setBounds(111, 50, 234, 22);
		contentPane.add(txtLN);
		
		Label label_1 = new Label("Last Name");
		label_1.setBounds(10, 50, 77, 22);
		contentPane.add(label_1);
		
		TextField txtUN = new TextField();
		txtUN.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtUN.setBackground(SystemColor.inactiveCaptionBorder);
		txtUN.setBounds(111, 95, 234, 22);
		contentPane.add(txtUN);
		
		Label label_2 = new Label("User Name");
		label_2.setBounds(10, 95, 77, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Password");
		label_3.setBounds(10, 180, 77, 22);
		contentPane.add(label_3);
		
		TextField txtPSW = new TextField();
		txtPSW.setText("Pa$$w0rd");
		txtPSW.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtPSW.setBackground(SystemColor.inactiveCaptionBorder);
		txtPSW.setBounds(111, 180, 234, 22);
		contentPane.add(txtPSW);
		
		TextField txtEM = new TextField();
		txtEM.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtEM.setBackground(SystemColor.inactiveCaptionBorder);
		txtEM.setBounds(111, 135, 234, 22);
		contentPane.add(txtEM);
		
		Label label_4 = new Label("E-Mail");
		label_4.setBounds(10, 135, 77, 22);
		contentPane.add(label_4);
		
		Button button = new Button("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JSONObject obj = new JSONObject();
				obj.put("OLDUName", Client.UserName);
				obj.put("UserName", txtUN.getText().toString());
				obj.put("FName", txtFN.getText());
				obj.put("LName", txtLN.getText());
				obj.put("Password", txtPSW.getText());
				obj.put("Email", txtEM.getText());
				try {
					Client.output.writeUTF("Update|"+obj);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Your credentials has been changed");
			}
		});
		button.setBounds(275, 218, 70, 22);
		contentPane.add(button);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtFN.setText(Client.Name);
				txtLN.setText(Client.LastName);
				txtUN.setText(Client.UserName);
				txtEM.setText(Client.Email);
				txtPSW.setText(Registration.password);
			}
		});
	}

}
