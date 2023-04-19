package pro.sky.exeption.exceptions;

public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException() {
        super("Пароль может содержать только 20 символов");
    }


}
