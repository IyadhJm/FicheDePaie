package com.example.gfichpaie.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class FicheDePaieRequestDTO {
    private String ficheId;
    private String idCollaborator;
    private String titre;
}
