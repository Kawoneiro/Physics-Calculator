package pl.edu.pw.fizyka.pojava.ACFN;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntegralCalculator {

	private JFrame icFrame;

	/**
	 * Launch the application.
	 */
	public void iCalc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntegralCalculator window = new IntegralCalculator();
					window.icFrame.setLocationRelativeTo(null);
					window.icFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IntegralCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		icFrame = new JFrame();
		icFrame.setBounds(100, 100, 450, 300);
		icFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		icFrame.getContentPane().setLayout(null);
		
		JButton btnBackToMenu = new JButton("Powr\u00F3t do menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icFrame.setVisible(false);
				MainMenuFrame.main(null);
			}
		});
		btnBackToMenu.setBounds(241, 216, 183, 34);
		icFrame.getContentPane().add(btnBackToMenu);
	}

}
