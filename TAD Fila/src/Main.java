
public class Main {
	public static void main(String args[]){
		Fila fila = new Fila();
		System.out.println("Empilhando...");
		fila.empilha(1);
		fila.empilha(2);
		fila.empilha(3);
		fila.empilha(4);
		
		System.out.println("tamanho: " + fila.tamanho());
		System.out.println("frente: " + fila.frente());

		while(!fila.estaVazia()){
			System.out.println("desempilhando: " + fila.desempilha());
		}
	} 
}
