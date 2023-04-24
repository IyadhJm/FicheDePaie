package com.example.gfichpaie.events;

import com.example.gfichpaie.enums.FicheDePaieStatus;
import lombok.Getter;


public class FicheDePaieCreatedEvent extends BaseEvent <String> {

    @Getter private String idCollaborator;
    @Getter  private String titre;
    @Getter   private FicheDePaieStatus status;

    public FicheDePaieCreatedEvent(String id, String idCollaborator, String titre, FicheDePaieStatus status) {
        super(id);
        this.idCollaborator = idCollaborator;
        this.titre = titre;
        this.status = status;
    }

}
