package model;

import java.util.ArrayList;
import java.util.List;

import model.impl.Student;
import model.impl.Teacher;

public class StudentGroup {
    private int groupId;
    private Teacher teacher;
    private List<Student> studentsGroup = new ArrayList<>();

    public StudentGroup(Teacher teacher, List<Student> studentsList, int groupId) {
        this.groupId = groupId;
        this.teacher = teacher;
        this.studentsGroup.addAll(studentsList);
    }

    public int getIdGroup() {
        return this.groupId;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() + ": \n%s,  \nlistStudent=%s,   \nidGroup=%s", teacher, studentsGroup, groupId);
    }
}
