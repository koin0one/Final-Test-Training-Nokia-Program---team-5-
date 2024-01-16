package com.finaltraining.hotelbooking.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public interface UploadFileToServer {
    void uploadImageToServer(MultipartFile file, String fileName, String type) throws IOException, FileAlreadyExistsException;
    String getCheckSumImageFile(MultipartFile file) throws IOException;
}
