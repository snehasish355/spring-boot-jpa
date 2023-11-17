package com.boot.jpa.relation.one2one;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    @Temporal(TemporalType.DATE)
    private LocalDate validFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "VALID_TO")
    private LocalDate validUpto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Person person;
}

