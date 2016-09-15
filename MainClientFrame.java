package pClient;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class MainClientFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public float total = 0;
	public JPanel panel_2;
	public static JLabel lblGif;
	/**
	 * Launch the application.
	 */
	public static MainClientFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainClientFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Alert(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public static JLabel lblServerStatus;
	public static JLabel lblemail;
	public static JLabel lblName;
	public static JLabel lblLOGO;
	private JTextField costField;
	private JTextField timeField;
	private JTextField addressField;
	private JLabel editCre;

	public MainClientFrame() {
		setType(Type.POPUP);
		setBackground(new Color(240, 230, 140));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/pizza_logo1.png")));
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				try {
					Client.output.writeUTF("EXIT|" + Client.Name + "|" + Client.UserName);
					Client.input.close();
					Client.output.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			@Override
			public void windowOpened(WindowEvent arg0) {

				lblGif = new JLabel("");
				Image img3 = new ImageIcon(this.getClass().getResource("/loader-match.gif")).getImage();
				lblGif.setIcon(new ImageIcon(img3));
				lblGif.setBounds(192, 320, 147, 147);
				panel_2.add(lblGif);
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {

						try {
							while (true) {
								if (Client.pizzas.size() > Client.l - 1) {
									for (int j = 0, i = 0, c = 0; j < 4;)
										for (int a = 0; a < Client.pizzas.size(); a++) {
											generatePizzaLabel(Client.pizzas.get(a).getImage100(),
													Client.pizzas.get(a).getImage200(),
													Client.pizzas.get(a).getPizzaType(), i, j,
													Client.pizzas.get(a).getDefenition(),
													Client.pizzas.get(a).getPizzaCost(), Client.pizzas.get(a).getId());

											++i;
											c++;
											if (c % 4 == 0) {
												j++;
												i = 0;
											}
										}
									System.out.println("EQual");
									setForeground(Color.white);
									lblGif.setVisible(false);
									break;
								}
								Thread.sleep(500);
							}
							Client.output.writeUTF("IMREADY|" + Client.UserName);

						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						System.out.println(".:Loaded:.");

					}
				});
				th.start();

				setLocation(30, 15);
				identification.checkServerStatus(lblServerStatus);
				lblName.setText(Client.Name);
				lblemail.setText(Client.Email);
				lblLOGO.setText(Client.UserName);
				System.out.println("Loading . . .");
				{

				}
			}
		});
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("pUZza WORLD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		editCre = new JLabel();
		editCre.setText("Edit credentials");
		editCre.setBounds(20, 630, 1000, 42);
		contentPane.add(editCre);
		editCre.setIcon(new ImageIcon("Image\\edit.png"));
		editCre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				editCre.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				editCre.setForeground(Color.black);
	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				editCre.setLocation(21, 631);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				editCre.setLocation(20, 630);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateCredentials.frame = new UpdateCredentials();
				UpdateCredentials.frame.setVisible(true);
			}
		});
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 652, 1294, 30);
		contentPane.add(panel);
		panel.setLayout(null);

		lblServerStatus = new JLabel("OFF");
		lblServerStatus.setBounds(1227, 3, 57, 14);
		panel.add(lblServerStatus);

		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(204, 0, 255));
		panel_2.setBounds(0, 11, 1294, 641);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/puzza-new1.png")).getImage();

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(21, 0, 497, 212);
		panel_2.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(img));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(574, 498, 526, 100);
		panel_2.add(scrollPane);

		JTextArea textListArea = new JTextArea();
		scrollPane.setViewportView(textListArea);
		textListArea.setText("Pizza type" + "\t\t" + "Amount" + "\t\t" + "Cost\n");
		textListArea.setBackground(new Color(255, 255, 224));
		textListArea.setEditable(false);
		// Image img1 = new
		// ImageIcon(this.getClass().getResource("/crayfish-100.png")).getImage();

		JLabel label_6 = new JLabel("UserName:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setForeground(new Color(255, 0, 0));
		label_6.setBounds(593, 37, 100, 33);
		panel_2.add(label_6);

		JLabel label_7 = new JLabel("Email:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_7.setForeground(new Color(255, 0, 0));
		label_7.setBounds(593, 143, 100, 33);
		panel_2.add(label_7);

		JLabel label_5 = new JLabel("Name:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setForeground(new Color(255, 0, 0));
		label_5.setBounds(593, 90, 100, 33);
		panel_2.add(label_5);

		lblLOGO = new JLabel("");
		lblLOGO.setForeground(new Color(34, 139, 34));
		lblLOGO.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLOGO.setBounds(752, 37, 261, 33);
		panel_2.add(lblLOGO);

		lblemail = new JLabel("");
		lblemail.setForeground(new Color(34, 139, 34));
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblemail.setBounds(752, 143, 263, 33);
		panel_2.add(lblemail);

		lblName = new JLabel("");
		lblName.setForeground(new Color(34, 139, 34));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(752, 90, 261, 33);
		panel_2.add(lblName);

		costField = new JTextField();
		costField.setText(" 0.0 sum");
		costField.setBackground(new Color(255, 255, 224));
		costField.setEditable(false);
		costField.setBounds(1128, 550, 140, 33);
		panel_2.add(costField);
		costField.setColumns(10);

		JButton btnTestbtn = new JButton("See Result");
		btnTestbtn.setBorder(null);
		btnTestbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnTestbtn.setFont(new Font("Rockwell", Font.PLAIN, 17));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				btnTestbtn.setFont(new Font("Rockwell", Font.PLAIN, 14));
			}
		});
		btnTestbtn.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnTestbtn.setForeground(new Color(255, 255, 255));
		btnTestbtn.setBackground(new Color(255, 140, 0));
		btnTestbtn.setBounds(574, 464, 133, 33);
		btnTestbtn.setFocusable(false);
		panel_2.add(btnTestbtn);

		JLabel lblTotalCost = new JLabel("Total Cost");
		lblTotalCost.setForeground(new Color(255, 0, 0));
		lblTotalCost.setFont(new Font("Rockwell", Font.PLAIN, 18));
		lblTotalCost.setBounds(1128, 516, 89, 33);
		panel_2.add(lblTotalCost);

		JLabel lblBgl = new JLabel("");
		lblBgl.setBounds(574, 37, 526, 140);
		panel_2.add(lblBgl);

		JLabel lblHo = new JLabel("");
		lblHo.setHorizontalAlignment(SwingConstants.CENTER);
		Image img1 = new ImageIcon(this.getClass().getResource("/unShaded2.png")).getImage();
		lblHo.setIcon(new ImageIcon(img1));
		lblHo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JSONObject obj = null;
				JSONArray jarray = new JSONArray();
				try {
					if (timeField.getText().equals("")) {
						Alert("Fill the time field");
					} else if (addressField.getText().equals("")) {
						Alert("Fill the Address field");
					} else {

						for (Pizzas p : Client.pizzas) {
							if (p.isTicked()) {
								obj = new JSONObject();
								obj.put("pizzaType", p.getPizzaType());
								obj.put("Cost", p.getPizzaCost());
								obj.put("amount", p.getAmount());
								obj.put("orderedBy", Client.UserName);
								obj.put("TIME", timeField.getText());
								obj.put("ADDRESS", addressField.getText());
								Client.output.writeUTF("SENDPIZZA|" + obj);
							}
							// jarray.add(obj);
						}
						JOptionPane.showMessageDialog(null, "Great! Your request sent");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				Image img1 = new ImageIcon(this.getClass().getResource("/unShaded1.png")).getImage();
				lblHo.setIcon(new ImageIcon(img1));
			}

			public void mouseExited(MouseEvent arg0) {
				Image img1 = new ImageIcon(this.getClass().getResource("/unShaded2.png")).getImage();
				lblHo.setIcon(new ImageIcon(img1));
			}
		});

		lblHo.setBounds(1190, 12, 92, 92);
		panel_2.add(lblHo);

		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image img2 = new ImageIcon(this.getClass().getResource("/pizza_logo2.png")).getImage();
		lblLogo_1.setIcon(new ImageIcon(img2));
		lblLogo_1.setBounds(788, 187, 287, 300);
		panel_2.add(lblLogo_1);

		JLabel lblTime = new JLabel("time");
		lblTime.setForeground(Color.RED);
		lblTime.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblTime.setBounds(575, 599, 46, 31);
		panel_2.add(lblTime);

		timeField = new JTextField();
		timeField.setBounds(621, 599, 122, 31);
		panel_2.add(timeField);
		timeField.setColumns(10);

		JLabel lblAddress = new JLabel("address");
		lblAddress.setForeground(Color.RED);
		lblAddress.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblAddress.setBounds(755, 599, 71, 31);
		panel_2.add(lblAddress);

		addressField = new JTextField();
		addressField.setBounds(826, 599, 274, 30);
		panel_2.add(addressField);
		addressField.setColumns(10);

		btnTestbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textListArea.setText("Pizza type" + "\t\t" + "Amount" + "\t\t" + "Cost\n");
				for (int i = 0; i < Client.pizzas.size(); i++) {
					if (Client.pizzas.get(i).isTicked()) {
						textListArea.setText(textListArea.getText() + Client.pizzas.get(i).getPizzaType() + "\t\t"
								+ Client.pizzas.get(i).getAmount() + "\t\t" + Client.pizzas.get(i).getTotalCost()
								+ " sum\n");
						Pizzas.setTotal(Pizzas.getTotal() + Client.pizzas.get(i).getTotalCost());
					}
				}
				total = Pizzas.getTotal();
				Pizzas.setTotal(0);
				costField.setText(total + " sum");
			}
		});
	}

	public void generatePizzaLabel(byte[] imageByte, byte[] imageByte200, String lblName, int i, int j,
			String Ingredients, float cost, int id) {

		JLabel l = new JLabel();
		l.setIcon(new ImageIcon(imageByte));
		l.setLocation(51 + i * 110, 197 + j * 110);
		l.setSize(100, 100);
		l.setVisible(true);
		l.setFocusable(true);
		l.setEnabled(true);
		l.setName(lblName);
		getContentPane().add(l);
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				More1 m = new More1(imageByte200, lblName, Ingredients, cost, id);
				m.setVisible(true);
			}
		});
	}
}
