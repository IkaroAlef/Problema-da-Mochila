package beans;

import java.util.concurrent.atomic.AtomicInteger;

public class Objeto {
	private int id ;
	private double valor;
	private static AtomicInteger count = new AtomicInteger (0); //serve para auto-incrementar o id.
	private double peso;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public Objeto(double peso, double valor){
			this.setId(count.incrementAndGet());
			this.setPeso(peso);
			this.setValor(valor);
	}

	/*public Objeto(int id, double peso) throws Exception{
		if (id > 0 && peso > 0){
			this.setId(id);
			this.setPeso(peso);
		}
		else throw new Exception();
	}*/
}
