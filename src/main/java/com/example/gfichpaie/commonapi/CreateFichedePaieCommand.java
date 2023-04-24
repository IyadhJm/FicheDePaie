package com.example.gfichpaie.commonapi;

import lombok.Getter;

import java.time.LocalDate;

public class CreateFichedePaieCommand extends BaseCommand<String> {

    @Getter private String idCollaborator;
    @Getter  private String titre;
    public CreateFichedePaieCommand(String id , String idCollaborator, String titre) {
        super(id);
        this.idCollaborator = idCollaborator;
        this.titre = titre;
    }
}
