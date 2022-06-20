package com.isu.cs309.biditall.service.impl;

import com.isu.cs309.biditall.service.ItemService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements ItemService.FileService {


    private final Path directory = Paths.get("Images");

    /**
     * create directory
     */
    @Override
    public void init() {
        try{
            Files.createDirectories(directory);
        }catch (IOException e){
            throw new RuntimeException("ERROR : Unable to initialize directory.");
        }
    }

    /**
     * Save the multipart file
     * @param file
     */
    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.directory.resolve(file.getOriginalFilename()));
        }catch (Exception e){
            throw new RuntimeException("ERROR : Unable to store file " + e.getMessage());
        }
    }

    /**
     * Load the multipart file
     * @param filename
     * @return
     */
    @Override
    public Resource load(String filename)
    {
      try
      {
          Path file = directory.resolve(filename);
          Resource resource = new UrlResource(file.toUri());

          if(resource.exists() || resource.isReadable())
              return resource;
          else
              throw new RuntimeException("ERROR : Unable to read the file.");
      }catch (MalformedURLException e){
          throw new RuntimeException("ERROR : " + e.getMessage());
      }
    }

    /**
     * Delete all associated multi part files
     */
    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(this.directory.toFile());
    }

    /**
     * Show all multipart files
     * @return
     */
    @Override
    public List<Path> loadAll() {
        try {

            if(Files.exists(this.directory)) {
                return Files.walk(this.directory,1)
                        .filter(path -> !path.equals(this.directory))
                        .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }catch (IOException e){
            throw new RuntimeException("ERROR : Unable to list files");
        }
    }
}
