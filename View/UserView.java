package Attestation.View;

import Attestation.Controller.UserController;

import java.util.Arrays;
import java.util.Scanner;

public class UserView {

    private final UserController controller = new UserController();

    public void start(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Введите данные пользователя через пробел(ФИО, номер телефона, пол(f/m), дата рождения(дд.мм.гггг): ");
            String str = scanner.nextLine();
            System.out.println("проверка введенных данных...");
            int cS = controller.checkString(str);
            switch (cS) {
                case 0 -> controller.writeInFile(controller.createUser(str));
                case -1 -> System.out.println("введено недостаточное количество данных");
                case -2 -> System.out.println("введено слишком много данных");
            }
//            if( cS == 0){
//                User user = controller.createUser(str);
//                controller.writeInFile(user);
//                System.out.println("данные приняты!");
//            }else if(cS == -1){
//                System.out.println("введено недостаточное количество данных");
//            }else if(cS == -2){
//                System.out.println("введено слишком много данных");
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
