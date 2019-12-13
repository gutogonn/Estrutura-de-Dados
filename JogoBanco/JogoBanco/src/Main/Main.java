package Main;
import Domain.Imovel;
import Domain.Jogador;
import Domain.Noticia;
import Domain.Tipo_Construcao;
import EstruturaDeDados.Fila;
import EstruturaDeDados.ListaCircular;
import EstruturaDeDados.ListaDupla;
import EstruturaDeDados.PilhaDinamica;

public class Main 
{

	public static ListaDupla tabuleiro;
	public static ListaCircular jogadores;
	public static ListaCircular jogadorest;
	public static PilhaDinamica noticias;
	public static int indiceJogador;
	public static Jogador jogador;
	
	//usar como referencia na construcao de algo
	public static Imovel tipoCasa;
	public static Imovel tipoHotel;
	
	public static void main(String[] args) 
	{
		jogadorest = new ListaCircular();
		gerarNoticias();
		tabuleiro = new ListaDupla();
		tabuleiro.inserirInicio(new Imovel(250, 50, 100), 1);
		tabuleiro.inserirFim(new Imovel(250, 50, 100), 2);
		tabuleiro.inserirFim(new Noticia(), 3);
		tabuleiro.inserirFim(new Imovel(250, 50, 100), 4);
		tabuleiro.inserirFim(new Noticia(), 5);
		tabuleiro.inserirFim(new Noticia(), 6);
		tabuleiro.inserirFim(new Imovel(250, 50, 100), 7);
		tabuleiro.inserirFim(new Noticia(), 8);
		tabuleiro.inserirFim(new Noticia(), 9);
		tabuleiro.inserirFim(new Imovel(250, 50, 100), 10);
		tabuleiro.inserirFim(new Noticia(), 11);
		tabuleiro.inserirFim(new Noticia(), 12);
		tabuleiro.inserirFim(new Imovel(250, 50, 100), 13);
		tabuleiro.inserirFim(new Noticia(), 14);
		tabuleiro.inserirFim(new Noticia(), 15);
		tabuleiro.inserirFim(new Imovel(250, 50, 100), 16);
		tabuleiro.inserirFim(new Imovel(250, 50, 100), 17);
		tabuleiro.inserirFim(new Noticia(), 18);
		tabuleiro.inserirFim(new Noticia(), 19);
		tabuleiro.inserirFim(new Noticia(), 20);	
		
		jogadores = new ListaCircular();
		jogadores.inserirInicio(new Jogador("Jogador1"), 0);
		jogadores.inserirFim(new Jogador("Jogador2"), 1);
		jogadores.inserirFim(new Jogador("Jogador3"), 2);
		jogadores.inserirFim(new Jogador("Jogador4"), 3);
		
		tipoCasa = new Imovel("Casa", 50, 50, 300, 100, Tipo_Construcao.CASA);
		tipoHotel = new Imovel("Hotel", 90, 90, 800, 100, Tipo_Construcao.HOTEL);
		
		while(!verificarJogadoresAtivo()) 
		{
			if(noticias.estaVazia()) {
				gerarNoticias();
			}
			//jogadores = iniciarJogadores();
			jogador = (Jogador)jogadores.buscarElemento(indiceJogador).objeto;
			
			if(jogadorest.tamanho() > 2) {
				break;
			}
			
			System.out.println("jogador " + jogador.getNome() + " começou a jogar");
			
			if(jogador.isPreso()) 
			{
				//retirar e se tirar dados iguals nas 3 não paga a saida
				//retirar e se não tirar 3 dados iguais paga a saida
				
				int dado1 = getRandomInteger(0, 6);
				int dado2 = getRandomInteger(0, 6);
				if(dado1 == dado2) {
					jogador.setDadosIguais(jogador.getDadosIguais() + 1);
				}
				
				jogador.getTentativasDeSair().desempilha();
				if(jogador.getTentativasDeSair().estaVazia()) {
					if(jogador.getDadosIguais() >= 2) {
						System.out.println("jogador " + jogador.getNome() + " esta preso e tirou dados iguais então n paga saida");
					}else {
						pagarAlgo(indiceJogador, 200);
						System.out.println("jogador " + jogador.getNome() + " saiu da prisão, mas pagou saida de 200 reais.");
					}
					jogador.setPreso(false);
					System.out.println("jogador " + jogador.getNome() + " saiu da prisão");
				}else {
					System.out.println("jogador " + jogador.getNome() + " tentou sair da prisão " + jogador.getTentativasDeSair().tamanho());
				}	
			}
			else 
			{
				if(!jogador.isPerdeu()) 
				{
					int dado1 = getRandomInteger(0, 6);
					int dado2 = getRandomInteger(0, 6);
					
					System.out.println("jogador " + jogador.getNome() + " tirou " + (dado1 + dado2) + " no dado.");
					
					jogador.setUltimoLugar(jogador.getUltimoLugar() + (dado1 + dado2));
					//jogador.setUltimoLugar(25);
					andarNoTabuleiro(jogador, jogador.getUltimoLugar());
				}
				else 
				{
					System.out.println(jogador.getNome() + " ja perdeu!");
					jogadores.retirarMeio(indiceJogador);
				}
			}
			indiceJogador = indiceJogador < (jogadores.tamanho() - 1) ? indiceJogador + 1 : 0;
		}
		System.out.println("FIM DE JOGO, VENCEDOR: " + jogador.getNome());
	}
	
