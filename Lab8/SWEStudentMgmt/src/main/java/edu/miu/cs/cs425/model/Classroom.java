package edu.miu.cs.cs425.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;
    private String buildingName;
    private String roomNumber;

    public Classroom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }
}
