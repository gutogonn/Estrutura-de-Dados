package EstruturaDeDados;

public class PilhaDinamica {
	
	//atributos
	private Elemento topo = null;
		//o topo da pilha
	
	//construtor
	public PilhaDinamica(){}
	
	//retorna se a pilha esta vazia
	public boolean estaVazia(){
		return topo == null;
	}
	
	//insere na pilha
	public void empilha(int v){
		Elemento novo = new Elemento(v);
		if(topo==null) {
			topo = novo;
		}else {
			novo.proximo = topo;
			topo = novo;
		}
	}
	
	//retira um elemento do topo da pilha e retorna seu valor
	public int desempilha(){
		int retVal = topo.valor;
		topo = topo.proximo;
		return retVal;
	}
	
}
