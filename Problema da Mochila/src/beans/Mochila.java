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
	
	public static int knapsack(int val[], int wt[], int W) {
       int N = wt.length; 
       int[][] V = new int[N + 1][W + 1]; 
       for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item=1;item<=N;item++){
            for (int weight=1;weight<=W;weight++){
                if (wt[item-1]<=weight)
                    V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);
                else 
                    V[item][weight]=V[item-1][weight];
            }
        }
        //imprimir a matriz 
        for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        return V[N][W];
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
		/*
		while (mochila.getPesoAtual() < mochila.getPesoMax()){
			mochila.insereObj(objetos.get(i));
			i++;
		}
		*/
	}
}
