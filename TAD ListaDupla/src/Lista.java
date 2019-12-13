public class Lista {
	private Elemento inicio, fim, atual;
	private int tamanho = 0;
	
	//construtor
	public Lista(){
		inicio = fim = atual = null;
	}
	
	//retorna se a fila esta vazia
	public boolean estaVazia(){
		return inicio == null && fim == null;
	}
	
	public void inserirInicio(int v) {
		Elemento novo = new Elemento(v);
		if(estaVazia()) {
			inicio = fim = novo;
		}
		else{
			inicio.anterior = novo;
			novo.proximo = inicio;
			inicio = novo;
		} 
		tamanho++;
	}
	
	public void inserirMeio(int a, int v) {
		Elemento novo = new Elemento(v);
		if(estaVazia()) {
			inicio = fim = novo;
		}
		else {
			atual = buscarElemento(a);
			novo.anterior = atual;
			novo.proximo = atual.proximo;
			atual.proximo.anterior = novo;
		}
		tamanho++;
	}
	
	public void inserirFim(int v){
		Elemento novo = new Elemento(v);
		if(estaVazia()) {
			inicio = fim = novo;
		}
		else{
			fim.proximo = novo;
			novo.anterior = fim;
			fim = novo;
		} 
		tamanho++;
	}
	
	//retira um elemento do inicio da lista e retorna seu valor
	public int retirarInicio(){
		int retVal = inicio.valor;
		if(inicio.proximo != null) {
			inicio = inicio.proximo;
			inicio.anterior = null;
		}else {
			inicio = null;
			fim = null;
		}
		tamanho--;
		return retVal;
	} 
	
	//retira um elemento do meio da lista e retorna seu valor
	public int retirarMeio(int a){
		atual = buscarElemento(a);
		int retVal = atual.valor;
		if(atual != null) {
			atual.proximo.anterior = atual.anterior;
			atual.anterior.proximo = atual.proximo;
		}
		tamanho--;
		return retVal;
	} 
	
	//retira um elemento do inicio da lista e retorna seu valor
	public int retirarFim(){
		int retVal = fim.valor;
		if(fim != null) {
			atual = inicio;
			while(atual.proximo != fim) {
				atual = atual.proximo;			
			}
			
			fim = atual;
			fim.proximo = null;
		}
		tamanho--;
		return retVal;
	} 
	
	//buscar elemento
	public Elemento buscarElemento(int v) {
		Elemento aux = inicio;
		if(!estaVazia()) {
			while(aux.valor != v) {
				aux = aux.proximo;
			}
		}
		return aux;
	}
	
	//exibe o tamanho da fila
	public int tamanho() {
		return tamanho - 1;
	}
	
	//exibe o elemneto da frente da fila
	public int frente() {
		return inicio.valor;
	}

	public String listar() {
		String t = "";
		atual = inicio;
		while(atual != fim.proximo) {
			t +=  atual.valor + ", ";
			atual = atual.proximo;
		}
		return t;
	}
	
}
