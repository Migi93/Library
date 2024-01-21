package com.api.library.infrastructure.inputport;

import com.api.library.domain.entity.Editorials;

import java.util.List;

public interface EditorialsInputPort {

    Editorials getEditorial(int editorialId);

    List<Editorials> listEditorials();

    void createEditorial(Editorials editorials);

    void updateEditorial(Editorials editorials);

    void deleteEditorial(int editorialId);

}
