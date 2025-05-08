package com.example.BasicToAdvance.Jarnal.Controller;

import com.example.BasicToAdvance.Jarnal.Dto.Jarnal;
import com.example.BasicToAdvance.Jarnal.Services.JarnalService;
import com.example.BasicToAdvance.Jarnal.Dto.JarnalResponse;
import com.example.BasicToAdvance.contraint.CommonApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(CommonApi.BASE_URL + "/jarnal")
public class JarnalController extends CommonApi {
    private final JarnalService jarnalService;

    public JarnalController(JarnalService jarnalService) {
        this.jarnalService = jarnalService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addJarnal(
            @RequestBody Jarnal jarnal
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println("jarnal: "+jarnal.getContent()+" "+email);
        try {
            JarnalResponse savedJarnal = jarnalService.addJarnal(jarnal,email);
            return new ResponseEntity<>(savedJarnal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getJarnal(@RequestParam UUID id) {  // ✅ Changed to @RequestParam
        try {
            JarnalResponse jarnal = jarnalService.getJarnal(id);
            return new ResponseEntity<>(jarnal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByTitle")
    public ResponseEntity<?> getJarnalByName(@RequestParam String title) {  // ✅ Changed to @RequestParam
        try {
            JarnalResponse jarnal = jarnalService.getJarnalByName(title);
            return new ResponseEntity<>(jarnal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllJarnals() {
        try {
            List<JarnalResponse> jarnals = jarnalService.getAllJarnals();
            return new ResponseEntity<>(jarnals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")  // ✅ Changed from @PostMapping to @PutMapping
    public ResponseEntity<?> updateJarnal(@RequestBody Jarnal jarnal) {
        try {
            JarnalResponse updatedJarnal = jarnalService.updateJarnal(jarnal);
            return new ResponseEntity<>(updatedJarnal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")  // ✅ Changed from @GetMapping to @DeleteMapping
    public ResponseEntity<?> deleteJarnal(@RequestParam UUID id) {  // ✅ Changed to @RequestParam
        try {
            jarnalService.deleteJarnal(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
