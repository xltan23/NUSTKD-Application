package sg.edu.nus.iss.TaekwondoData.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.edu.nus.iss.TaekwondoData.models.Student;
import sg.edu.nus.iss.TaekwondoData.services.StudentService;

@Controller
public class IndexController {
    private List<Student> studentList = new ArrayList<>();

    @Autowired
    StudentService stuSvc;

    @RequestMapping(path={"/nustaekwondo"}, method=RequestMethod.GET, produces = {"text/html"})
    public String index(Model model) {
        model.addAttribute("currentTime", (new Date()).toString());
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currentHour", cal.get(Calendar.HOUR_OF_DAY));
        return "index";
    }

    @GetMapping(path={"/student-list"}, produces = {"text/html"})
    public String studentList(Model model) {
        studentList = stuSvc.getStudentList();
        model.addAttribute("students", studentList);
        return "studentList";
    }
}
