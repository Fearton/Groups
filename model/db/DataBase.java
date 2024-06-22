package model.db;

import java.util.ArrayList;
import java.util.List;

import model.StudentGroup;
import model.impl.Student;
import model.impl.Teacher;

public class DataBase {
    public static final List<Student> studentsDB = new ArrayList<>();
    public static final List<Teacher> teachersDB = new ArrayList<>();
    public static final List<StudentGroup> studentGroups = new ArrayList<>();


    public static void fillDB() {
        Teacher teacher = new Teacher(1, "Gendalf", "Grey");
        teachersDB.add(teacher);

        Student student1 = new Student(1, "Harry", "Potniy");
        Student student2 = new Student(2, "Adam", "Smasher");
        studentsDB.add(student1);
        studentsDB.add(student2);

        StudentGroup studentGroup = new StudentGroup(teacher, studentsDB, 1);
        studentGroups.add(studentGroup);
    }
}
