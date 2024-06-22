package service;

import java.util.List;

import model.StudentGroup;
import model.db.DataBase;
import model.impl.Student;
import model.impl.Teacher;

public class StudentGroupService {

    public StudentGroup createStudentGroup(Teacher teacher, List<Student> students) {
        int id;
        if (DataBase.studentGroups.isEmpty()) {
            return new StudentGroup(teacher, students, 1);
        }
        id = DataBase.studentGroups.size() + 1;
        return new StudentGroup(teacher, students, id);
    }

    public StudentGroup getGroupById(int id) throws Exception {
        StudentGroup group = DataBase.studentGroups
                .stream()
                .filter(g -> g.getIdGroup() == id)
                .findFirst()
                .orElse(null);
        if (group == null) {
            throw new Exception("group not found");
        }
        return group;
    }

    public List<StudentGroup> getAllGroups() {
        return DataBase.studentGroups;
    }
}
