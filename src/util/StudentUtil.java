package util;

import beans.Student;
import main.Config;

public class StudentUtil {
    public static Student fillStudent() {
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        int age = MenuUtil.requireAge();
        String className = MenuUtil.requireClassname();

        return new Student(name, surname, age, className);
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            System.out.println((i + 1) + " " + st.getFullInfo());

        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("How many students?");
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". Register Student");
            Config.students[i] = StudentUtil.fillStudent();

        }

        System.out.println("Registration is completed");
        StudentUtil.printAllRegisteredStudents();
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requireText("Enter name, surname or class name");
        Student[] result = findStudents(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getFullInfo());
        }
    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }
        }
        Student[] result = new Student[count];

        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found++] = st;
            }

        }
        return result;
    }

    public static void updateStudent() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("Which student you want to update?");
        System.out.println("Enter new info");
        Student s = StudentUtil.fillStudent();
        Config.students[i - 1] = s;
    }

    public static void updateStudent2() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("Which student you want to update?");
        System.out.println("Enter new info");
        Student selectedStudent = Config.students[i - 1];

        selectedStudent.setName(MenuUtil.requireName());
        selectedStudent.setSurname(MenuUtil.requireSurname());
        selectedStudent.setClassName(MenuUtil.requireClassname());
        selectedStudent.setAge(MenuUtil.requireAge());
    }

    public static void updateStudent3() {
        StudentUtil.printAllRegisteredStudents();
        int index = InputUtil.requireNumber("Which student would you like to update?");
        System.out.println("Enter new parameters");
        Student selectedStudent = Config.students[index - 1];
        String changeParams = InputUtil.requireText("What do yu want to change?Ex:name,age");
        String[] parameters = changeParams.split(",");

        for (String param : parameters) {
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(MenuUtil.requireName());
            } else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(MenuUtil.requireSurname());
            } else if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(MenuUtil.requireAge());
            } else if (param.equalsIgnoreCase("classname")) {
                selectedStudent.setClassName(MenuUtil.requireClassname());
            }
        }
    }
}