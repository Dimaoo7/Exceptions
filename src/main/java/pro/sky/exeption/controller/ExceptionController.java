package pro.sky.exeption.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exeption.exceptions.WrongPasswordException;
import pro.sky.exeption.exceptions.WrongLoginException;

@RestController
@RequestMapping("/login")
public class ExceptionController {

    public static String a = null;

    public static void login(String login, String password, String confirmPassword) { // логин  содержит
        // только латинские буквы цыфры и знаки подчеркивания
        if (!login.matches("^[a-zA-Z0-9_]+$")) {
            System.out.println("В логине можно использовать только латинские буквы цыфры и знаки подчеркивания");
            if (login.length() > 20) {
                a = "Логин должен быть равен или меньше 20 символов";
                throw new WrongLoginException();

            }
        }

        if (!login.matches("^[a-zA-Z0-9_]+$")) {
            System.out.println("В пароле можно использовать только латинские буквы цыфры и знаки подчеркивания");
            if (password.length() >= 20) {
                a = "Пароль должен быть меньше 20 символов";
                throw new WrongPasswordException();
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
        else {
            System.out.println("Аккаунт не найден. Повторите попытку или зарегистрируйтесь по номеру телефона");
        }
    }
}


