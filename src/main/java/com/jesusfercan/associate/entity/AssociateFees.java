package com.jesusfercan.associate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "associate_fees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociateFees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer year;
    private LocalDate paymentData;
    @ManyToOne
    private Associate associate;


    // metadata
    // delete
    private Boolean active;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
