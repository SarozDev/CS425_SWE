package edu.miu.cs.cs425.eRegistrar.repo;

import edu.miu.cs.cs425.eRegistrar.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameContainingOrLastNameContainingOrStudentNumberContaining(String keyword, String keyword1, String keyword2);

    Student findByStudentNumber(String studentNumber);
}
