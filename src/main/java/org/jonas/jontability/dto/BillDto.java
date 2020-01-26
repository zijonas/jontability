package org.jonas.jontability.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BillDto {
    private Integer id;
    private Integer categoryId;
    private Integer accountId;
    private String description;
    private Date date;
    private Double value;
}
