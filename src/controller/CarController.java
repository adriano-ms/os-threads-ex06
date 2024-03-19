package controller;

import java.awt.TextArea;

import javax.swing.JLabel;

public class CarController extends Thread {

	private String name;
	private JLabel car;
	private int streetEnd;
	private int maxSpeed;
	private ResultController resultController;
	private TextArea console;

	public CarController() {
		super();
	}

	public CarController(String name, JLabel car, int streetEnd, int maxSpeed, ResultController resultController, TextArea console) {
		this.name = name;
		this.car = car;
		this.streetEnd = streetEnd;
		this.maxSpeed = maxSpeed;
		this.resultController = resultController;
		this.console = console;
	}

	@Override
	public void run() {
		try {
			while (car.getX() < streetEnd) {
				CarController.sleep(100);
				performDrag();
			}
			if(resultController.getWinnerTextField().getText().equals("")) {
				resultController.getWinnerTextField().setText(name);
			} else {
				resultController.getLoserTextField().setText(name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void performDrag() throws InterruptedException {
		int speed = (int)(Math.random() * maxSpeed);
		speed = speed < 100 ? 0 : speed;
		int deslocation = speed/100;
		for(int i = 0; i < 100 && car.getX() < streetEnd; i++) {
			car.setLocation(car.getX() + deslocation, car.getY());
			CarController.sleep(1);
		}
		console.append(name + " forward to " + car.getX() + " with speed " + speed + "\n");
		
	}
	
	@Override
	public String toString() {
		return name;
	}

}
