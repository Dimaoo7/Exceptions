package pro.sky.exeption.exceptions;

public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException() {
        super("Пароли не совпадают");
    }



}
