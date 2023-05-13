package kz.careerguidance.applicationapi.controller.university;

import kz.careerguidance.applicationapi.entity.university.Subject;
import kz.careerguidance.applicationapi.service.university.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subjects")
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Subject s) {
        return ResponseEntity.ok(service.create(s));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Subject s) {
        return ResponseEntity.ok(service.update(id, s));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
