package Attestation.Service;

import Attestation.Model.User;
import Attestation.util.DateOfBirthException;
import Attestation.util.NameFormatException;
import Attestation.util.PhoneNumberFormatException;
import Attestation.util.SexFormatException;

public class UserService {

    public User createUser(String str) throws Exception {
        String[] info = str.split(" ");
        String[] fio = new String[3];
        long phoneNumber = 0;
        char sex = '0';
        int k = 0;
        String dateOfBirth = null;
        for (String s : info) {
                if (s.length() == 1) {

                    if(s.equals("f") || s.equals("m")) {
                        sex = s.charAt(0);
                    }else throw new SexFormatException();

                } else if (s.charAt(2) == '.' && s.charAt(5) == '.') {

                    if(isDateOfBirth(s)) {
                        dateOfBirth = s;
                    }else throw new DateOfBirthException();

                } else if (isDigit(s)) {

                    long l = Long.parseLong(s);
                    if(l < 0){
                        throw new PhoneNumberFormatException();
                    }
                    phoneNumber = Long.parseLong(s);

                }else{

                    try{
                    fio[k] = s;
                    k++;
                    }catch(Exception e){
                        throw new NameFormatException();
                    }

                }
        }
        return new User(fio, dateOfBirth, phoneNumber, sex);
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            long l = Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int checkString(String str){
        String[] info = str.split(" ");
        if(info.length < 5){
            return -1;
        }else if(info.length > 6){
            return -2;
        }else{
            return 0;
        }
    }

    private boolean isDateOfBirth(String s){
        return s.length() == 10 && isDigit(s.substring(0, 2)) && isDigit(s.substring(3, 5)) && isDigit(s.substring(6));
    }

}