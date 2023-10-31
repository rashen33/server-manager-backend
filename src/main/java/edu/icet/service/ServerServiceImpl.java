package edu.icet.service;

import edu.icet.dao.ServerEntity;
import edu.icet.dto.Server;
import edu.icet.enumeration.Status;
import edu.icet.repository.ServerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Random;

import static edu.icet.enumeration.Status.SERVER_DOWN;
import static edu.icet.enumeration.Status.SERVER_UP;

@RequiredArgsConstructor //same as autowired (dependancy injection)
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
    public ServerEntity ping(String ipAddress) throws IOException {
        log.info("Saving new server: {}", ipAddress);
        ServerEntity serverEntity = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        serverEntity.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        serverRepository.save(serverEntity);
        return serverEntity;
    }

    @Override
    public Collection<ServerEntity> list(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(PageRequest.of(0, limit)).toList(); //getting the first page and setting the limit given by
    }

    @Override
    public ServerEntity get(Long id) {
        log.info("Fetching server by id: {}", id);
        return serverRepository.findById(id).get(); //returning the serverEntity object which has the given id
    }

    @Override
    public ServerEntity update(ServerEntity serverEntity) {
        log.info("Updating the server: {}", serverEntity.getName()); //loging the name of the server in the console
        return serverRepository.save(serverEntity);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server by id : {}", id);
        serverRepository.deleteById(id);
        return Boolean.TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames = { "server1.png", "server2.png", "server3.png", "server4.png"};
        //getting an image name randomly and returning the path of it
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
