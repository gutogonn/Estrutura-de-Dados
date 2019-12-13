package Domain;

public class Noticia 
{	
	private int codigo;
	private float valor;
	
	public Noticia() 
	{
		
	}
	
	public Noticia(int c, float v) 
	{
		codigo = c;
		valor = v;
	}
	
	public int getCodigo() 
	{
		return codigo;
	}
	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}
	public float getValor() 
	{
		return valor;
	}
	public void setValor(float valor) 
	{
		this.valor = valor;
	}
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + Float.floatToIntBits(valor);
		return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		if (codigo != other.codigo)
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}
	
	
	
}
