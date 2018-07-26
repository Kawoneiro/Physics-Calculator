package pl.edu.pw.fizyka.pojava.ACFN;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StandardCalculator {

	private JFrame scFrame;
	private JTextField textField;
	private double tmp, firstNum, secondNum, result;
	private String operations, answer;

	/**
	 * Launch the application.
	 */
	public void sCalc() { //44 znaki
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StandardCalculator window = new StandardCalculator();
					window.scFrame.setLocationRelativeTo(null);
					window.scFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StandardCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		scFrame = new JFrame();
		scFrame.setResizable(false);
		scFrame.setBounds(100, 100, 640, 480);
		scFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		scFrame.getContentPane().setLayout(null);
		
		JButton btnBackToMenu = new JButton("Powr\u00F3t do menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scFrame.setVisible(false);
				MainMenuFrame.main(null);
			}
		});
		btnBackToMenu.setBounds(441, 406, 183, 34);
		scFrame.getContentPane().add(btnBackToMenu);
		
		JPanel calcPanel = new JPanel();
		calcPanel.setBounds(10, 11, 614, 384);
		scFrame.getContentPane().add(calcPanel);
		calcPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 11, 594, 49);
		calcPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnRemove = new JButton("\u21D0");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String backspace = null;
				if(textField.getText().length() > 0) {
					StringBuilder strB = new StringBuilder(textField.getText());
					strB.deleteCharAt(textField.getText().length() - 1);
					backspace = strB.toString();
					textField.setText(backspace);
					
				}
			}
		});
		btnRemove.setBounds(10, 71, 50, 50);
		calcPanel.add(btnRemove);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "1");
			}
		});
		btn1.setBounds(10, 254, 50, 50);
		calcPanel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "2");
			}
		});
		btn2.setBounds(70, 254, 50, 50);
		calcPanel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "3");
			}
		});
		btn3.setBounds(130, 254, 50, 50);
		calcPanel.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "4");
			}
		});
		btn4.setBounds(10, 193, 50, 50);
		calcPanel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});
		btn5.setBounds(70, 193, 50, 50);
		calcPanel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});
		btn6.setBounds(130, 193, 50, 50);
		calcPanel.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		btn7.setBounds(10, 132, 50, 50);
		calcPanel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});
		btn8.setBounds(70, 132, 50, 50);
		calcPanel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "9");
			}
		});
		btn9.setBounds(130, 132, 50, 50);
		calcPanel.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "0");
			}
		});
		btn0.setBounds(10, 315, 110, 50);
		calcPanel.add(btn0);
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondNum = Double.parseDouble(textField.getText());
				if(operations == "+") {
					result = firstNum + secondNum;
					answer = String.format("%f", result);
					textField.setText(answer);
				}
				else if(operations == "-") {
					result = firstNum - secondNum;
					answer = String.format("%f", result);
					textField.setText(answer);
				}
				else if(operations == "*") {
					result = firstNum * secondNum;
					answer = String.format("%f", result);
					textField.setText(answer);
				}
				else if(operations == "/") {
					result = firstNum / secondNum;
					answer = String.format("%f", result);
					textField.setText(answer);
				}
			}
		});
		btnEquals.setBounds(250, 254, 50, 111);
		calcPanel.add(btnEquals);
		
		JButton btnDot = new JButton(".");
		btnDot.setBounds(130, 315, 50, 50);
		calcPanel.add(btnDot);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "+";
			}
		});
		btnAdd.setBounds(190, 315, 50, 50);
		calcPanel.add(btnAdd);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "-";
			}
		});
		btnSub.setBounds(190, 254, 50, 50);
		calcPanel.add(btnSub);
		
		JButton btnMult = new JButton("*");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "*";
			}
		});
		btnMult.setBounds(190, 193, 50, 50);
		calcPanel.add(btnMult);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "/";
			}
		});
		btnDiv.setBounds(190, 132, 50, 50);
		calcPanel.add(btnDiv);
		
		JButton btnSqrt = new JButton("\u221A");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.sqrt(tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnSqrt.setBounds(250, 71, 50, 50);
		calcPanel.add(btnSqrt);
		
		JButton btnRMod = new JButton("%");
		btnRMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "%";
			}
		});
		btnRMod.setBounds(250, 132, 50, 50);
		calcPanel.add(btnRMod);
		
		JButton btnPlusMinus = new JButton("\u00B1");
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = tmp * (-1);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnPlusMinus.setBounds(190, 71, 50, 50);
		calcPanel.add(btnPlusMinus);
		
		JButton btnOneOver = new JButton("\u215F");
		btnOneOver.setBounds(250, 193, 50, 50);
		calcPanel.add(btnOneOver);
		
		JButton btnCE = new JButton("CE");
		btnCE.setBounds(70, 71, 50, 50);
		calcPanel.add(btnCE);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(130, 71, 50, 50);
		calcPanel.add(btnC);
		
		JButton btnMod = new JButton("Mod");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "Mod";
			}
		});
		btnMod.setBounds(318, 71, 64, 50);
		calcPanel.add(btnMod);
		
		JButton btnLn = new JButton("ln");
		btnLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.log(tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnLn.setBounds(466, 254, 64, 50);
		calcPanel.add(btnLn);
		
		JButton btnFact = new JButton("x!");
		btnFact.setBounds(540, 254, 64, 50);
		calcPanel.add(btnFact);
		
		JButton btnPiTwo = new JButton("2*\u03C0");
		btnPiTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = (3.141592653589793238462643383279502884197169) * 2;
				textField.setText(String.valueOf(tmp));
			}
		});
		btnPiTwo.setBounds(540, 193, 64, 50);
		calcPanel.add(btnPiTwo);
		
		JButton btnOctal = new JButton("Octal");
		btnOctal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dec = Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(dec, 8));
			}
		});
		btnOctal.setBounds(540, 315, 64, 50);
		calcPanel.add(btnOctal);
		
		JButton btnSinh = new JButton("Sinh");
		btnSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.sinh(tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnSinh.setBounds(466, 71, 64, 50);
		calcPanel.add(btnSinh);
		
		JButton btnCosh = new JButton("Cosh");
		btnCosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.cosh(tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnCosh.setBounds(466, 132, 64, 50);
		calcPanel.add(btnCosh);
		
		JButton btnTanh = new JButton("Tanh");
		btnTanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.tanh(tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnTanh.setBounds(466, 193, 64, 50);
		calcPanel.add(btnTanh);
		
		JButton btnTenPower = new JButton("10^x");
		btnTenPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.pow(10, tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnTenPower.setBounds(540, 132, 64, 50);
		calcPanel.add(btnTenPower);
		
		JButton btnHex = new JButton("Hex");
		btnHex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dec = Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(dec, 16));
			}
		});
		btnHex.setBounds(466, 315, 64, 50);
		calcPanel.add(btnHex);
		
		JButton btnSin = new JButton("Sin");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.sin(tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnSin.setBounds(392, 71, 64, 50);
		calcPanel.add(btnSin);
		
		JButton btnCos = new JButton("Cos");
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.cos(tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnCos.setBounds(392, 132, 64, 50);
		calcPanel.add(btnCos);
		
		JButton btnTan = new JButton("Tan");
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.tan(tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnTan.setBounds(392, 193, 64, 50);
		calcPanel.add(btnTan);
		
		JButton btnExp = new JButton("e^x");
		btnExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "exp";
			}
		});
		btnExp.setBounds(392, 254, 64, 50);
		calcPanel.add(btnExp);
		
		JButton btnBin = new JButton("Bin");
		btnBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dec = Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(dec, 2));
			}
		});
		btnBin.setBounds(392, 315, 64, 50);
		calcPanel.add(btnBin);
		
		JButton btnLog = new JButton("Log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.log10(tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnLog.setBounds(540, 71, 64, 50);
		calcPanel.add(btnLog);
		
		JButton btnPI = new JButton("\u03C0");
		btnPI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = 3.141592653589793238462643383279502884197169;
				textField.setText(String.valueOf(tmp));
			}
		});
		btnPI.setBounds(318, 132, 64, 50);
		calcPanel.add(btnPI);
		
		JButton btnXtoY = new JButton("x^y");
		btnXtoY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.pow(tmp, tmp);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnXtoY.setBounds(318, 193, 64, 50);
		calcPanel.add(btnXtoY);
		
		JButton btnSecondPower = new JButton("x^2");
		btnSecondPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.pow(tmp, 2);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnSecondPower.setBounds(318, 254, 64, 50);
		calcPanel.add(btnSecondPower);
		
		JButton btnThirdPower = new JButton("x^3");
		btnThirdPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmp = Double.parseDouble(String.valueOf(textField.getText()));
				tmp = Math.pow(tmp, 3);
				textField.setText(String.valueOf(tmp));
			}
		});
		btnThirdPower.setBounds(318, 315, 64, 50);
		calcPanel.add(btnThirdPower);
	}
}
