package service;

import java.util.List;

import model.db.DataBase;
import model.impl.Student;

public class StudentService {

    public Student createStudent(String name, String lastName) {
        int id;
        if (DataBase.studentsDB.isEmpty()) {
            return new Student(1, name, lastName);
        }
        id = DataBase.studentsDB.size() + 1;
        return new Student(id, name, lastName);
    }

    public Student getByID(int id) throws Exception {
        Student student = DataBase.studentsDB
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        if (student == null) {
            throw new Exception("student not found");
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return DataBase.studentsDB;
    }
}
