package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SaludarControlador{
	String nombre;

	@GetMapping("/saludos")
	public String saludar(){
		return "hola mundo " + nombre;
	}

	@GetMapping("/despedidas")
	public String despedirse(){
		return "adios mundo xd " + nombre;
	}

	@PostMapping("/nombramientos")
	public String nombre(){
		nombre = "saul";
		return nombre;
	}

	@PutMapping("/nombramientos")
	public void renombrar(){
		nombre ="actualizar";
	}

	@DeleteMapping("/nombramientos")
	public void eliminarN(){
		nombre= null;
	}

	@GetMapping("/saludador/{nombre}")
	public Saludador met3(@PathVariable String nombre){
		return new Saludador(nombre);
	}


	@RequestMapping("/saludador2/{nombreX}")
	public Saludador met4(@PathVariable("nombreX") String nombre){
		saludador = new Saludador(nombre);
		return saludador;
	}

	@RequestMapping("/")
	public String indice (){
		return """
			<h1>Menú principal</h1>
			<ul>
				<li><a href='/saludos'>saludos</a></li>
				<li><a href='/despedidas'>despedidas</a></li>
				<li><a href="/saludador/default">/saludador/{nombre}</a></li>
				<li><a href="/saludador2/default2">/saludador2/{nombreX}</a></li>
				<li>/nombramientos (POST | PUT | DELETE)</li>
				<li><a href="/obtenerSaludador">/obtenerSaludador</a></li>
			</ul>""";
	}

	Saludador saludador;
	@PostMapping("/crearSaludador")
	public void crearSaludador(@RequestBody Saludador x){
		saludador = x;
	}

	@GetMapping("/obtenerSaludador")
	public Saludador obtenerSaludador(String nombre){
		return saludador;
	}

	@GetMapping("/getQuery")
	public String getQueryString(@RequestParam String query, @RequestParam String paterno){
		return query + " "+ paterno;
	}

	/*
	@GetMapping("/getQuery2")
	public String getQueryString2(@RequestParam String query="nombre", @RequestParam(defaultValue=""), String paterno){
		return query + " "+ paterno;
	}*/

	
}
