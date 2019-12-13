public class Fila {
	private Elemento inicio, fim;
	private int tamanho;
	
	//construtor
	public Fila(){
		inicio = fim = null;
	}
	
	//retorna se a fila esta vazia
	public boolean estaVazia(){
		return inicio == null && fim == null;
	} 
	
	//insere na fila
	public void empilha(int v){
		Elemento novo = new Elemento(v);
		if(estaVazia()) {
			inicio = fim = novo;
		}
		else{
			fim.proximo = novo;
			fim = novo;
		} 
		tamanho++;
	}
	
	//retira um elemento do topo da fila e retorna seu valor
	public int desempilha(){
		int retVal = inicio.valor;
		if(inicio.proximo != null) {
			inicio = inicio.proximo;
		}else {
			inicio = null;
			fim = null;
		}
		tamanho--;
		return retVal;
	} 
	
	//exibe o tamanho da fila
	public int tamanho() {
		return tamanho;
	}
	
	//exibe o elemneto da frente da fila
	public int frente() {
		return inicio.valor;
	}


}
