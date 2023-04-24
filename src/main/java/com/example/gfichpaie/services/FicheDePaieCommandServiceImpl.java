package com.example.gfichpaie.services;

import com.example.gfichpaie.commonapi.CreateFichedePaieCommand;
import com.example.gfichpaie.commonapi.UpdateFicheDePaieCommand;
import com.example.gfichpaie.dtos.FicheDePaieRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class FicheDePaieCommandServiceImpl implements FicheDePaieCommandService {
@Autowired
    private CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> createFdP(FicheDePaieRequestDTO ficheDePaieRequestDTO) {
        return commandGateway.send(new CreateFichedePaieCommand(
                UUID.randomUUID().toString(),

            ficheDePaieRequestDTO.getIdCollaborator(),
            ficheDePaieRequestDTO.getTitre()));
       }
@Override
    public CompletableFuture<String> updateFDP(FicheDePaieRequestDTO ficheDePaieRequestDTO)
    { CompletableFuture<String> commandResponse = commandGateway.send(new UpdateFicheDePaieCommand(

        ficheDePaieRequestDTO.getFicheId(),
        ficheDePaieRequestDTO.getIdCollaborator(),
        ficheDePaieRequestDTO.getTitre()
    ));
        return commandResponse.exceptionally(ex -> {
            throw new RuntimeException("Failed to update FdP: " + ex.getMessage());
        });

    }
}
