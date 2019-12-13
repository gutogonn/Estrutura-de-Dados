package EstruturaDeDados;

public class Elemento {
	
	//atributos
	public int valor;
	public Object objeto;
	public Elemento proximo;
	public Elemento anterior;
	
	//construtor
	public Elemento(Object objeto, int v){
		this.valor = v;
		this.objeto = objeto;
		this.proximo = null;
		this.anterior = null;
	}
	
	public Elemento(int v){
		this.valor = v;
		this.proximo = null;
	}
}
