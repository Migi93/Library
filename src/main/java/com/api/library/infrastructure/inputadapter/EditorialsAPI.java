package com.api.library.infrastructure.inputadapter;

import com.api.library.domain.entity.Editorials;
import com.api.library.infrastructure.inputport.EditorialsInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/editorials")
public class EditorialsAPI {
    @Autowired
    EditorialsInputPort editorialsInputPort;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Editorials getEditorial(@PathVariable("id") int editorialId) {
        return this.editorialsInputPort.getEditorial(editorialId);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Editorials> getEditorials() {
        return this.editorialsInputPort.listEditorials();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Integer> insertEditorial(@RequestBody Editorials editorials) {
        editorialsInputPort.createEditorial(editorials);
        return Map.of("id", editorials.getEditorialId());
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void updateEditorial(@RequestBody Editorials editorials) {
        editorialsInputPort.updateEditorial(editorials);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@RequestParam("id") int editorialId) {
        editorialsInputPort.deleteEditorial(editorialId);
    }
}
