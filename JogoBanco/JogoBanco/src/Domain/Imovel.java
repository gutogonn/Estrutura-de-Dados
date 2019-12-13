package Domain;

public class Imovel 
{
	
	private String nome;
	private Tipo_Construcao tipo;
	
	private float valor; //valor do terreno
	
	private float aluguel; //valor oponente vai pagar
	
	private float imposto; //valor que vai pagar no final da rodada
	
	private float aluguel_terreno; //valor da construção do imovel
	private float imposto_terreno; //valor da construção do imovel
		
	private Jogador locatario;
	
	public Imovel(float valor, float aluguel_terreno, float imposto_terreno) 
	{
		tipo = Tipo_Construcao.NENHUM;
		this.imposto_terreno = imposto_terreno;
		this.aluguel_terreno = aluguel_terreno;
		this.valor = valor;
	}
	
	public Imovel(String n, float alu, float imp, float alguel_terreno, float imposto_terreno, Tipo_Construcao tip) 
	{
		nome = n;
		aluguel = alu;
		imposto = imp;
		aluguel_terreno = alguel_terreno;
		this.imposto_terreno = imposto_terreno;
		
		tipo = tip;
		locatario = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tipo_Construcao getTipo() {
		return tipo;
	}

	public void setTipo(Tipo_Construcao tipo) {
		this.tipo = tipo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getAluguel() {
		return aluguel;
	}

	public void setAluguel(float aluguel) {
		this.aluguel = aluguel;
	}

	public float getImposto() {
		return imposto;
	}

	public void setImposto(float imposto) {
		this.imposto = imposto;
	}

	public float getAluguel_terreno() {
		return aluguel_terreno;
	}

	public void setAluguel_terreno(float aluguel_terreno) {
		this.aluguel_terreno = aluguel_terreno;
	}

	public float getImposto_terreno() {
		return imposto_terreno;
	}

	public void setImposto_terreno(float imposto_terreno) {
		this.imposto_terreno = imposto_terreno;
	}

	public Jogador getLocatario() {
		return locatario;
	}

	public void setLocatario(Jogador locatario) {
		this.locatario = locatario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(aluguel);
		result = prime * result + Float.floatToIntBits(aluguel_terreno);
		result = prime * result + Float.floatToIntBits(imposto);
		result = prime * result + Float.floatToIntBits(imposto_terreno);
		result = prime * result + ((locatario == null) ? 0 : locatario.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
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
		Imovel other = (Imovel) obj;
		if (Float.floatToIntBits(aluguel) != Float.floatToIntBits(other.aluguel))
			return false;
		if (Float.floatToIntBits(aluguel_terreno) != Float.floatToIntBits(other.aluguel_terreno))
			return false;
		if (Float.floatToIntBits(imposto) != Float.floatToIntBits(other.imposto))
			return false;
		if (Float.floatToIntBits(imposto_terreno) != Float.floatToIntBits(other.imposto_terreno))
			return false;
		if (locatario == null) {
			if (other.locatario != null)
				return false;
		} else if (!locatario.equals(other.locatario))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo != other.tipo)
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}

}
