package edu.icet.service;

import edu.icet.dao.ServerEntity;
import edu.icet.dto.Server;
import edu.icet.repository.ServerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j //creates a static SLF4J logger instance named log
public class ServerServiceImpl implements ServerService{
//    @Autowired
    private final ServerRepository serverRepository;
    @Override
    public ServerEntity create(ServerEntity serverEntity) {
        log.info("Saving new server: {}", serverEntity.getName()); //loging the name of the server in the console
        serverEntity.setImageUrl(setServerImageUrl()); //setting an image for the server
        return serverRepository.save(serverEntity); //saving the server
    }

    @Override
    public ServerEntity ping(String ipAddress) {
        return null;
    }

    @Override
    public Collection<ServerEntity> list(int limit) {
        return null;
    }

    @Override
    public ServerEntity get(Long id) {
        return null;
    }

    @Override
    public ServerEntity update(Server server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private String setServerImageUrl() {
        return null;
    }
}
