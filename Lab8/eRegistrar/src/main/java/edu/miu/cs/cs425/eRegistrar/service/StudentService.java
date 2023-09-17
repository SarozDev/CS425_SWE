package edu.miu.cs.cs425.eRegistrar.service;

import edu.miu.cs.cs425.eRegistrar.entity.Student;
import edu.miu.cs.cs425.eRegistrar.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InvalidPropertiesFormatException;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    public List<Student> searchStudents(String keyword){
        return repo.findByFirstNameContainingOrLastNameContainingOrStudentNumberContaining(keyword, keyword, keyword);
    }

    public void addStudent(Student student){
        Student existingStudent = repo.findByStudentNumber(student.getStudentNumber());
        if(existingStudent!=null){
            //throw new InvalidPropertiesFormatException("Already exists");
        }else {
            repo.save(student);
        }
    }

    public Student getStudentById(Long id){
        return repo.findById(id).orElse(null);
    }

    public void updateStudent(Long id, Student student){
        Student existingStudent = repo.findById(id).orElse(null);
        if(existingStudent != null){
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setCgpa(student.getCgpa());
            existingStudent.setIsInternational(student.getIsInternational());
            existingStudent.setEnrollmentDate(student.getEnrollmentDate());
            existingStudent.setMiddleName(student.getMiddleName());
            repo.save(student);
        }
    }

    public  void deleteStudent(Long id){
        repo.deleteById(id);
    }
}
