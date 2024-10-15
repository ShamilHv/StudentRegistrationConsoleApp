package util;

public class MenuUtil {
    public static void processMenu(int selectedMenu){
        switch (selectedMenu) {
            case 1 : StudentUtil.registerStudents();break;
            case 2 : StudentUtil.printAllRegisteredStudents();break;
            case 3 : StudentUtil.findStudentsAndPrint();break;
            case 4 : StudentUtil.updateStudent3();break;
            case 5 : System.exit(0);break;
        }
    }

    public static String requireName(){
        return InputUtil.requireText("Enter name");
    }
    public static String requireSurname(){
        return InputUtil.requireText("Enter surname");
    }
    public static String requireClassname(){
        return InputUtil.requireText("Enter classname");
    }
    public static int requireAge(){
        return InputUtil.requireNumber("Enter age");
    }

}
