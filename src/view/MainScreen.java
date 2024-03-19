package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ResultController;
import controller.StartController;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel cityBackground;
	private Image img;
	private JLabel redCar;
	private JLabel blueCar;
	private JButton startButton;
	private JTextField winnerTextField;
	private JTextField loserTextField;
	private JLabel winnerLabel;
	private JLabel loserLabel;
	private JLabel maxSpeedLabel;
	private TextArea console;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setTitle("Super Drift Race");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 830, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		maxSpeedLabel = new JLabel("MAX SPEED: ");
		maxSpeedLabel.setFont(new Font("Unispace", Font.BOLD | Font.ITALIC, 15));
		maxSpeedLabel.setBounds(5, 11, 132, 14);
		contentPane.add(maxSpeedLabel);
		
		img = new ImageIcon(this.getClass().getResource("/blue_car.png")).getImage().getScaledInstance(64, 32, Image.SCALE_DEFAULT);
		blueCar = new JLabel("");
		blueCar.setBounds(StartController.START_POSITION, 315, 64, 32);
		blueCar.setIcon(new ImageIcon(img));
		contentPane.add(blueCar);
		
		img = new ImageIcon(this.getClass().getResource("/red_car.png")).getImage().getScaledInstance(64, 32, Image.SCALE_DEFAULT);
		redCar = new JLabel("");
		redCar.setBounds(StartController.START_POSITION, 270, 64, 32);
		redCar.setIcon(new ImageIcon(img));
		contentPane.add(redCar);
		
		img = new ImageIcon(this.getClass().getResource("/city.png")).getImage();
		cityBackground = new JLabel("");
		cityBackground.setBounds(0, -200, 814, 563);
		cityBackground.setIcon(new ImageIcon(img));
		contentPane.add(cityBackground);
		
		winnerTextField = new JTextField("");
		winnerTextField.setEditable(false);
		winnerTextField.setBounds(519, 416, 86, 20);
		contentPane.add(winnerTextField);
		winnerTextField.setColumns(10);
		
		loserTextField = new JTextField("");
		loserTextField.setEditable(false);
		loserTextField.setBounds(519, 447, 86, 20);
		contentPane.add(loserTextField);
		loserTextField.setColumns(10);
		
		console = new TextArea();
		console.setEditable(false);
		console.setBounds(0, 363, 310, 198);
		contentPane.add(console);
		
		startButton = new JButton("Start");
		startButton.setBounds(517, 502, 90, 23);
		contentPane.add(startButton);
		startButton.addActionListener(new StartController(redCar, blueCar, startButton, maxSpeedLabel, new ResultController(winnerTextField, loserTextField), console));
		
		winnerLabel = new JLabel("Winner");
		winnerLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winnerLabel.setBounds(463, 418, 46, 14);
		contentPane.add(winnerLabel);
		
		loserLabel = new JLabel("Loser");
		loserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loserLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		loserLabel.setBounds(463, 449, 46, 14);
		contentPane.add(loserLabel);
				
	}
}
