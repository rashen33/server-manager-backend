package edu.icet.repository;

import edu.icet.dao.ServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<ServerEntity,Long> {
    ServerEntity findByIpAddress(String ipAdress);
}
