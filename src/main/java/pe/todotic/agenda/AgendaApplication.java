package pe.todotic.agenda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.todotic.agenda.model.Contacto;
import pe.todotic.agenda.repo.ContactoRepository;

import javax.annotation.PostConstruct;
import java.sql.SQLOutput;
import java.time.LocalDate;

@Slf4j
@SpringBootApplication
public class AgendaApplication {

	@Autowired
	private ContactoRepository contactoRepository;

	@PostConstruct
	void init(){
		Contacto contacto1 = new Contacto();
		contacto1.setNombre("Luis Burgos Atoche");
		contacto1.setCelular("950110235");
		contacto1.setEmail("luisburgosvilca@gmail.com");
		contacto1.setFechaNacimiento(LocalDate.parse("1989-05-26"));

		contactoRepository.save(contacto1);

		Contacto contacto2 = new Contacto();
		contacto2.setNombre("Nancy Vilca Gomez");
		contacto2.setCelular("987654321");
		contacto2.setEmail("nancy@vilca.com");
		contacto2.setFechaNacimiento(LocalDate.now());

		contactoRepository.save(contacto2);

		contactoRepository.findAll().forEach( c -> {
			//System.out.println("Contacto: " + c.getNombre());
			log.info("Contacto: {}", c);
		});

	}

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}
}