package com.lucaslucena.apisot.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_isle")
@Getter
@Setter
public class IsleModel {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "xCoordinate")
    private String x_coordinate;

    @Column(name = "yCoordinate")
    private String y_coordinate;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
