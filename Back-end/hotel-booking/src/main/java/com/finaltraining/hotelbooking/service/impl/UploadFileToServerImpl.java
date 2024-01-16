package com.finaltraining.hotelbooking.service.impl;

import com.finaltraining.hotelbooking.service.UploadFileToServer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class UploadFileToServerImpl implements UploadFileToServer {

    private static final File CURRENT_DIRECTORY = new File(System.getProperty("user.dir"));

    private static final String UPLOAD_DIRECTORY = CURRENT_DIRECTORY.getParent() + "/upload/";

    public UploadFileToServerImpl() throws IOException {
        File uploadDir = new File(UPLOAD_DIRECTORY);
        if (!Files.exists(Path.of(uploadDir.getAbsolutePath()))){
            Files.createDirectories(Path.of(uploadDir.getAbsolutePath()));
        }
    }

    @Override
    public String getCheckSumImageFile(MultipartFile file) throws IOException {
        String checksum = DigestUtils.md5DigestAsHex(file.getInputStream()).toUpperCase();
        String fileName = checksum + ".png";
        return fileName;
    }
    @Override
    public void uploadImageToServer(MultipartFile file, String fileName, String type) throws IOException, FileAlreadyExistsException {
        try {
            String TYPE_DIRECTORY = UPLOAD_DIRECTORY + type;
            File typeDir = new File(TYPE_DIRECTORY);
            if (!Files.exists(Path.of(typeDir.getAbsolutePath()))){
                Files.createDirectories(Path.of(typeDir.getAbsolutePath()));
            }
            Files.copy(file.getInputStream(), Path.of(typeDir.getAbsolutePath()).resolve(fileName));
        } catch (FileAlreadyExistsException e) {
            throw new FileAlreadyExistsException("File already exists");
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
