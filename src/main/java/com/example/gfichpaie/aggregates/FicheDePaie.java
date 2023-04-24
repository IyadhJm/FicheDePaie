package com.example.gfichpaie.aggregates;


import com.example.gfichpaie.commonapi.CreateFichedePaieCommand;
import com.example.gfichpaie.commonapi.UpdateFicheDePaieCommand;
import com.example.gfichpaie.enums.FicheDePaieStatus;
import com.example.gfichpaie.events.FicheDePaieCreatedEvent;
import com.example.gfichpaie.events.FicheDePaieUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;


import java.time.LocalDate;
@Aggregate
@Slf4j
public class FicheDePaie {
    @AggregateIdentifier
    private String ficheId;
    private String idCollaborator;
    private String titre;

    private FicheDePaieStatus status;

    public FicheDePaie() {
    }

    @CommandHandler
    public FicheDePaie(CreateFichedePaieCommand createFichedePaieCommand) {
        if((createFichedePaieCommand.getIdCollaborator()==null) || (createFichedePaieCommand.getTitre()==null) ){
            throw new RuntimeException("Input should not be null");
        }
        log.info("CreateFDPCommand Reveived");
        AggregateLifecycle.apply(
                new FicheDePaieCreatedEvent(
                    createFichedePaieCommand.getId(),
                    createFichedePaieCommand.getIdCollaborator(),
                    createFichedePaieCommand.getTitre(),

                    FicheDePaieStatus.CREATED));
    }
        @EventSourcingHandler
        public void on(FicheDePaieCreatedEvent event){
            log.info("FDPCreatedEvent Occured");
            this.ficheId= event.getId();
            this.idCollaborator=event.getIdCollaborator();
            this.titre= event.getTitre();
            this.status=event.getStatus();
        }
        @CommandHandler
        public void FicheDePaieAggregate(UpdateFicheDePaieCommand command){
            if((command.getIdCollaborator()==null) || (command.getTitre()==null) ){
                throw new RuntimeException("Input should not be null");
            }
        AggregateLifecycle.apply(new FicheDePaieUpdatedEvent(
               command.getFicheId(),
               command.getIdCollaborator(),
                command.getTitre(),
                FicheDePaieStatus.UPDATED
        ));
        }
    @EventSourcingHandler
    public void on(FicheDePaieUpdatedEvent event){
        this.ficheId= event.getFicheId();
        this.idCollaborator= event.getIdCollaborator();
        this.titre= event.getTitre();
        this.status=event.getStatus();
    }


}
