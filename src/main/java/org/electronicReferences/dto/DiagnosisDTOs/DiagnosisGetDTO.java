package org.electronicReferences.dto.DiagnosisDTOs;

import lombok.Data;

@Data
public class DiagnosisGetDTO {
    private Integer doctorId;
    private String diagnosisCode;
}