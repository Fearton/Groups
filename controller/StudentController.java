package controller;

import java.util.List;

import model.db.DataBase;
import model.impl.Student;
import service.StudentService;

public class StudentController {
    
    private StudentService service = new StudentService();

    public Student createStudent(String name, String lastName) {
        Student student = service.createStudent(name, lastName);
        DataBase.studentsDB.add(student);
        return student;
    }

    public Student getById(int id) {
        Student student = null;
        try {
            student = service.getByID(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return DataBase.studentsDB;
    }
}
