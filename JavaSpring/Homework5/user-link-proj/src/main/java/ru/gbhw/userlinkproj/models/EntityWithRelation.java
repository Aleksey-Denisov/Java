package ru.gbhw.userlinkproj.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public abstract class EntityWithRelation {
    //Поля абстрактного класса
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "related_entity_id", nullable = false)
    private Long relatedEntityId;
}
