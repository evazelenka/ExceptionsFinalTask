package Attestation.util;

public class SexFormatException extends Exception{
    public SexFormatException(){
        super("неверный символ для обозначения пола пользователя");
    }
}
