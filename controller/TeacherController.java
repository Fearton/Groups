package controller;

import java.util.List;

import model.db.DataBase;
import model.impl.Teacher;
import service.TeacherService;

public class TeacherController {

    private TeacherService service = new TeacherService();

    public Teacher createTeacher(String name, String lastName) {
        Teacher teacher = service.createTeacher(name, lastName);
        DataBase.teachersDB.add(teacher);
        return teacher;
    }

    public Teacher getById(int id) {
        Teacher teacher = null;
        try {
            teacher = service.getByID(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return DataBase.teachersDB;
    }
}
