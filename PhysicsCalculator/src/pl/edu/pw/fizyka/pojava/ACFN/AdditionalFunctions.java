package pl.edu.pw.fizyka.pojava.ACFN;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdditionalFunctions {

	private JFrame afFrame;

	/**
	 * Launch the application.
	 */
	public void aFunctions() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdditionalFunctions window = new AdditionalFunctions();
					window.afFrame.setLocationRelativeTo(null);
					window.afFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdditionalFunctions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		afFrame = new JFrame();
		afFrame.setBounds(100, 100, 450, 300);
		afFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		afFrame.getContentPane().setLayout(null);
		
		JButton btnBackToMenu = new JButton("Powr\u00F3t do menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afFrame.setVisible(false);
				MainMenuFrame.main(null);
			}
		});
		btnBackToMenu.setBounds(241, 216, 183, 34);
		afFrame.getContentPane().add(btnBackToMenu);
	}

}
