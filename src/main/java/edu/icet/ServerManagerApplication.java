package edu.icet;

import edu.icet.model.Server;
import edu.icet.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static edu.icet.enumeration.Status.SERVER_DOWN;
import static edu.icet.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerManagerApplication.class, args);
	}

	CommandLineRunner run(ServerRepository serverRepository){
		return args -> {
			serverRepository.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16GB", "Personal PC", "http://localhost:8080/server/image/server1.png" , SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.58", "Fedora", "16GB", "Dell Tower", "http://localhost:8080/server/image/server2.png" , SERVER_DOWN));
			serverRepository.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16GB", "Personal PC", "http://localhost:8080/server/image/server1.png" , SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16GB", "Personal PC", "http://localhost:8080/server/image/server1.png" , SERVER_UP));
		};
	}
}
