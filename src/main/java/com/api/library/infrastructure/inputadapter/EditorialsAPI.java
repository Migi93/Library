package com.api.library.infrastructure.inputadapter;

import com.api.library.domain.entity.Editorials;
import com.api.library.infrastructure.inputport.EditorialsInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/editorials")
public class EditorialsAPI {
    @Autowired
    EditorialsInputPort editorialsInputPort;

    @GetMapping("/{id}")
    public ResponseEntity<Editorials> getEditorial(@PathVariable("id") int editorialId) {
        return new ResponseEntity<>(this.editorialsInputPort.getEditorial(editorialId), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Editorials>> getEditorials() {
        return new ResponseEntity<>(this.editorialsInputPort.listEditorials(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Integer>> insertEditorial(@RequestBody Editorials editorials) {
        editorialsInputPort.createEditorial(editorials);
        return new ResponseEntity<>(Map.of("id", editorials.getEditorialId()), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<HttpStatus> updateEditorial(@RequestBody Editorials editorials) {
        editorialsInputPort.updateEditorial(editorials);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<HttpStatus> deleteBook(@RequestParam("id") int editorialId) {
        editorialsInputPort.deleteEditorial(editorialId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
