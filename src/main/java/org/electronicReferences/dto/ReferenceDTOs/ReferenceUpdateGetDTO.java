package org.electronicReferences.dto.ReferenceDTOs;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReferenceUpdateGetDTO {
    private String medicine;
    private Integer diagnosisId;
    private LocalDate referenceDate;

}
