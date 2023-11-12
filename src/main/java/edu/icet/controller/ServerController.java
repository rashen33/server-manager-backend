package edu.icet.controller;


import edu.icet.enumeration.Status;
import edu.icet.model.Response;
import edu.icet.model.Server;
import edu.icet.service.ServerService;
import edu.icet.service.ServerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor //does the same thing as autowired
public class ServerController {
    private final ServerService serverService;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("servers",serverService.list(30)))
                        .message("Server Retreived")
                        .status(HttpStatus.valueOf(OK))
                        .statusCode(OK)
                        .build()
        );
    }

    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> pingServer(@PathVariable String ipAddress) throws IOException {
        Server server = serverService.ping(ipAddress);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("servers",serverService.list(30)))
                        .message(server.getStatus() == Status.SERVER_UP ? "Ping Success" : "Ping Failed")
                        .status(HttpStatus.valueOf(OK))
                        .statusCode(OK)
                        .build()
        );
    }
}
