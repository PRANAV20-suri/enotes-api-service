package com.enotes.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDto {

    private Integer id;
    private String name;
    private String description;

    private Boolean isActive;



    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "deleted_by")
    private Integer deletedBy;

    @Column(name = "created_date")
    private Date createdOn;

    @Column(name = "updated_date")
    private Date updatedOn;

}
