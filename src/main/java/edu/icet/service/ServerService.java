package edu.icet.service;

import edu.icet.dao.ServerEntity;
import edu.icet.dto.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

public interface ServerService {
    ServerEntity create(ServerEntity serverEntity);
    ServerEntity ping(String ipAddress) throws IOException;
    Collection<ServerEntity> list(int limit);
    ServerEntity get(Long id);
    ServerEntity update(ServerEntity serverEntity);
    Boolean delete(Long id);

}
