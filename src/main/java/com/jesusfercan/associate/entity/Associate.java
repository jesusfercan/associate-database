package com.jesusfercan.associate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "associates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Associate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    @OneToMany
    @JoinColumn(name = "associate_id")
    private List<AssociateFees> associateFees;

    // metadata
    // delete
    private Boolean active;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
