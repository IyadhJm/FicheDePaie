package com.example.gfichpaie.queries.dtos;

import com.example.gfichpaie.enums.FicheDePaieStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FDPResponseDTO {
    private String ficheId;
    private String idCollaborator;
    private String titre;
    private FicheDePaieStatus status;
}
