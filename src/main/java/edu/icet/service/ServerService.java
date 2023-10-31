package edu.icet.service;

import edu.icet.dao.ServerEntity;
import edu.icet.dto.Server;

import java.util.Collection;

public interface ServerService {
    ServerEntity create(ServerEntity serverEntity);
    ServerEntity ping(String ipAddress);
    Collection<ServerEntity> list(int limit);
    ServerEntity get(Long id);
    ServerEntity update(Server server);
    Boolean delete(Long id);

}
