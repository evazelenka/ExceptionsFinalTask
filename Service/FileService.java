package Attestation.Service;

import Attestation.Model.User;

import java.io.*;

public class FileService {

    private File createFile(User user) throws Exception {
        String name = user.getLastName();
        File file = new File("Attestation/Users/" + name + ".txt");
        try {
            if (file.createNewFile()) System.out.println("файл создан");
            else if (file.exists()) {
                System.out.println("файл найден");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    public void writeInFile(User user) throws Exception {
        File file = createFile(user);
        try (FileWriter writer = new FileWriter(file,true);
             BufferedWriter bufferWriter = new BufferedWriter(writer)){
            if(isFileEmpty(file)){
                bufferWriter.write(user + "\n");
            }else if (hasUser(file, user)){
                System.out.println("пользователь уже записан в файл '" + file.getName() + "'");
            }else{
                bufferWriter.write(user + "\n");
                System.out.println("данные записаны");
            }
        }
    }

    private boolean isFileEmpty(File file){
        return file.length() == 0;
    }

    private boolean hasUser(File file, User user)throws IOException{
        try(FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader)) {
            String temp;
            while ((temp = reader.readLine()) != null) {
                if (temp.equals(user.toString())) {
                    return true;
                }
            }
            return false;
        }
    }
}
