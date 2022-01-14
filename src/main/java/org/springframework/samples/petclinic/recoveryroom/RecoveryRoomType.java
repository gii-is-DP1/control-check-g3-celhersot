package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_rooms_type")
public class RecoveryRoomType extends BaseEntity {
    //Integer id;
	@Column(name="name", unique=true)
	@NotNull
	@Size(min = 5, max = 50)
    String name;
}
