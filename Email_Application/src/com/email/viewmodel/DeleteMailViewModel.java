package com.email.viewmodel;

import com.email.dto.Repository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteMailViewModel {

    public void deleteMail(String from, String to, String content) throws IOException {
        if (from == null || to == null || content == null) {
            throw new IllegalArgumentException("Sender, recipient, and content cannot be null.");
        }

        String src = Repository.getInstance().src; // Path to the original file
        String temp = "G:\\JavaConsole\\Email_Application\\src\\com\\email\\dto\\temp.txt"; // Path to the temporary file

        // Add exception handling for file I/O operations
        try (
            FileInputStream input = new FileInputStream(src);
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(reader);
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
        ) {
            String current;
            while ((current = bufferedReader.readLine()) != null) {
                // Write all lines except the one that matches the mail entry (trim whitespace to avoid matching issues)
                String trimmed[] = current.split(" ");

                if (!(trimmed[0].equals(from) && trimmed[1].equals(to) && trimmed[2].equals(content))) {
                    writer.write(current + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error occurred while processing the file.");
        }

        // Replace original file with the updated file
        File inputFile = new File(src);
        File tempFile = new File(temp);
        String filePath = "G:\\JavaConsole\\Email_Application\\src\\com\\email\\dto\\temp.txt";
       File file = new File(filePath);
        // Delete the original file and rename the temp file
        if (!inputFile.delete()) {
            System.out.println("Could not delete original file.");
        } else if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file to original file.");
        } else {
            file.createNewFile();
            System.out.println("Mail deleted successfully and temp file renamed.");
        }
    }
}
