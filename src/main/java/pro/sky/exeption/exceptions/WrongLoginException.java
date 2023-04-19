package pro.sky.exeption.exceptions;

public class WrongLoginException extends RuntimeException {

    public WrongLoginException() {
        super("Логин может содержать только 20 символов");
    }

}