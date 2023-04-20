package pro.sky.exeption.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.exeption.exceptions.WrongLoginException;
import pro.sky.exeption.exceptions.WrongPasswordException;
import pro.sky.exeption.exceptions.WrongPasswordLength;

@Controller
public class ExceptionController {

    @PostMapping("/login")
    public void login(@RequestParam(required = false) String login,
                      @RequestParam(required = false) String password,
                      @RequestParam(required = false) String confirmPassword) {

        try {
            boolean result = validateLoginAndPassword(login, password, confirmPassword);
            if (result) {
                System.out.println("Вы успешно зарегистрировались");
            } else {
                System.out.println("Ошибка при регистрации");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Выполнение программы завершено");
        }
    }

    private Boolean validateLoginAndPassword(String login, String password, String confirmPassword) {
        if (login != null && !login.matches("^[a-zA-Z0-9_]+$")) {
            System.out.println("В логине можно использовать только латинские буквы цифры и знаки подчеркивания");
        }
        if (login != null && login.length() > 20) {
            throw new WrongLoginException();
        }
        if (password != null && !password.matches("^[a-zA-Z0-9_]+$")) {
            System.out.println("В пароле можно использовать только латинские буквы цифры и знаки подчеркивания");
        }
        if (password != null && password.length() >= 20) {
            throw new WrongPasswordLength();
        }
        if (password != null && !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
        else {
            return true;
        }

    }
}