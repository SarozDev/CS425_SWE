package edu.miu.cs.cs425;

import edu.miu.cs.cs425.model.Classroom;
import edu.miu.cs.cs425.model.Student;
import edu.miu.cs.cs425.model.Transcript;

import javax.persistence.*;
import java.util.Date;

public class StudentMgmtApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Transcript transcript = new Transcript("MS in CS");

        Classroom classroom = new Classroom("McLaughlin building", "M105");

        Student student = new Student("000-61-0002", "Anna", "Lynn", "Smith", 3.45, new Date(2021, 5, 24));

        student.setTranscript(transcript);
        student.setClassroom(classroom);
        saveStudent(em, student);

        em.close();
        emf.close();
    }

    public static void saveStudent(EntityManager em, Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }
}
