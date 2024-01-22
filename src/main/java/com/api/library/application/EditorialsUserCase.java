package com.api.library.application;

import com.api.library.application.Enum.Amount;
import com.api.library.application.exceptions.ObjectNotFoundException;
import com.api.library.application.exceptions.ObjectAlreadyExistsException;
import com.api.library.application.utils.ValidationsUtils;
import com.api.library.domain.model.Editorials;
import com.api.library.infrastructure.inputport.EditorialsInputPort;
import com.api.library.infrastructure.outputport.EditorialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditorialsUserCase implements EditorialsInputPort {
    @Autowired
    EditorialsRepository editorialsRepository;
    @Autowired
    ValidationsUtils validationsUtils;

    @Override
    public Editorials getEditorial(int editorialId) {
        notExistEditorial(editorialId);
        return editorialsRepository.getEditorial(editorialId);
    }

    @Override
    public List<Editorials> listEditorials() {
        return editorialsRepository.getEditorials();
    }

    @Override
    public void createEditorial(Editorials editorials) {
        existEditorial(editorials.getName());
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_50.getValue(), editorials.getName().length(), "name");
        validationsUtils.validateNotIsEmpty(editorials.getName(), "name");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_100.getValue(), editorials.getAddress().length(), "address");
        validationsUtils.validateNotIsEmpty(editorials.getAddress(), "address");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_9.getValue(), editorials.getPhone().length(), "phone");
        validationsUtils.validateNotIsEmpty(editorials.getPhone(), "phone");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_50.getValue(), editorials.getPhone().length(), "phone");
        editorialsRepository.updateEditorial(editorials);
        editorialsRepository.createEditorial(editorials);
    }

    @Override
    public void updateEditorial(Editorials editorials) {
        notExistEditorial(editorials.getEditorialId());
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_50.getValue(), editorials.getName().length(), "name");
        validationsUtils.validateNotIsEmpty(editorials.getName(), "name");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_100.getValue(), editorials.getAddress().length(), "address");
        validationsUtils.validateNotIsEmpty(editorials.getAddress(), "address");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_9.getValue(), editorials.getPhone().length(), "phone");
        validationsUtils.validateNotIsEmpty(editorials.getPhone(), "phone");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_50.getValue(), editorials.getPhone().length(), "phone");
        editorialsRepository.updateEditorial(editorials);
    }

    @Override
    public void deleteEditorial(int editorialId) {
        notExistEditorial(editorialId);
        editorialsRepository.deleteEditorial(editorialId);
    }

    private void existEditorial(String nameEditorial) {
        if (editorialsRepository.existEditorial(nameEditorial) > 0) {
            throw new ObjectAlreadyExistsException("Editorial", HttpStatus.CONFLICT);
        }
    }

    private void notExistEditorial(int editorialId) {
        if (editorialsRepository.notExistEditorial(editorialId) < 1) {
            throw new ObjectNotFoundException("Editorial", HttpStatus.NOT_FOUND);
        }
    }
}
