package controller;

import java.util.List;

import model.StudentGroup;
import model.db.DataBase;
import model.impl.Student;
import model.impl.Teacher;
import service.StudentGroupService;

public class StudentGroupController {

    private StudentGroupService service = new StudentGroupService();

    public StudentGroup createStudentGroup(Teacher teacher, List<Student> students) {
        StudentGroup group = service.createStudentGroup(teacher, students);
        DataBase.studentGroups.add(group);
        return group;
    }

    public StudentGroup getGroupById(int id) {
        StudentGroup studentGroup = null;
        try {
            studentGroup = service.getGroupById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return studentGroup;
    }

    public List<StudentGroup> getAllGroups() {
        return DataBase.studentGroups;
    }
}
