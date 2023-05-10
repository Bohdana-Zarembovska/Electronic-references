package org.electronicReferences.dto.DiagnosisDTOs;

import lombok.Data;

@Data
public class DiagnosisUpdateDTO {
    private Integer doctorId;
    private String diagnosisCode;
    private Integer patientId;
}
