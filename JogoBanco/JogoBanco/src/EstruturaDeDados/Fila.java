package EstruturaDeDados;

public class Fila 
{
	private Elemento inicio, fim;
	private int tamanho;
	
	//construtor
	public Fila()
	{
		inicio = fim = null;
	}
	
	//retorna se a fila esta vazia
	public boolean estaVazia()
	{
		return inicio == null && fim == null;
	} 
	
	//insere na fila
	public void empilha(Object objeto, int v)
	{
		Elemento novo = new Elemento(objeto, v);
		if(estaVazia()) 
		{
			inicio = fim = novo;
		}
		else
		{
			fim.proximo = novo;
			fim = novo;
		} 
		tamanho++;
	}
	
	//retira um elemento do topo da fila e retorna seu valor
	public Object desempilha()
	{
		Object retVal = inicio.objeto;
		if(inicio.proximo != null) 
		{
			inicio = inicio.proximo;
		}else 
		{
			inicio = null;
			fim = null;
		}
		tamanho--;
		return retVal;
	} 
	
	//exibe o tamanho da fila
	public int tamanho() 
	{
		return tamanho;
	}
	
	//exibe o elemneto da frente da fila
	public int frente()
	{
		return inicio.valor;
	}
	public int ultimo()
	{
		return fim.valor;
	}


}
