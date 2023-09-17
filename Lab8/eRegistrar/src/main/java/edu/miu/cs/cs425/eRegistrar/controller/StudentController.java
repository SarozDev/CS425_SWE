package edu.miu.cs.cs425.eRegistrar.controller;

import edu.miu.cs.cs425.eRegistrar.entity.Student;
import edu.miu.cs.cs425.eRegistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/home")
    public String home(){
        return "student/home";
    }

    @GetMapping("/search")
    public String searchStudents(@ModelAttribute("keyword") String keyword, Model model){
        List<Student> students = service.searchStudents(keyword);

        if(students.isEmpty()){
            model.addAttribute("message","No students found for the given search");
        }else {
            model.addAttribute("students", students);
        }
        return "student/list";
    }

    @GetMapping("/list")
    public String listStudents(Model model){
        List<Student> students = service.getAllStudents();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/add")
    public String showAddStudent(Model model){
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("students")Student student){
        service.addStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "student/edit";
    }

    @PostMapping("edit/{id}")
    public String editStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student ){
        service.updateStudent(id,student);
        return "redirect:/students/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        service.deleteStudent(id);
        return "redirect:/students/list";
    }


}
