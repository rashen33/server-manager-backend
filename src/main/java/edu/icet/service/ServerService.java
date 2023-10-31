package edu.icet.service;

import edu.icet.dao.ServerEntity;
import edu.icet.dto.Server;

import java.util.Collection;

public interface ServerService {
    Server create(ServerEntity serverEntity);
    Collection<ServerEntity> list(int limit);
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);

}
