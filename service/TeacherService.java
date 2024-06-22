package service;

import java.util.List;

import model.db.DataBase;
import model.impl.Teacher;

public class TeacherService {
    public Teacher createTeacher(String name, String lastName) {
        int id;
        if (DataBase.teachersDB.isEmpty()) {
            return new Teacher(1, name, lastName);
        }
        id = DataBase.teachersDB.size() + 1;
        return new Teacher(id, name, lastName);
    }

    public Teacher getByID(int id) throws Exception {
        Teacher teacher = DataBase.teachersDB
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        if (teacher == null) {
            throw new Exception("teacher not found");
        }
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return DataBase.teachersDB;
    }
}
