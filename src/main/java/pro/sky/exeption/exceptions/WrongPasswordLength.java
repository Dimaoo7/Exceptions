package pro.sky.exeption.exceptions;

public class WrongPasswordLength extends RuntimeException {

    public WrongPasswordLength() {
        super("Пароль может содержать только 20 символов");
    }
}
