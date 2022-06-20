package com.isu.cs309.biditall.controller;

import com.isu.cs309.biditall.extension.FileResponseMessage;
import com.isu.cs309.biditall.message.ResponseMessage;
import com.isu.cs309.biditall.model.FileData;
import com.isu.cs309.biditall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filesSaving")
@CrossOrigin("http://localhost:8081")
public class FilesController {

    ItemService.FileService fileService;

    @Autowired
    public FilesController(ItemService.FileService fileService)
    {
        this.fileService = fileService;
    }


    @PostMapping("/single")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.save(file);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseMessage("Could not upload the file: " + file.getOriginalFilename() + "!"));
        }
    }

    @PostMapping("/testByteArray")
    public void testFile(@RequestParam("file") byte [] imageData) {

        System.out.println(Arrays.toString(imageData));
//        try {
//            fileService.save(file);
//
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(new ResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
//                    .body(new ResponseMessage("Could not upload the file: " + file.getOriginalFilename() + "!"));
//        }
    }
    /**
     * Request to save multiple image files
     * @param files
     * @return
     */
    @PostMapping("/multiple")
    public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("files") MultipartFile [] files) {
        try {
            List<String> f = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file -> {
                fileService.save(file);
                f.add(file.getOriginalFilename());
            });

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseMessage("Given files uploaded : " + f));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseMessage("Failed to upload files"));
        }
    }

    @GetMapping
    public ResponseEntity<List<FileData>> getListFiles() {
        List<FileData> fileInfos = fileService.loadAll()
                .stream()
                .map(this::pathToFileData)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(fileInfos);
    }

    @DeleteMapping
    public void delete() {
        fileService.deleteAll();
    }

    private FileData pathToFileData(Path path) {
        FileData fileData = new FileData();
        String filename = path.getFileName()
                .toString();
        fileData.setFilename(filename);
        fileData.setUrl(MvcUriComponentsBuilder.fromMethodName(FilesController.class, "getFile", filename)
                .build()
                .toString());
        try {
            fileData.setSize(Files.size(path));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getMessage());
        }

        return fileData;
    }

    @GetMapping("{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
