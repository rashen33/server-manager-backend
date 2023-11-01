package edu.icet.service;

import edu.icet.model.Server;

import java.io.IOException;
import java.util.Collection;

public interface ServerService {
    Server create(Server serverEntity);
    Server ping(String ipAddress) throws IOException;
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server serverEntity);
    Boolean delete(Long id);

}
