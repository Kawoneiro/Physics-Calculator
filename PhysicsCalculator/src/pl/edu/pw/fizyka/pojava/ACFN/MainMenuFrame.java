package pl.edu.pw.fizyka.pojava.ACFN;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuFrame {

	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuFrame window = new MainMenuFrame();
					window.mainFrame.setLocationRelativeTo(null);
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenuFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setResizable(false);
		mainFrame.setBounds(100, 100, 300, 450);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		JLabel labelCalculator = new JLabel("Kalkulator fizyczny");
		labelCalculator.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCalculator.setHorizontalAlignment(SwingConstants.CENTER);
		labelCalculator.setBounds(37, 26, 213, 58);
		mainFrame.getContentPane().add(labelCalculator);
		
		JButton btnStdCalc = new JButton("Kalkulator standardowy");
		btnStdCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				StandardCalculator calc = new StandardCalculator();
				calc.sCalc();
			}
		});
		btnStdCalc.setBounds(10, 95, 274, 50);
		mainFrame.getContentPane().add(btnStdCalc);
		
		JButton btnIntCalc = new JButton("Obliczanie ca\u0142ek oznaczonych");
		btnIntCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				IntegralCalculator icalc = new IntegralCalculator();
				icalc.iCalc();
			}
		});
		btnIntCalc.setBounds(10, 156, 274, 50);
		mainFrame.getContentPane().add(btnIntCalc);
		
		JButton btnAnalysis = new JButton("Analiza danych z pliku");
		btnAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				DataAnalysis da = new DataAnalysis();
				da.dAnalysis();
			}
		});
		btnAnalysis.setBounds(10, 217, 274, 50);
		mainFrame.getContentPane().add(btnAnalysis);
		
		JButton btnAdditional = new JButton("Dodatkowe funkcje");
		btnAdditional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				AdditionalFunctions af = new AdditionalFunctions();
				af.aFunctions();
			}
		});
		btnAdditional.setBounds(10, 278, 274, 50);
		mainFrame.getContentPane().add(btnAdditional);
		
		JButton btnExit = new JButton("Zamknij");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 360, 274, 50);
		mainFrame.getContentPane().add(btnExit);
	}
}
