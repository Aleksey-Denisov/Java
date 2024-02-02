package ru.gbhw.userlinkproj.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "User_projects")
public class UserProject extends EntityWithRelation{
    //Права для связки пользователей и проктов
    @Column(name = "project_id", nullable = false)
    private Long projectId;
    @Column(name = "user_id", nullable = false)
    private Long userId;
}
