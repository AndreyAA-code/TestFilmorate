package ru.yandex.practicum.filmorate.exceptions;

public class ParameterNotValidException extends IllegalArgumentException {
    String parameter;
    String reason;

    public ParameterNotValidException(String parameter, String reason) {
        super("Ошибка в параметре " + parameter  + reason);
        this.parameter = parameter;
        this.reason = reason;
    }
}
