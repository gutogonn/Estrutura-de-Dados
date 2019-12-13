package EstruturaDeDados;

public class ListaCircular 
{
	private Elemento inicio, fim, atual;
	private int tamanho = 0;
	
	//construtor
	public ListaCircular()
	{
		inicio = fim = atual = null;
	}
	
	//retorna se a fila esta vazia
	public boolean estaVazia()
	{
		return inicio == null && fim == null;
	}
	
	public void inserirInicio(Object objeto, int v) 
	{
		Elemento novo = new Elemento(objeto, v);
		if(estaVazia()) 
		{
			novo.proximo = novo;
			novo.anterior = novo;
			inicio = fim = novo;
		}
		else{
			novo.proximo = inicio;
			novo.anterior = fim;
			inicio.anterior = novo;
			inicio = novo;
			fim.proximo = inicio;
		} 
		tamanho++;
	}
	
	public void inserirMeio(Object objeto, int a, int v) 
	{
		Elemento novo = new Elemento(objeto, v);
		if(estaVazia()) 
		{
			inicio = fim = novo;
		}
		else 
		{
			atual = buscarElemento(a);
			novo.proximo = atual.proximo;
			novo.anterior = atual;
			atual.proximo = novo;
		}
		tamanho++;
	}
	
	public void inserirFim(Object objeto, int v)
	{
		Elemento novo = new Elemento(objeto, v);
		if(estaVazia()) 
		{
			novo.proximo = novo;
			novo.anterior = novo;
			inicio = fim = novo;
		}
		else
		{
			fim.proximo = novo;
			novo.anterior = fim;
			novo.proximo = inicio;
			inicio.anterior = novo;
			fim = novo;
		} 
		tamanho++;
	}
	
	//retira um elemento do inicio da lista e retorna seu valor
	public Object retirarInicio()
	{
		Object retVal = inicio.objeto;
		if(inicio.proximo != null) {
			inicio = inicio.proximo;
			inicio.anterior = fim;
			fim.proximo = inicio;
		}
		else 
		{
			inicio = null;
			fim = null;
		}
		tamanho--;
		return retVal;
	} 
	
	//retira um elemento do meio da lista e retorna seu valor
	public Object retirarMeio(int a)
	{
		atual = buscarElemento(a);
		Object retVal = atual.objeto;
		if(atual != null) 
		{
			atual.proximo.anterior = atual.anterior;
			atual.anterior.proximo = atual.proximo;
		}
		tamanho--;
		return retVal;
	} 
	
	//retira um elemento do inicio da lista e retorna seu valor
	public Object retirarFim()
	{
		Object retVal = fim.objeto;
		if(fim != null) 
		{
			atual = inicio;
			while(atual.proximo != fim) 
			{
				atual = atual.proximo;			
			}
			
			fim = atual;
			fim.proximo = inicio;
			inicio.anterior = fim;
		}
		tamanho--;
		return retVal;
	} 
	
	//buscar elemento
	public Elemento buscarElemento(int v) 
	{
		Elemento aux = inicio;
		if(!estaVazia()) 
		{
			while(aux.valor != v) 
			{
				aux = aux.proximo;
			}
		}
		return aux;
	}
	
	//exibe o tamanho da fila
	public int tamanho()
	{
		return tamanho;
	}
	
	//exibe o elemneto da frente da fila
	public Elemento retornaInicio()
	{
		return inicio;
	}
	
	public Elemento retornaFim()
	{
		return fim;
	}

	public String listar()
	{
		String t = "";
		atual = inicio;
		while(atual != fim.proximo)
		{
			t +=  atual.valor + ", ";
			atual = atual.proximo;
		}
		return t;
	}
	
}
