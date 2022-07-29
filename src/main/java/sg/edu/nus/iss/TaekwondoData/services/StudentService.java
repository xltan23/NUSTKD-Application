package sg.edu.nus.iss.TaekwondoData.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.TaekwondoData.models.Student;

@Service
public class StudentService {
    private File dataDir = new File("Directory");
    private List<Student> studentList = new ArrayList<>();

    public File getDataDir() {
        return dataDir;
    }

    public void setDataDir(File dataDir) {
        this.dataDir = dataDir;
    }

    public boolean isDataDirValid() {
        return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite();
    }

    public boolean save(final Student student) {
        File f = new File(this.dataDir, student.getId());
        try (OutputStream os = new FileOutputStream(f)) {
            PrintWriter pw =  new PrintWriter(os);
            pw.println(student.getId());
            pw.println(student.getFullName());
            pw.println(student.getGender());
            pw.println(student.getEmail());
            pw.println(student.getPhone());
            pw.println(student.getGrade());
            pw.println(student.getType());
            pw.println(student.getCompeteBefore());
            pw.flush();

            return true;
        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
            return false;
        }
    }

    public Student read(String fileId) {
        try {
            Student student = new Student();
            // Create a file path using the fileId that program is tasked to read
            Path filePath = new File(this.dataDir, fileId).toPath();
            Charset charset = Charset.forName("utf-8");
            List<String> stringVal = Files.readAllLines(filePath, charset);

            student.setFullName(stringVal.get(0));
            student.setGender(stringVal.get(1));
            student.setEmail(stringVal.get(2));
            student.setPhone(stringVal.get(3));
            student.setGrade(stringVal.get(4));
            student.setType(stringVal.get(5));
            student.setCompeteBefore(stringVal.get(6));

            return student;
        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
            ex.printStackTrace();

            return null;
        }
    }

    public void addStudent(Student s) {
        studentList.add(new Student(s.getId(), s.getFullName(), s.getGender(), s.getEmail(), s.getPhone(), s.getGrade(), s.getType(), s.getCompeteBefore()));
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    

}
