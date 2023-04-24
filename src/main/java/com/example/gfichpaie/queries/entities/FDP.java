package com.example.gfichpaie.queries.entities;

import com.example.gfichpaie.enums.FicheDePaieStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FDP {
    @Id
    private String ficheId;
    private String idCollaborator;
    private String titre;
    @Enumerated(EnumType.STRING)
    private FicheDePaieStatus status;
}
