package klase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class BMIKalkulator {

	private JFrame frmKalkulator;
	private JTextField textFieldIme;
	private JTextField textFieldPrezime;
	private JTextField textFieldTezina;
	private JTextField textFieldVisina;
	private JButton btnNewButton;
	private JButton btnSacuvaj;
	private JButton btnIstorija;
	private JDialog dlgDialog;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmUputstvo;
	private JMenuItem mntmIzlaz;
	private JButton btnReset;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMIKalkulator window = new BMIKalkulator();
					window.frmKalkulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BMIKalkulator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKalkulator = new JFrame();
		frmKalkulator.getContentPane().setBackground(new Color(255, 140, 0));
		frmKalkulator.setTitle("Kalkulator");
		frmKalkulator.setBounds(100, 100, 450, 300);
		frmKalkulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{21, 21, 80, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmKalkulator.getContentPane().setLayout(gridBagLayout);
		
		btnNewButton = new JButton("Izracunaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BMImetoda b = new BMImetoda();
				
				boolean popunjeno = true;
				
				
					if(textFieldIme.getText().equals("")){
						popunjeno = false;
						JOptionPane.showMessageDialog(null, "Niste uneli ime");
					}
					
					if(textFieldVisina.getText().equals("")){
							popunjeno = false;
							JOptionPane.showMessageDialog(null,"Niste uneli visinu");
					
						}
		
				if(textFieldPrezime.getText().equals("")){
					popunjeno = false;
					JOptionPane.showMessageDialog(null,"Niste uneli prezime");
				}
				if(textFieldTezina.getText().equals("")){
					popunjeno = false;
					JOptionPane.showMessageDialog(null,"Niste uneli tezinu");
				}
				
				if(popunjeno !=false){
				try {
				 double tezina = Double.parseDouble(textFieldTezina.getText());
				double visina = Double.parseDouble(textFieldVisina.getText());	
				double bmi = b.izracunajBMI(visina, tezina);
				if(bmi == 0)
					JOptionPane.showMessageDialog(null,"Tezina i visina su van granica, BMI ne moze biti izracunat!");
				b.ispisiBMIKategoriju(bmi);
				btnSacuvaj.setVisible(true);
				btnIstorija.setVisible(true);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"Tezina i visina moraju biti brojevi!");
				}
				
				}
		}});
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblIme = new GridBagConstraints();
		gbc_lblIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblIme.gridx = 0;
		gbc_lblIme.gridy = 2;
		frmKalkulator.getContentPane().add(lblIme, gbc_lblIme);
		
		textFieldIme = new JTextField();
		textFieldIme.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldIme.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_textFieldIme = new GridBagConstraints();
		gbc_textFieldIme.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIme.gridx = 2;
		gbc_textFieldIme.gridy = 2;
		frmKalkulator.getContentPane().add(textFieldIme, gbc_textFieldIme);
		textFieldIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
		gbc_lblPrezime.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezime.gridx = 0;
		gbc_lblPrezime.gridy = 3;
		frmKalkulator.getContentPane().add(lblPrezime, gbc_lblPrezime);
		
		textFieldPrezime = new JTextField();
		textFieldPrezime.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPrezime.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_textFieldPrezime = new GridBagConstraints();
		gbc_textFieldPrezime.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrezime.gridx = 2;
		gbc_textFieldPrezime.gridy = 3;
		frmKalkulator.getContentPane().add(textFieldPrezime, gbc_textFieldPrezime);
		textFieldPrezime.setColumns(10);
		
		JLabel lblTezina = new JLabel("Tezina");
		lblTezina.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblTezina = new GridBagConstraints();
		gbc_lblTezina.insets = new Insets(0, 0, 5, 5);
		gbc_lblTezina.gridx = 0;
		gbc_lblTezina.gridy = 4;
		frmKalkulator.getContentPane().add(lblTezina, gbc_lblTezina);
		
		textFieldTezina = new JTextField();
		textFieldTezina.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTezina.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_textFieldTezina = new GridBagConstraints();
		gbc_textFieldTezina.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTezina.gridx = 2;
		gbc_textFieldTezina.gridy = 4;
		frmKalkulator.getContentPane().add(textFieldTezina, gbc_textFieldTezina);
		textFieldTezina.setColumns(10);
		
		JLabel lblVisina = new JLabel("Visina");
		lblVisina.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblVisina = new GridBagConstraints();
		gbc_lblVisina.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisina.gridx = 0;
		gbc_lblVisina.gridy = 5;
		frmKalkulator.getContentPane().add(lblVisina, gbc_lblVisina);
		
		textFieldVisina = new JTextField();
		textFieldVisina.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldVisina.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_textFieldVisina = new GridBagConstraints();
		gbc_textFieldVisina.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldVisina.gridx = 2;
		gbc_textFieldVisina.gridy = 5;
		frmKalkulator.getContentPane().add(textFieldVisina, gbc_textFieldVisina);
		textFieldVisina.setColumns(10);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		frmKalkulator.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					GregorianCalendar k = new GregorianCalendar();
					PrintWriter out = new PrintWriter(
					new BufferedWriter(new FileWriter("Istorija.txt", true)));
					out.println("\n" +textFieldIme.getText()+ " " + textFieldPrezime.getText());
					out.println("Tezina: " + textFieldTezina.getText() +" Visina: "+textFieldVisina.getText());
					out.println("Datum upita: " + k.get(GregorianCalendar.DAY_OF_MONTH) + "." + k.get(GregorianCalendar.MONTH)+"."+ k.get(GregorianCalendar.YEAR));
					out.close();
					}catch(Exception e1)
					{
					System.out.println("Greska: "+e1.getMessage());
					}
			}
		});
		btnSacuvaj.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSacuvaj.setVisible(false);
		GridBagConstraints gbc_btnSacuvaj = new GridBagConstraints();
		gbc_btnSacuvaj.insets = new Insets(0, 0, 5, 5);
		gbc_btnSacuvaj.gridx = 0;
		gbc_btnSacuvaj.gridy = 7;
		frmKalkulator.getContentPane().add(btnSacuvaj, gbc_btnSacuvaj);
		
		btnIstorija = new JButton("Istorija");
		btnIstorija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					  Runtime.getRuntime().exec("notepad Istorija.txt");
				}
		        catch(IOException ex){
					        ex.printStackTrace();
					        }

			}
		});
		btnIstorija.setHorizontalAlignment(SwingConstants.LEFT);
		btnIstorija.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_btnIstorija = new GridBagConstraints();
		gbc_btnIstorija.insets = new Insets(0, 0, 5, 0);
		gbc_btnIstorija.gridx = 2;
		gbc_btnIstorija.gridy = 7;
		frmKalkulator.getContentPane().add(btnIstorija, gbc_btnIstorija);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSacuvaj.setVisible(false);
				textFieldIme.setText("");
				textFieldPrezime.setText("");
				textFieldTezina.setText("");
				textFieldVisina.setText("");
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 1;
		gbc_btnReset.gridy = 8;
		frmKalkulator.getContentPane().add(btnReset, gbc_btnReset);
		
		menuBar = new JMenuBar();
		frmKalkulator.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmUputstvo = new JMenuItem("Uputstvo");
		mntmUputstvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Potrebno je uneti tezinu i visinu, bez slova, kao i ime i prezime.\nTakodje je moguce sacuvati rezultat i podatke sa datumom, \nradi kasnijeg pregleda ");
			}
		});
		mnFile.add(mntmUputstvo);
		
		mntmIzlaz = new JMenuItem("Izlaz");
		mntmIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmIzlaz);
	}

}
