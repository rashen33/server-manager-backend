package edu.icet.repository;

import edu.icet.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server,Long> {
    Server findByIpAddress(String ipAdress);
}
