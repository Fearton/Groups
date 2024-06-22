package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import controller.StudentGroupController;
import controller.TeacherController;
import model.StudentGroup;
import model.db.DataBase;
import model.impl.Student;
import model.impl.Teacher;

public class StudentView {
    private StudentController controllerStudent = new StudentController();
    private TeacherController controllerTeacher = new TeacherController();
    private StudentGroupController controllerGroup = new StudentGroupController();

    public void start() {
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - create student");
            System.out.println("2 - find student by id");
            System.out.println("3 - print all students");
            System.out.println("4 - create teacher");
            System.out.println("5 - find teacher by id");
            System.out.println("6 - print all teachers");
            System.out.println("7 - create new group");
            System.out.println("8 - find group by id");
            System.out.println("9 - print all groups");
            System.out.println("10 - exit");
            
            switch (scanner.nextInt()) {
                case 1 -> createStudent();
                case 2 -> getStudentByID();
                case 3 -> getAllStudents();
                case 4 -> createTeacher();
                case 5 -> getTeacherByID();
                case 6 -> getAllTeachers();
                case 7 -> createStudentGroup();
                case 8 -> getGroupById();
                case 9 -> getAllGroups();
                case 10 -> System.exit(0);
                default -> System.out.println("Operation do not supported");
            }
        }
    }

    private Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name:");
        String name = scanner.nextLine();
        System.out.println("Input lastName:");
        String lastName = scanner.nextLine();
        Student student = controllerStudent.createStudent(name, lastName);
        System.out.println(student);
        return student;
    }

    private Student getStudentByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input user id:");
        int id = scanner.nextInt();
        Student student = controllerStudent.getById(id);
        System.out.println(student);
        return student;
    }

    private List<Student> getAllStudents() {
        List<Student> list = controllerStudent.getAllStudents();
        System.out.println(list);
        return list;
    }

    private Teacher createTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name:");
        String name = scanner.nextLine();
        System.out.println("Input lastName:");
        String lastName = scanner.nextLine();
        Teacher teacher = controllerTeacher.createTeacher(name, lastName);
        System.out.println(teacher);
        return teacher;
    }

    private Teacher getTeacherByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input user id:");
        int id = scanner.nextInt();
        Teacher teacher = controllerTeacher.getById(id);
        System.out.println(teacher);
        return teacher;
    }

    private List<Teacher> getAllTeachers() {
        List<Teacher> list = controllerTeacher.getAllTeachers();
        System.out.println(list);
        return list;
    }

    private StudentGroup createStudentGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input teacher id:");
        int id = scanner.nextInt();
        List<Student> students = new ArrayList<>();
        while (true) {
            System.out.println("Write 0 to stop");
            System.out.println("Input student id:");
            int idStudent = scanner.nextInt();
            if (idStudent == 0) {
                break;
            }
            Student student = controllerStudent.getById(idStudent);
            students.add(student);
        }
        StudentGroup group = controllerGroup.createStudentGroup(controllerTeacher.getById(id), students);
        System.out.println(group + "\n");
        return group;
    }

    private StudentGroup getGroupById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input group id:");
        int id = scanner.nextInt();
        StudentGroup group = controllerGroup.getGroupById(id);
        System.out.println(group + "\n");
        return group;
    }

    private List<StudentGroup> getAllGroups() {
        List<StudentGroup> list = controllerGroup.getAllGroups();
        for (StudentGroup studentGroup : list) {
            System.out.println(studentGroup);
        }
        return list;
    }
}