	public static ListaCircular iniciarJogadores() 
	{	
		ListaCircular joga = new ListaCircular();
		joga.inserirInicio(new Jogador("Jogador1"), 0);
		joga.inserirFim(new Jogador("Jogador2"), 1);
		joga.inserirFim(new Jogador("Jogador3"), 2);
		joga.inserirFim(new Jogador("Jogador4"), 3);
		return joga;
	}
	
	public static void gerarNoticias() {
		noticias = new PilhaDinamica();
		for(int c = 0; c < 60; c++) 
		{
			int r = getRandomInteger(-1, 2);
			noticias.empilha(r);
		}
	}
	
	public static int getRandomInteger(int maximum, int minimum)
	{
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
	
	public static boolean verificarJogadoresAtivo ()
	{
		boolean verifica = false;
		ListaCircular tmp = new ListaCircular();
		int i = 0;
		int jogadoresPerdeu = 0;
		int t = jogadores.tamanho();
		while(i != t) 
		{
			Jogador jogador = (Jogador) jogadores.retirarInicio();
			if(jogador.isPerdeu()) {
				jogadoresPerdeu++;
				jogadorest.inserirInicio(jogador, i);
			}
			tmp.inserirFim(jogador, i);
			i++;
		}
		jogadores = tmp;
		if(jogadoresPerdeu >= jogadores.tamanho()) {
			verifica = true;
		}
		return verifica;
	}
	
	public static Jogador buscarJogador(int i) 
	{
		return (Jogador)jogadores.buscarElemento(i).objeto;	
	}
	
	public static boolean pagarAlgo(int i, float valor) 
	{
		boolean podePagar = false;
		Jogador jogador = (Jogador)jogadores.buscarElemento(i).objeto; 
		
		while(jogador.getSaldo() <= valor && !jogador.getImoveis().estaVazia()) 
		{ 
			Imovel im = (Imovel) jogador.getImoveis().desempilha();
			jogador.setSaldo(jogador.getSaldo() + im.getValor()); //TODO que valor vai?
		}
		
		if((jogador.getSaldo() - valor) >= valor) 
		{
			jogador.setSaldo(jogador.getSaldo() - valor);
			podePagar = true;
		}
		
		return podePagar;
	}
	
	public static void andarNoTabuleiro(Jogador jogador, int node) //rever
	{
		ListaDupla tmp = new ListaDupla();
		tmp = tabuleiro;
		
		if(node > tmp.tamanho()) 
		{
			int t = jogador.getUltimoLugar() - tmp.tamanho();
			jogador.setSaldo(jogador.getSaldo() + 200);
			jogador.setPerdeu(!pagarAlgo(indiceJogador, pagarImposto(jogador)));
			if(!jogador.isPerdeu()) {
				jogador.setUltimoLugar(t);
				andarNoTabuleiro(jogador, t);
			}
		}
		
		System.out.println("jogador " + jogador.getNome() + " andou até a pos: " + jogador.getUltimoLugar());
			
		if(tmp.buscarElemento(jogador.getUltimoLugar()).objeto instanceof Imovel) 
		{
			Imovel im = (Imovel) tmp.buscarElemento(jogador.getUltimoLugar()).objeto;
			if(im.getLocatario() == null) 
			{
				System.out.println("jogador " + jogador.getNome() + " andou até a pos: " + jogador.getUltimoLugar() + " terreno vago");
				if(pagarAlgo(indiceJogador, im.getValor())) 
				{
					im.setLocatario(jogador);
					if(jogador.getImoveis().tamanho() > 0) {
						jogador.getImoveis().empilha(im, jogador.getImoveis().frente() + 1);
					}else {
						jogador.getImoveis().empilha(im, 0);
					}
					System.out.println("jogador " + jogador.getNome() + " andou até a pos: " + jogador.getUltimoLugar() + " comprou terreno vago");
				}
					
			}
			else 
			{//se tiver pague o aluguel ou crie algo
				if(im.getLocatario() != jogador) 
				{
					System.out.println("jogador " + jogador.getNome() + " andou até a pos: " + jogador.getUltimoLugar() + " terreno de alguem");
					if(im.getLocatario().isPerdeu()) 
					{
						if(pagarAlgo(indiceJogador, im.getValor()))//TODO VALOR A SER PAGO
						{
							im.setTipo(Tipo_Construcao.NENHUM);
							im.setLocatario(jogador);
						}
						System.out.println("jogador " + jogador.getNome() + " andou até a pos: " + jogador.getUltimoLugar() + " comprou terreno vago");
					}
					else 
					{
						if(im.getTipo() == Tipo_Construcao.NENHUM) {
							jogador.setPerdeu(!pagarAlgo(indiceJogador, im.getAluguel_terreno()));//TODO só alguel?
							im.getLocatario().setSaldo(im.getLocatario().getSaldo() + im.getAluguel_terreno());
						}else {
							jogador.setPerdeu(!pagarAlgo(indiceJogador, (im.getAluguel_terreno() + im.getAluguel())));//TODO só alguel?
							im.getLocatario().setSaldo(im.getLocatario().getSaldo() + (im.getAluguel_terreno() + im.getAluguel()));	
						}
						System.out.println("jogador " + jogador.getNome() + " andou até a pos: " + jogador.getUltimoLugar() + " pagou aluguel no terreno de " + im.getLocatario().getNome());
					}
				}
				else 
				{
					if(im.getTipo() == Tipo_Construcao.NENHUM) 
					{
						tmp.buscarElemento(jogador.getUltimoLugar()).objeto = tipoDeConstrucao(getRandomInteger(-1, 1));
						Imovel construido = (Imovel) tmp.buscarElemento(jogador.getUltimoLugar()).objeto;
						jogador.setPerdeu(!pagarAlgo(indiceJogador, construido.getImposto_terreno()));
						System.out.println("jogador " + jogador.getNome() + " andou até a pos: " + jogador.getUltimoLugar() + " construiu " + construido.getNome() + " no terreno");
					}
				}
			}
		}
		else if(tmp.buscarElemento(jogador.getUltimoLugar()).objeto instanceof Noticia) 
		{
			Noticia not = new Noticia();
			not.setCodigo(noticias.desempilha());
			switch(not.getCodigo()) 
			{
			case 0:
				System.out.println(jogador.getNome() + " Perdeu R$" + 250);
				jogador.setSaldo(jogador.getSaldo() - 250);
				if(jogador.getSaldo() <= 0){
					jogador.setPerdeu(true);
				}
				break;
			case 1:
				System.out.println(jogador.getNome() + " Ganhou R$" + 250);
				jogador.setSaldo(jogador.getSaldo() + 250);
				break;
			case 2:
				System.out.println(jogador.getNome() + " Foi preso!");
				jogador.setPreso(true);
				jogador.setTentativasDeSair(jogadorPreso());
				break;
			}
		}
		
	}
	
	public static Imovel tipoDeConstrucao(int r) 
	{
		return r == 0 ? tipoCasa : tipoHotel;
	}
	
	public static Fila jogadorPreso() 
	{
		Fila tentativas = new Fila();
		tentativas.empilha(new Object(), 1);
		tentativas.empilha(new Object(), 1);
		tentativas.empilha(new Object(), 1);
		return tentativas;
	}
	
	public static float pagarImposto(Jogador jogador) {
		Fila tmp = new Fila();
		tmp = jogador.getImoveis();
		float total = 0;
		
		while(!tmp.estaVazia()) 
		{
			Imovel i = (Imovel)tmp.desempilha();
			total += i.getImposto();
		}
		
		return total;
		
	}
	
}
