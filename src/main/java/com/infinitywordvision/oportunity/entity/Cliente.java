package com.infinitywordvision.oportunity.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="clientes")
@Table
public class Cliente {
    @Id
    String documento;
    String nombre;
}
