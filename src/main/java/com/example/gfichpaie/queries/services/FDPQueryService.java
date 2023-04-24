package com.example.gfichpaie.queries.services;

import com.example.gfichpaie.events.FicheDePaieCreatedEvent;
import com.example.gfichpaie.events.FicheDePaieUpdatedEvent;
import com.example.gfichpaie.mappers.FicheDePaieMapper;
import com.example.gfichpaie.queries.dtos.GetAllFDPQueryDTO;
import com.example.gfichpaie.queries.dtos.GetFDPQueryDTO;
import com.example.gfichpaie.queries.entities.FDP;
import com.example.gfichpaie.queries.repositories.FDPRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class FDPQueryService {
    private final FDPRepository fdpRepository;
    private final FicheDePaieMapper ficheDePaieMapper;
    private final QueryUpdateEmitter queryUpdateEmitter;

    @EventHandler
    public void on(FicheDePaieCreatedEvent ficheDePaieCreatedEvent){

        log.info("FDPCreatedEventRecieved");
        FDP fdp=new FDP();
        fdp.setFicheId(ficheDePaieCreatedEvent.getId());
        fdp.setIdCollaborator(ficheDePaieCreatedEvent.getIdCollaborator());
        fdp.setTitre(ficheDePaieCreatedEvent.getTitre());
        fdp.setStatus(ficheDePaieCreatedEvent.getStatus());

        fdpRepository.save(fdp);
    }
    @EventHandler
    public void on(FicheDePaieUpdatedEvent event){

        log.info("FDPUpdatedEventRecieved");
        FDP fdp=fdpRepository.findById(event.getId()).get();
        fdp.setFicheId(event.getFicheId());
        fdp.setTitre(event.getTitre());
        fdp.setIdCollaborator(event.getIdCollaborator());
        fdp.setStatus(event.getStatus());

        fdpRepository.save(fdp);
    }
    @QueryHandler
    public FDP on (GetFDPQueryDTO query) {
        return fdpRepository.findById(query.getId()).get();
    }

    @QueryHandler
    public List<FDP> on(GetAllFDPQueryDTO getAllRequestDTO) {
        return fdpRepository.findAll();
    }
}
