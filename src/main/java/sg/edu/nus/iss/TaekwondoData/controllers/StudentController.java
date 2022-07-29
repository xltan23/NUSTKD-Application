package sg.edu.nus.iss.TaekwondoData.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.TaekwondoData.models.Student;
import sg.edu.nus.iss.TaekwondoData.services.StudentService;

@Controller
@RequestMapping(path = "/nustkd-submit")
public class StudentController {
    private List<Student> studentList = new ArrayList<>();

    @Autowired
    private StudentService stuSvc;

    @PostMapping(consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postStudent(@RequestBody MultiValueMap<String, String> form, Model model) {
        Student s = new Student();
        s.setFullName(form.getFirst("fullName"));
        s.setGender(form.getFirst("gender"));
        s.setEmail(form.getFirst("email"));
        s.setPhone(form.getFirst("phone"));
        s.setGrade(form.getFirst("grade"));
        s.setType(form.getFirst("type"));
        s.setCompeteBefore(form.getFirst("competeBefore"));
        stuSvc.addStudent(s);
        stuSvc.save(s);

        model.addAttribute("student", s);
        return "studentProfile";
    }

    @GetMapping(value="/{id}", produces = "text/html")
    public String getStudent(@PathVariable("id") String id, Model model) {
        Student s = new Student();
        s = stuSvc.read(id);

        System.out.printf("> ID: %s", s);

        model.addAttribute("student", s);
        return "studentProfile";
    }

    @GetMapping(value="/studentList")
    public String studentList(Model model) {
        studentList = stuSvc.getStudentList();
        model.addAttribute("students", studentList);
        return "studentList";
    }

}
