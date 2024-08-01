package Attestation.util;

public class DateOfBirthException extends Exception{
    public DateOfBirthException(){
        super("неверный формат даты рождения");
    }
}
