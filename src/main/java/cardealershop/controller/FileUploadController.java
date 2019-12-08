package cardealershop.controller;

import cardealershop.storage.FileSystemStorageService;
import cardealershop.storage.StorageFileNotFoundException;
import cardealershop.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {

    private final FileSystemStorageService fileSystemStorageService;

    public FileUploadController(FileSystemStorageService fileSystemStorageService){
        this.fileSystemStorageService = fileSystemStorageService;
    }


    @GetMapping("/file")
    public String listUploadedFiles(Model model) throws IOException {
        if(!fileSystemStorageService.equals(null)) {
        model.addAttribute("files", fileSystemStorageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));}

        return "uploadForm";
    }



    @PostMapping("/file")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        fileSystemStorageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/file";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
