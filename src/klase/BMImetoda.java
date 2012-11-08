package klase;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class BMImetoda {
	

	double izracunajBMI (double visina, double tezina){
		if ((visina < 1.2)||(visina > 2.4)) {
			JOptionPane.showMessageDialog(null, "Greska: visina je van granica 1.2-2.4 m");
		return 0;
		}
		if ((tezina < 30)||(tezina > 200)) {
			JOptionPane.showMessageDialog(null,"Greska: tezina je van granica 30-200 kg");
		return 0;
		}
		double rezultat = (tezina / (visina*visina));
		DecimalFormat df = new DecimalFormat("0.000");
		return Double.parseDouble(df.format(rezultat));
		}
	
		void ispisiBMIKategoriju (double bmi){
				
		if (bmi <= 15 && bmi > 0)
			JOptionPane.showMessageDialog(null,"Vas BMI je: "+bmi+"\n vi pripadate grupi: anoreksicni");
		if ((bmi > 15)&&(bmi <= 18.5))
			JOptionPane.showMessageDialog(null,"Vas BMI je: "+bmi+"\n vi pripadate grupi: mrsavi");
		if ((bmi > 18.5)&&(bmi <= 25))
			JOptionPane.showMessageDialog(null,"Vas BMI je: "+bmi+"\n vi pripadate grupi: normalni");
		if ((bmi > 25)&&(bmi <= 30))
			JOptionPane.showMessageDialog(null,"Vas BMI je: "+bmi+"\n vi pripadate grupi: popunjeni");
		if ((bmi > 30)&&(bmi <= 40))
			JOptionPane.showMessageDialog(null,"Vas BMI je: "+bmi+"\n vi pripadate grupi: debeli");
		if (bmi > 40)
			JOptionPane.showMessageDialog(null,"Vas BMI je: "+bmi+"\n vi pripadate grupi: gojazni");
}
	
		
		}
