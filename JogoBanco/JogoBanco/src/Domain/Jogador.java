package Domain;
import EstruturaDeDados.Fila;

public class Jogador 
{

	private String nome;
	private float saldo;
	
	private boolean perdeu;
	
	private boolean isPreso;
	private Fila tentativasDeSair;
	private int dadosIguais;
	
	private Fila imoveis;
	
	private int ultimoLugar;
	
	public Jogador(String nome) 
	{
		this.nome = nome;
		saldo = 2500f;
		perdeu = false;
		isPreso = false;
		tentativasDeSair = new Fila();
		imoveis = new Fila();
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public float getSaldo() 
	{
		return saldo;
	}

	public void setSaldo(float saldo) 
	{
		this.saldo = saldo;
	}

	public boolean isPerdeu() 
	{
		return perdeu;
	}

	public void setPerdeu(boolean perdeu) 
	{
		this.perdeu = perdeu;
	}

	public boolean isPreso() 
	{
		return isPreso;
	}

	public void setPreso(boolean isPreso) 
	{
		this.isPreso = isPreso;
	}

	public Fila getTentativasDeSair() 
	{
		return tentativasDeSair;
	}

	public void setTentativasDeSair(Fila tentativasDeSair)
	{
		this.tentativasDeSair = tentativasDeSair;
	}

	public Fila getImoveis() 
	{
		return imoveis;
	}

	public void setImoveis(Fila imoveis) 
	{
		this.imoveis = imoveis;
	}

	public int getUltimoLugar() 
	{
		return ultimoLugar;
	}

	public void setUltimoLugar(int ultimoLugar) 
	{
		this.ultimoLugar = ultimoLugar;
	}

	public int getDadosIguais() {
		return dadosIguais;
	}

	public void setDadosIguais(int dadosIguais) {
		this.dadosIguais = dadosIguais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dadosIguais;
		result = prime * result + ((imoveis == null) ? 0 : imoveis.hashCode());
		result = prime * result + (isPreso ? 1231 : 1237);
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (perdeu ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(saldo);
		result = prime * result + ((tentativasDeSair == null) ? 0 : tentativasDeSair.hashCode());
		result = prime * result + ultimoLugar;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (dadosIguais != other.dadosIguais)
			return false;
		if (imoveis == null) {
			if (other.imoveis != null)
				return false;
		} else if (!imoveis.equals(other.imoveis))
			return false;
		if (isPreso != other.isPreso)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (perdeu != other.perdeu)
			return false;
		if (Float.floatToIntBits(saldo) != Float.floatToIntBits(other.saldo))
			return false;
		if (tentativasDeSair == null) {
			if (other.tentativasDeSair != null)
				return false;
		} else if (!tentativasDeSair.equals(other.tentativasDeSair))
			return false;
		if (ultimoLugar != other.ultimoLugar)
			return false;
		return true;
	}

	
	
}
