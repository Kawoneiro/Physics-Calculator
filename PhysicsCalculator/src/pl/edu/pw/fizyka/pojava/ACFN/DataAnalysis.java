package pl.edu.pw.fizyka.pojava.ACFN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class DataAnalysis {

	JFrame daFrame, helpframe;
	JMenuBar file;
	JMenu menu,help;
	JMenuItem open, exam;
	JPanel panel1, panel2, panel3, panel4, panel5, panel6, panelsr, panelod, paneltrend, paneltrend2;
	JButton xy, trendrys, trendclear;
	Border linia;
	TitledBorder tytul,tytul2, tytul3;
	XYSeriesCollection xydataset;
	XYSeriesCollection trenddataset = new XYSeriesCollection();
	XYSeries xyseries= new XYSeries("XYGraph");
	XYSeries liniowytrend = new XYSeries("");
	List<Double> xData;
	List<Double> yData;
	JLabel srlabel, odlabel, trendtext;
	JComboBox<String> typytrendu;
	String[] trendy = new String[] {"Liniowy ( y = ax + b )", "Logarytmiczny", "Wyk³adniczy", "Potêgowy", "Wielomianowy st.2"};
	Double a,b,x2,y2,x3;
	DecimalFormat df = new DecimalFormat("#.##");
	/**
	 * Launch the application.
	 */
	public void dAnalysis() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataAnalysis window = new DataAnalysis();
					window.daFrame.setLocationRelativeTo(null);
					window.daFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataAnalysis() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Panels
			panel1 = new JPanel();
			panel2 = new JPanel();
			panel3 = new JPanel();
			panel4 = new JPanel();
			panel5 = new JPanel();
			panel6 = new JPanel();
			panelsr = new JPanel();
			panelod = new JPanel();
			paneltrend = new JPanel();
			paneltrend2 = new JPanel();
					
			panel1.setPreferredSize(new Dimension(300,75));
			panel2.setPreferredSize(new Dimension(700,400));
			panel3.setPreferredSize(new Dimension(300,400));
			panel4.setPreferredSize(new Dimension(1000,50));
			panel5.setPreferredSize(new Dimension(700,75));
			panel6.setPreferredSize(new Dimension(1000,75));
					
			panel1.setLayout(new FlowLayout());
			panel3.setLayout(new GridLayout(2,1));
			panel4.setLayout(new BorderLayout());
			panel5.setLayout(new GridLayout(1,2));
			panel6.setLayout(new BorderLayout(7,0));
			paneltrend2.setLayout(new BorderLayout());
			
		//Borders
			linia = BorderFactory.createLineBorder(Color.BLUE);
			tytul = BorderFactory.createTitledBorder(linia); 
			tytul2 = BorderFactory.createTitledBorder(linia,"Wykres"); 
			tytul3 = BorderFactory.createTitledBorder(linia,"Wartoœci danych"); 
			
			panel1.setBorder(tytul);
			panel2.setBorder(tytul2);
			panel3.setBorder(tytul3);
			panel5.setBorder(tytul);
						
		//Data Analysis Frame
			daFrame = new JFrame("Analiza danych z pliku");
			daFrame.setResizable(false);
			daFrame.setBounds(100, 100, 1000, 600);
			daFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			daFrame.getContentPane().setLayout(new BorderLayout());
			
		//Buttons
			ListenForButtons listenforbuttons = new ListenForButtons();
			xy = new JButton("Stwórz wykres");
			xy.setPreferredSize(new Dimension(250,62));
			xy.addActionListener(listenforbuttons);
			panel1.add(xy);
		
			JButton btnBackToMenu = new JButton("Powr\u00F3t do menu");
			btnBackToMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					daFrame.setVisible(false);
					MainMenuFrame.main(null);
				}
			});
			btnBackToMenu.setPreferredSize(new Dimension(183,34));
			panel4.add(btnBackToMenu,BorderLayout.EAST);
		
		//Trend line
			trendtext = new JLabel("Wybierz typ linii trendu:");
			trendtext.setHorizontalAlignment(SwingConstants.CENTER);
			trendtext.setVerticalAlignment(SwingConstants.CENTER);
			
			trendrys = new JButton("Rysuj");
			trendclear = new JButton("Usuñ");
			typytrendu = new JComboBox<>(trendy);
			
			ActionListener trendakcje = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					String tr = (String) typytrendu.getSelectedItem();
					
					switch (tr){
						case "Liniowy ( y = ax + b )":
							a = (sumailoczynow() - (getxData().size()*xsrednia()*ysrednia()))/(kwadratx()-(getxData().size()*xsrednia()*xsrednia()));
							b = (ysrednia() - (a*xsrednia()));
							Double ylin = (double) 0;
							getXydataset().removeSeries(liniowytrend);

							
							for(int i = 0; i < getxData().size(); i++) {
								Double xlin = getxData().get(i);
								ylin = (a*xlin)+b;
								liniowytrend.add(xlin, ylin);
								paneltrend2.removeAll();
								daFrame.revalidate();
								daFrame.repaint();
							}
								trendrys.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										try {
										getXydataset().addSeries(liniowytrend);
										
										JLabel text = new JLabel("<html>Wspó³czynniki linii trendu:<br/><br/>" + "<div align=\"center\">" + " a = " + String.valueOf(df.format(a)) + "  &nbsp;&nbsp;  " + " b = " + String.valueOf(df.format(b)) + "</div>" +" </html>");
										text.setHorizontalAlignment(SwingConstants.CENTER);
										text.setVerticalAlignment(SwingConstants.CENTER);
										
										
										paneltrend2.add(text,BorderLayout.CENTER);
										daFrame.revalidate();
										daFrame.repaint();
										
										}
										catch(IllegalArgumentException x) {
											
										}
									}
								});
								
								trendclear.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										getXydataset().removeSeries(liniowytrend);
										
										paneltrend2.removeAll();
										daFrame.revalidate();
										daFrame.repaint();
									}
								});
								
							break;
							
						case "Logarytmiczny":
							paneltrend2.removeAll();
							daFrame.revalidate();
							daFrame.repaint();
							getXydataset().removeSeries(liniowytrend);
							
							trendrys.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
								}
							});
							break;
							
						case "Wyk³adniczy":
							paneltrend2.removeAll();
							daFrame.revalidate();
							daFrame.repaint();
							getXydataset().removeSeries(liniowytrend);
							
							trendrys.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
								}
							});
							break;
							
						case "Potêgowy":
							paneltrend2.removeAll();
							daFrame.revalidate();
							daFrame.repaint();
							getXydataset().removeSeries(liniowytrend);
							
							trendrys.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
								}
							});
							break;
							
						case "Wielomianowy st.2":
							paneltrend2.removeAll();
							daFrame.revalidate();
							daFrame.repaint();
							getXydataset().removeSeries(liniowytrend);
							
							trendrys.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
								}
							});
							break;
						
						
					}
				}
				
			};
			
			typytrendu.addActionListener(trendakcje);
			
			paneltrend.add(trendtext);
			paneltrend.add(typytrendu);
			paneltrend.add(trendrys);
			paneltrend.add(trendclear);
			
			panel5.add(paneltrend);
			panel5.add(paneltrend2);
			
		//Equations
			srlabel = new JLabel();
			srlabel.setHorizontalAlignment(SwingConstants.CENTER);
			srlabel.setVerticalAlignment(SwingConstants.CENTER);
			panel3.add(srlabel);
			
			odlabel = new JLabel();
			odlabel.setHorizontalAlignment(SwingConstants.CENTER);
			odlabel.setVerticalAlignment(SwingConstants.CENTER);
			panel3.add(odlabel);
			
			panel6.add(panel1,BorderLayout.LINE_START);
			panel6.add(panel5,BorderLayout.CENTER);
			daFrame.add(panel2,BorderLayout.CENTER);
			daFrame.add(panel3,BorderLayout.LINE_END);
			daFrame.add(panel4,BorderLayout.PAGE_END);
			daFrame.add(panel6,BorderLayout.PAGE_START);
			Menu();
	}
	//Create menu
	private void Menu(){
		menu = new JMenu("Menu");
		file = new JMenuBar();
		
		ListenForMenu lForMenu = new ListenForMenu(srlabel, odlabel);

		open = new JMenuItem("Otworz plik");
		open.addActionListener(lForMenu);
		menu.add(open);
		
		menu.addSeparator();
		
		help = new JMenu("Pomoc");
		exam = new JMenuItem("Przyklad obs³ugiwanego pliku do wykresu typu XY");
		exam.addActionListener(lForMenu);
		help.add(exam);
		menu.add(help);
		
		file.add(menu);
		file.add(new JLabel("     "));
		file.add(new JLabel("Aby rozpocz¹æ pracê z programem kliknij Menu po lewej stronie"));
		daFrame.setJMenuBar(file);
	}
	
	//Menu listeners
	private class ListenForMenu implements ActionListener {		
		JLabel kopia,kopia2;
		public ListenForMenu(JLabel copy, JLabel copy2) {
			super();
			kopia = copy;
			kopia2 = copy2;
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == open) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
				chooser.setFileFilter(new FileNameExtensionFilter("Pliki tekstowe", "txt"));
				int result = chooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File plik = chooser.getSelectedFile();
					xyScan(plik);
					System.out.println(plik.getPath());
					
					
					String yavg = String.valueOf(ysrednia());
					String xavg = String.valueOf(xsrednia());
					yavg = df.format(ysrednia());
					xavg = df.format(xsrednia());
					kopia.setText("<html>Œrednia arytmetyczna danych z pliku wynosi: <br/> <br/>" + "<div align=\"center\">" + "Oœ X:" + xavg + "  &nbsp;&nbsp;&nbsp;&nbsp;  " + "Oœ Y:" + yavg + "</div>" +" </html>");
					String ydif = String.valueOf(yodchyl());
					String xdif = String.valueOf(xodchyl());
					ydif = df.format(yodchyl());
					xdif = df.format(xodchyl());
					kopia2.setText("<html>Odchylenie standardowe danych z pliku wynosi: <br/> <br/>" + "<div align=\"center\">" + "Oœ X:" + xdif + "  &nbsp;&nbsp;&nbsp;&nbsp;  " + "Oœ Y:" + ydif + "</div>" +" </html>");
				
				}
			}
					
			else if(e.getSource() == exam) {
				helpframe = new JFrame();
				helpframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				helpframe.setBounds(100, 100, 300, 450);
				helpframe.setVisible(true);
				helpframe.setTitle("Pomoc");
				helpframe.setResizable(false);
				
				JPanel tekst, obraz;
				tekst = new JPanel();
				obraz = new JPanel();
				helpframe.setLayout(new BorderLayout());
				helpframe.add(tekst,BorderLayout.PAGE_START);
				helpframe.add(obraz,BorderLayout.CENTER);
				
				JTextArea helptext = new JTextArea();
				helptext.setBorder(linia);
				helptext.setEditable(false);
				helptext.setText("Aby program poprawnie wykona³ wykres XY\nnale¿y u¿yæ pliku tekstowego\nnapisanego w formacie:\nNumber1, Space, Number2, Enter \n\nPrzyk³ad takiego pliku:");
				helptext.setFont(new Font("Serif",Font.PLAIN, 16));
				tekst.add(helptext);
				
				BufferedImage myPicture = null;
				try {
					myPicture = ImageIO.read(new File("C:\\Users\\fnowa\\Desktop\\Java\\PhysicsCalculator\\src\\pl\\edu\\pw\\fizyka\\pojava\\ACFN\\helpdane.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				obraz.add(picLabel);	
			}
			
			else {
				System.exit(0);
			}
		}
	}
	//Buttons listeners
	private class ListenForButtons implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == xy) {
				
				try {
					xyChart(panel2);
					
				}
				catch(NullPointerException f) {
					JFrame blad = new JFrame("B£¥D");
					blad.setLocationRelativeTo(null);
					blad.setSize(300,100);
					blad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					blad.setAlwaysOnTop(true);
					blad.setResizable(false);
					JLabel bladlabel = new JLabel("Aby stworzyæ wykres musisz wczytaæ dane!");
					bladlabel.setHorizontalAlignment(JLabel.CENTER);
					blad.add(bladlabel);
					blad.setVisible(true);
				}
				
			}
			else {
				System.exit(0);
			}
		}

}
	//XY Chart generation
	public void xyChart(JPanel xypanel) {
			xyseries = new XYSeries("XYGraph");			
		    
		    for (int i=0; i<getxData().size(); i++) {
		         Double x = getxData().get(i);
		         Double y = getyData().get(i);
		         xyseries.add(x,y);
		    }
		    
		    xydataset = new XYSeriesCollection(); 
		    xydataset.addSeries(xyseries);
			
			JFreeChart xychart = ChartFactory.createXYLineChart(
				"Y = F(X)",//Tytul
				"X", // opisy osi
				"Y", 
				xydataset, // Dane 
				PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
				false, // legenda
				false, // tooltips
				true
			);
			
		    ChartPanel xychartt = new ChartPanel(xychart);
		   	xypanel.setLayout(new BorderLayout());
			xypanel.add(xychartt,BorderLayout.CENTER);
			xypanel.validate();
			xypanel.setVisible(true);
			daFrame.revalidate();
			}	
	
	//X Y values scanning
	public void xyScan(File kopia) {
		xData = new ArrayList<Double>();
		yData = new ArrayList<Double>();
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(kopia);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		xData.clear();
		yData.clear();
		
		paneltrend2.removeAll();
		panel2.removeAll();
		daFrame.revalidate();
		daFrame.repaint();
		
		try {
			while(scanner.hasNext()) {
				getxData().add(scanner.nextDouble());
				getyData().add(scanner.nextDouble());
			}
		}
		catch(InputMismatchException e) {
			JFrame blad = new JFrame("B£¥D");
			blad.setLocationRelativeTo(null);
			blad.setSize(300,100);
			blad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			blad.setAlwaysOnTop(true);
			blad.setResizable(false);
			JLabel bladlabel = new JLabel("Plik zawiera dane w z³ym formacie");
			bladlabel.setHorizontalAlignment(JLabel.CENTER);
			blad.add(bladlabel);
			blad.setVisible(true);
			panel3.removeAll();
			daFrame.revalidate();
			//daFrame.repaint();
		}
		
	}
	
	//Average value
	public double ysrednia() {
		double suma = 0.0;
		double ysrednia = 0.0;
		
		for(int i = 0; i <= yData.size()-1; i++) {
			suma += yData.get(i);
		}
		ysrednia = suma/(yData.size());
				
		return ysrednia;
	}
	
	public double xsrednia() {
		double suma = 0.0;
		double xsrednia = 0.0;
		
		for(int i = 0; i <= xData.size()-1; i++) {
			suma += xData.get(i);
		}
		xsrednia = suma/(xData.size());
				
		return xsrednia;
	}
	
	//Standard Deviation
	public double yodchyl() {
		double ysrednia = ysrednia();
		double temp = 0;
		for(int i = 0; i <= yData.size()-1; i++) {
			Double val = yData.get(i);

	        // Step 2:
	        double squrDiffToMean = Math.pow(val - ysrednia, 2);

	        // Step 3:
	        temp += squrDiffToMean;
		}
		
		double meanOfDiffs = (double) temp / (double) (yData.size());

	    // Step 5:
	    return Math.sqrt(meanOfDiffs);
	}
	
	public double xodchyl() {
		double xsrednia = xsrednia();
		double temp = 0;
		for(int i = 0; i <= xData.size()-1; i++) {
			Double val = xData.get(i);

	        // Step 2:
	        double squrDiffToMean = Math.pow(val - xsrednia, 2);

	        // Step 3:
	        temp += squrDiffToMean;
		}
		
		double meanOfDiffs = (double) temp / (double) (xData.size());

	    // Step 5:
	    return Math.sqrt(meanOfDiffs);
	}
	
	public double sumailoczynow() {
		double sumailoczynow = 0;
		
		for(int i = 0; i <= xData.size()-1; i++) {
			x2 = xData.get(i);
			y2 = yData.get(i);
	
			sumailoczynow += x2*y2;
		}
		return sumailoczynow;
	}
	
	public double kwadratx() {
		double kwx = 0;
		
		for(int i = 0; i <= xData.size()-1; i++) {
			x3 = xData.get(i);
			kwx += x3*x3;
		}
		return kwx;
	}
	
	//Setters and getters
	public List<Double> getxData() {
		return xData;
	}

	public void setxData(List<Double> xData) {
		this.xData = xData;
	}

	public List<Double> getyData() {
		return yData;
	}

	public void setyData(List<Double> yData) {
		this.yData = yData;
	}
	
	public JPanel getPanel3() {
		return panel3;
	}

	public void setPanel3(JPanel panel3) {
		this.panel3 = panel3;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JPanel getPanelsr() {
		return panelsr;
	}

	public void setPanelsr(JPanel panelsr) {
		this.panelsr = panelsr;
	}

	public JLabel getSrlabel() {
		return srlabel;
	}

	public void setSrlabel(JLabel srlabel) {
		this.srlabel = srlabel;
	}
	
	public XYSeries getXyseries() {
		return xyseries;
	}

	public void setXyseries(XYSeries xyseries) {
		this.xyseries = xyseries;
	}
	
	public XYSeriesCollection getXydataset() {
		return xydataset;
	}

	public void setXydataset(XYSeriesCollection xydataset) {
		this.xydataset = xydataset;
	}

	public XYSeries getLiniowytrend() {
		return liniowytrend;
	}

	public void setLiniowytrend(XYSeries liniowytrend) {
		this.liniowytrend = liniowytrend;
	}

}

