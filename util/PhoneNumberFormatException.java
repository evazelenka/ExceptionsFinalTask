package Attestation.util;

public class PhoneNumberFormatException extends Exception{
    public PhoneNumberFormatException(){
        super("неверный формат номера телефона");
    }
}
