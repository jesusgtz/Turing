package turing;

import javax.swing.JOptionPane;

/**
 * 
 * @author jesusgtz
 *
 */
public class Turing {
	
	//Atributos
	String cinta;
	int cabezal;
	Estados actual;
	
	/**
	 * Contructor
	 * @param cinta
	 */
	public Turing(String cinta) {
		this.cinta = cinta;
		this.cabezal = 1;
		this.actual = Estados.e0;
	}
	
	/**
	 * Funcion para realizar la operacion de suma
	 */
	public void suma() {
		while(this.actual != Estados.ef) {
			if(this.actual == Estados.e0 && 
			   this.cinta.charAt(this.cabezal) == '1') {
					this.cabezal++;
			}
			if(this.actual == Estados.e0 && 
			   this.cinta.charAt(this.cabezal) == '+') {
					this.cinta = this.cinta.substring(0,this.cabezal) + '1' 
							+ this.cinta.substring(this.cabezal+1);
					this.cabezal++;
			}
			if(this.actual == Estados.e0 && 
			   this.cinta.charAt(this.cabezal) == 'b') {
					this.actual = Estados.e1;
					this.cabezal--;
			}
			if(this.actual == Estados.e1 && 
			   this.cinta.charAt(this.cabezal) == '1') {
					this.actual = Estados.ef;
					this.cinta = this.cinta.substring(0,this.cabezal) + 'b' 
							+ this.cinta.substring(this.cabezal+1);
			}
		}
	}
	
	/**
	 * Funcion para imprimir el contenido de la cinta
	 */
	public void imprimirCinta() {
		JOptionPane.showMessageDialog(null,this.cinta,"Cinta",2);
	}
	
	/**
	 * Funcion main
	 * @param args
	 */
	public static void main(String[] args) {
		String tmp = JOptionPane.showInputDialog(null,
				"Escribe el contenido de la cinta:\n","Captura",3);
		Turing t = new Turing(tmp);
		t.suma();
		t.imprimirCinta();
	}

}
