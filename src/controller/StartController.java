package controller;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class StartController implements ActionListener {

	public static final int START_POSITION = 5;
	private final int STREET_END = 750;

	private JLabel redCar;
	private JLabel blueCar;
	private JButton startButton;
	private JLabel maxSpeedLabel;
	private ResultController resultController;
	private TextArea console;
	private int maxSpeed;

	public StartController() {
		super();
	}

	public StartController(JLabel redCar, JLabel blueCar, JButton startButton,JLabel maxSpeedLabel, ResultController resultController, TextArea console) {
		this.redCar = redCar;
		this.blueCar = blueCar;
		this.startButton = startButton;
		this.maxSpeedLabel = maxSpeedLabel;
		this.resultController = resultController;
		this.console = console;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		maxSpeed = (int) (Math.random() * 400) + 100;
		maxSpeedLabel.setText("MAX SPEED: " + maxSpeed);
		redCar.setLocation(START_POSITION, redCar.getY());
		blueCar.setLocation(START_POSITION, blueCar.getY());
		resultController.getWinnerTextField().setText("");
		resultController.getLoserTextField().setText("");
		CarController redCarController = new CarController("Red Car", redCar, STREET_END, maxSpeed, resultController, console);
		CarController blueCarController = new CarController("Blue Car", blueCar, STREET_END, maxSpeed,
				resultController, console);
		redCarController.start();
		blueCarController.start();
		startButton.setEnabled(false);
		Thread aux = new Thread() {
			@Override
			public void run() {
				while(redCarController.isAlive() || blueCarController.isAlive())
					;
				startButton.setEnabled(true);
			}
		};
		aux.start();
	}

}
