package mx.uv.fei.demo;


public class Saludador{
	private String contenido;

	public Saludador(String contenido){
		this.contenido = contenido;
	}

	public String getContenido(){
		return contenido;
	}

	public void setContenido(String newContenido){
		contenido = newContenido;
	}

}
