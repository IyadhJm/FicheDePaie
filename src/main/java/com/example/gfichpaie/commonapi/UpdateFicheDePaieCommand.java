package com.example.gfichpaie.commonapi;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

public class UpdateFicheDePaieCommand {
    public UpdateFicheDePaieCommand(String ficheId, String idCollaborator, String titre) {
        this.ficheId = ficheId;
        this.idCollaborator = idCollaborator;
        this.titre = titre;
    }

    @TargetAggregateIdentifier
    @Getter private String ficheId;
    @Getter private String idCollaborator;
    @Getter  private String titre;

}
