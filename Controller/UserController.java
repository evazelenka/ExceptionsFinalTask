package Attestation.Controller;

import Attestation.Service.FileService;
import Attestation.Service.UserService;
import Attestation.Model.User;

public class UserController {
    UserService service = new UserService();
    FileService file = new FileService();

    public User createUser(String str) throws Exception {
        return service.createUser(str);
    }

    public void writeInFile(User user) throws Exception {
        file.writeInFile(user);
    }

    public int checkString(String str){
        return service.checkString(str);
    }

}
