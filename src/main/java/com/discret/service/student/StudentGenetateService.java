package com.discret.service.student;

import com.discret.entity.Student;
import com.discret.repository.StudentsRepository;
import com.ibm.icu.text.Transliterator;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class StudentGenetateService {

    private final StudentsRepository studentsRepository;
    private final StudentService studentService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public static final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";


    public String generateRandomPassword(){
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@$%&";
        final int PASSWORD_LENGTH = 8;
        final Random RANDOM = new Random();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            password.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return password.toString();

    }

    public String generateLogin( String firstName, String lastName){
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String baseLogin = firstName.toLowerCase().charAt(0) + "." + lastName.toLowerCase();
       baseLogin =  toLatinTrans.transliterate(baseLogin);
       String login = baseLogin;


        int counter = 1;
        while (studentsRepository.existsByLogin(login)) {
            login = baseLogin + counter;
            counter++;
        }
        return login;
    }

    public String[] addStudents(String students, Long groupId) {


        String result = "";
        for (String student : students.split("\r\n")) {
            String[] parts = student.split(" ");
            if (parts.length < 2) continue; // Пропускаем строки с некорректным форматом

            String firstName = parts[1];
            String lastName = parts[0];
            String login =generateLogin(firstName,lastName);
            String rawPassword = generateRandomPassword();

            studentService.saveStudent(login, rawPassword, lastName, firstName, null,"ROLE_STUDENT", groupId);
            result = result + lastName + " " + firstName + " " +  login + " " + rawPassword + "\r\n";
        }

        return result.split("\r\n");
    }



}
