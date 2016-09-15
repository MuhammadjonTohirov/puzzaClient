package pClient;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class More1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmount;
	private int idd = 0;
	/**
	 * Launch the application.
	public void setDatas(String Name,float cost,String s,byte[] imgByte)
	{
		type = Name;
		Cost = cost;
		ingi = s;
		imageByte = imgByte;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					More1 frame = new More1();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public More1( byte[] imgByte, String Name,
			String Ingredients,float cost,int id) {
		idd =id;
		setTitle("More");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 399);
		setLocationRelativeTo(null);
		setLocation(500,230);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("logo");
		lblLogo.setBorder(new EmptyBorder(2, 2, 2, 2));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		if(imgByte!=null)
		lblLogo.setIcon(new ImageIcon(imgByte)); 
		lblLogo.setBounds(10, 10, 200, 200);
		contentPane.add(lblLogo);
		
		JLabel lblName = new JLabel(Name);
		lblName.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblName.setOpaque(true); 
		lblName.setBackground(Color.ORANGE);
		lblName.setBounds(10, 236, 200, 29);
		contentPane.add(lblName);
		
		JLabel lblCost = new JLabel(cost + " sum");
		lblCost.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblCost.setOpaque(true);
		lblCost.setBackground(Color.ORANGE);
		lblCost.setBounds(10, 315, 200, 29);
		contentPane.add(lblCost);
		
		JLabel lblIngredient = new JLabel("Ingredients");
		lblIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblIngredient.setBackground(Color.ORANGE);
		lblIngredient.setOpaque(true);
		lblIngredient.setBounds(261, 11, 252, 25);
		contentPane.add(lblIngredient);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 36, 252, 174);
		contentPane.add(scrollPane);
		
		JTextArea ingiArea = new JTextArea();
		scrollPane.setViewportView(ingiArea);
		ingiArea.setText(Ingredients);
		ingiArea.setEditable(false);
		
		JButton btnAdd = new JButton("OK");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 18));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 14));
			}
			
		});
		btnAdd.setBorder(null);
		btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(true);
				Pizzas a = Client.pizzas.get(id);
				if(txtAmount.getText()!="0")
				{
					a.setAmount(Integer.parseInt(txtAmount.getText()));
					a.setTotalCost(a.getAmount()*a.getPizzaCost());
					//Pizzas.setTotal(Pizzas.getTotal() + a.getTotalCost());
					a.setTicked(true);
					System.out.println(id);
				}
				else a.setTicked(false);
				dispose();
			}
		});
		btnAdd.setFocusable(false);
		btnAdd.setBackground(new Color(255, 102, 0));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBounds(380, 313, 133, 29);
		contentPane.add(btnAdd);
		
		setTxtAmount(new JTextField());
		getTxtAmount().setBounds(380, 236, 133, 29);
		contentPane.add(getTxtAmount());
		getTxtAmount().setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Amount");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(304, 241, 66, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblcost = new JLabel("Cost");
		lblcost.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblcost.setForeground(Color.RED);
		lblcost.setBounds(10, 301, 46, 14);
		contentPane.add(lblcost);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setForeground(Color.RED);
		lblName_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblName_1.setBounds(10, 221, 66, 14);
		contentPane.add(lblName_1);
	}
	public JTextField getTxtAmount() {
		return txtAmount;
	}
	public void setTxtAmount(JTextField txtAmount) {
		this.txtAmount = txtAmount;
		txtAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n'){
					Pizzas a = Client.pizzas.get(idd);
					if(txtAmount.getText()!="0")
					{
						a.setAmount(Integer.parseInt(txtAmount.getText()));
						a.setTotalCost(a.getAmount()*a.getPizzaCost());
						//Pizzas.setTotal(Pizzas.getTotal() + a.getTotalCost());
						a.setTicked(true);
						//System.out.println(id);
					}
					else a.setTicked(false);
					dispose();
				}
					
			}
		});
		txtAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(txtAmount.getText().equals("0"))
					txtAmount.setText("");
			}
		});
		txtAmount.setText("0");
	}
}
