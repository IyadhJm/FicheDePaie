package com.example.gfichpaie.events;

import com.example.gfichpaie.enums.FicheDePaieStatus;
import lombok.Getter;


public class FicheDePaieUpdatedEvent extends BaseEvent<String>{
    @Getter private String ficheId;
    @Getter private String idCollaborator;
    @Getter  private String titre;
    @Getter   private FicheDePaieStatus status;
    public FicheDePaieUpdatedEvent(String id, String ficheId, String idCollaborator, FicheDePaieStatus status) {
        super(id);
        this.ficheId = ficheId;
        this.idCollaborator = idCollaborator;
        this.titre = titre;
        this.status = status;
    }




}
