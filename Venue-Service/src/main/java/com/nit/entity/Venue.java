package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "venues")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Venue {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;

    @Column(nullable = false)
    private String venueName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String venueType;

    private String facilities;

    @Column(nullable = false)
    private String status;
}
