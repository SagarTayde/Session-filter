package com.osi.oneconnect.service.impl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {

    @Value("${upload.directory}") // Configure the upload directory in application.properties
    private String uploadDirectory;

    public String uploadFile(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "File is empty. Please select a file to upload.";
            }

            // Generate a unique filename (you might want to use a more sophisticated approach)
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            
            Path uploadPath = Path.of(uploadDirectory); // Use Java Path to handle paths
            Path filePath = uploadPath.resolve(fileName);

            // Copy the uploaded file to the specified directory
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // You can now perform additional processing if needed, e.g., saving to a database

            return "File uploaded successfully: " + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error uploading the file: " + e.getMessage();
        }
    }
}


