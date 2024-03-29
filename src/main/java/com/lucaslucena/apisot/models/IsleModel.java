package com.lucaslucena.apisot.models;

import com.lucaslucena.apisot.enumns.NeighborhoodEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_isle")
@Getter
@Setter
public class IsleModel {

    public IsleModel(Long id, String x_coordinate, String y_coordinate, String name, String description) {
        Id = id;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.name = name;
        this.description = description;
    }

    public IsleModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "xCoordinate")
    private String x_coordinate;

    @Column(name = "yCoordinate")
    private String y_coordinate;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "neighborhood")
    @Enumerated(value = EnumType.STRING)
    private NeighborhoodEnum neighborhood;
}
