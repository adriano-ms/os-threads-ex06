package controller;

import javax.swing.JTextField;

public class ResultController {

	private JTextField winnerTextField;
	private JTextField loserTextField;
	
	public ResultController() {
		super();
	}

	public ResultController(JTextField winnerTextField, JTextField loserTextField) {
		this.winnerTextField = winnerTextField;
		this.loserTextField = loserTextField;
	}

	public JTextField getWinnerTextField() {
		return winnerTextField;
	}

	public JTextField getLoserTextField() {
		return loserTextField;
	}
	
}
