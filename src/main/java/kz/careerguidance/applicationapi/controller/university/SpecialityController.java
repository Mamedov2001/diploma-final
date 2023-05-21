package kz.careerguidance.applicationapi.controller.university;


import kz.careerguidance.applicationapi.dto.university.SpecialityDto;
import kz.careerguidance.applicationapi.entity.university.Speciality;
import kz.careerguidance.applicationapi.exceptions.SpecialityCreateException;
import kz.careerguidance.applicationapi.service.impl.university.SpecialitiesService;
import kz.careerguidance.applicationapi.service.impl.university.UniversitiesService;
import kz.careerguidance.applicationapi.validators.SpecialityValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialities")
public class SpecialityController {
    private final SpecialitiesService specialitiesService;
    private final UniversitiesService universitiesService;
    private final SpecialityValidator specialityValidator;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Speciality>> getAllSpecialities() {
        return ResponseEntity.ok(specialitiesService.findAll());
    }

    @PostMapping()
    public ResponseEntity<?> createSpeciality(
            @RequestBody @Valid SpecialityDto specialityDTO,
            BindingResult bindingResult) {
        specialityValidator.validate(specialityDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            throw new SpecialityCreateException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        Speciality speciality = convertToSpeciality(specialityDTO);
        return ResponseEntity.ok(specialitiesService.save(speciality));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateSpeciality(@PathVariable Long id,
                                              @RequestBody @Valid SpecialityDto specialityDTO,
                                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new SpecialityCreateException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        return ResponseEntity.ok(specialitiesService.update(id, convertToSpeciality(specialityDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUniversity(@PathVariable Long id) {
        return ResponseEntity.ok(specialitiesService.delete(id));
    }

    @PostMapping("/{id}/addUniversity")
    public ResponseEntity<?> addUniversity(@PathVariable Long id,
                                                    @RequestParam Long universityId) {
        universitiesService.update(id, universityId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Speciality>> searchSpecialitiesStartingWith(@RequestParam String name) {
        return new ResponseEntity<>(specialitiesService.findByNameContaining(name), HttpStatus.OK);
    }

    public Speciality convertToSpeciality(SpecialityDto specialityDTO) {
        return modelMapper.map(specialityDTO, Speciality.class);
    }

}
