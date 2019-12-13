
public class Main {
	public static void main(String args[]){
		Lista lista = new Lista();
		System.out.println("inserindo...");
		
		//12, 1, 4, 15, 44, 23, 66
		
		lista.inserirInicio(1);
		lista.inserirFim(4);
		lista.inserirInicio(12);
		lista.inserirFim(44);
		lista.inserirFim(23);
		lista.inserirMeio(4, 15);
		lista.inserirFim(66);
		
//		System.out.println("frente: " + lista.frente());
		System.out.println("Lista Atual: " + lista.listar() + " tamanho: " + lista.tamanho());
		
		System.out.println("retirando inicio: " + lista.retirarInicio());
		
		System.out.println("depois do retirarInicio: " + lista.listar() + " tamanho: " + lista.tamanho());
		
		System.out.println("retirando inicio: " + lista.retirarFim());
		
		System.out.println("depois do retirarFim: " + lista.listar() + " tamanho: " + lista.tamanho());
		
		System.out.println("retirando meio: " + lista.retirarMeio(4));
		
		System.out.println("depois do retirarMeio: " + lista.listar() + " tamanho: " + lista.tamanho());
		System.out.println("tamanho: " + lista.tamanho());
	} 
}
