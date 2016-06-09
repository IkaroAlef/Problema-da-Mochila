package beans;

import java.util.ArrayList;
import java.util.Arrays;

public class Mochila {
	private ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	private double pesoMax;
	private double pesoAtual=0;
	
	public double getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}

	public double getPesoAtual() {
		return pesoAtual;
	}

	public void setPesoAtual(double pesoAtual) {
		this.pesoAtual = pesoAtual;
	}

	public Mochila(double peso){
		this.pesoMax=peso;
	}
	
	public void insereObj(Objeto obj){
		objetos.add(obj);
		//this.pesoAtual = this.pesoAtual + obj.getPeso();
	}
	
	public void removeUltimoObj(){
		objetos.remove(objetos.size()-1);
	}
	
	public static void main(String[] args) {
		Mochila mochila = new Mochila(100);
		ArrayList<Objeto> objetos = new ArrayList<Objeto>(Arrays.asList( //array com obejtos a serem inseridos
				new Objeto(10, 2),
				new Objeto(1, 6),
				new Objeto(16, 8),
				new Objeto(20, 3),
				new Objeto(50,10),
				new Objeto(2,8),
				new Objeto(15,30),
				new Objeto(34,40),
				new Objeto(11,15),
				new Objeto(5,7)));
		int i = 0;
		while (mochila.getPesoAtual() < mochila.getPesoMax()){
			mochila.insereObj(objetos.get(i));
			i++;
		}
		
	}
}
