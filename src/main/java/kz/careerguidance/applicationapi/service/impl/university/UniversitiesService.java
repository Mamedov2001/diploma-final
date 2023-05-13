package kz.careerguidance.applicationapi.service.impl.university;

import kz.careerguidance.applicationapi.dto.university.UniversityDto;
import kz.careerguidance.applicationapi.entity.university.Subject;
import kz.careerguidance.applicationapi.entity.university.Tag;
import kz.careerguidance.applicationapi.entity.university.University;
import kz.careerguidance.applicationapi.exceptions.NotFoundException;
import kz.careerguidance.applicationapi.mapper.UniversityMapper;
import kz.careerguidance.applicationapi.repository.university.SpecialitiesRepository;
import kz.careerguidance.applicationapi.repository.university.SubjectRepository;
import kz.careerguidance.applicationapi.repository.university.TagRepository;
import kz.careerguidance.applicationapi.repository.university.UniversitiesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UniversitiesService {

    private final UniversitiesRepository universitiesRepository;

    private final SpecialitiesRepository specialitiesRepository;

    private final TagRepository tagRepository;

    private final SubjectRepository subjectRepository;

    private final UniversityMapper universityMapper;

    public UniversitiesService(UniversitiesRepository universitiesRepository, SpecialitiesRepository specialitiesRepository, TagRepository tagRepository, SubjectRepository subjectRepository, UniversityMapper universityMapper) {
        this.universitiesRepository = universitiesRepository;
        this.specialitiesRepository = specialitiesRepository;
        this.tagRepository = tagRepository;
        this.subjectRepository = subjectRepository;
        this.universityMapper = universityMapper;
    }

    public Optional<University> get(Long id) {
        return universitiesRepository.findById(id);
    }

    @Transactional
    public UniversityDto create(UniversityDto universityDTO) {
        if (null != universityDTO.getTags()) {
            List<Integer> tags = tagRepository.findAll().stream()
                    .map(Tag::getId).toList();
            universityDTO.getTags().forEach(t -> {
                if (!tags.contains(t.getId()))
                    throw new NotFoundException("There is no tag with id " + t.getId());
            });
        }
        if (null != universityDTO.getSubjects()) {
            List<Integer> subjects = subjectRepository.findAll()
                    .stream().map(Subject::getId).toList();
            universityDTO.getSubjects().forEach(s -> {
                if (!subjects.contains(s.getId()))
                    throw new NotFoundException("There is no subject with id " + s.getId());
            });
        }

        return universityMapper.toUniversityDto(universitiesRepository
                .save(universityMapper
                        .toUniversityEntity(universityDTO)));
    }

    @Transactional
    public void update(Long specialityId, Long universityId) {
        universitiesRepository.findById(universityId)
                .orElseThrow(() -> new NotFoundException("University not found"))
                .getSpecialities().add(specialitiesRepository.findById(specialityId)
                        .orElseThrow(() -> new NotFoundException("Speciality not found"))
                );
    }


    @Transactional
    public UniversityDto update(Long id, University universityDto) {
        University universityToUpdate = universitiesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("University not found"));

        if (null != universityDto.getName()) {
            universityToUpdate.setName(universityDto.getName());
        }
        if (null != universityDto.getHasHotel()) {
            universityToUpdate.setHasHotel(universityDto.getHasHotel());
        }
        if (null != universityDto.getStatus()) {
            universityToUpdate.setStatus(universityDto.getStatus());
        }
        if (null != universityDto.getBenefits()) {
            universityToUpdate.setHasHotel(universityDto.getHasHotel());
        }
        if (null != universityDto.getHasMilitaryDepartment()) {
            universityToUpdate.setBenefits(universityDto.getBenefits());
        }
        if (null != universityDto.getDescription()) {
            universityToUpdate.setDescription(universityDto.getDescription());
        }
        if (null != universityDto.getBudget()) {
            universityToUpdate.setBudget(universityDto.getBudget());
        }
        if (null != universityDto.getImage()) {
            universityToUpdate.setImage(universityDto.getImage());
        }
        if (null != universityDto.getLocation()) {
            universityToUpdate.setLocation(universityDto.getLocation());
        }
        if (null != universityDto.getRating()) {
            universityToUpdate.setRating(universityDto.getRating());
        }
        if (null != universityDto.getPassScores()) {
            universityToUpdate.setPassScores(universityDto.getPassScores());
        }
        if (null != universityDto.getSpecialities()) {
            universityToUpdate.setSpecialities(universityDto.getSpecialities());
        }
        if (null != universityDto.getSubjects()) {
            universityToUpdate.setSubjects(universityDto.getSubjects());
        }
        if (null != universityDto.getTags()) {
            universityToUpdate.setTags(universityDto.getTags());
        }
        if (null != universityDto.getOffBudget()) {
            universityToUpdate.setOffBudget(universityDto.getOffBudget());
        }
        if (null != universityDto.getLink()) {
            universityToUpdate.setLink(universityDto.getLink());
        }
        if (null != universityDto.getLink()) {
            universityToUpdate.setLink(universityDto.getLink());
        }
        return universityMapper.toUniversityDto(universitiesRepository.save(universityToUpdate));
    }


    @Transactional
    public UniversityDto delete(Long id) {
        return universitiesRepository.findById(id).map(
                university -> {
                    universitiesRepository.delete(university);
                    return universityMapper.toUniversityDto(university);
                }
        ).orElseThrow(
                () -> new NotFoundException("University not found")
        );
    }

    public Optional<University> findByName(String name) {
        return universitiesRepository.findByName(name);
    }

    public University findByNameToDisplay(String name) {
        return universitiesRepository.findByName(name).orElseThrow(() -> new NotFoundException("University not found"));
    }

    public List<University> findAll() {
        return universitiesRepository.findAll();
    }

    public List<University> searchUniversitiesBySpecialityName(String specialityName) {
        return universitiesRepository.findBySpecialityName(specialityName);
    }


    public List<University> findByNameContaining(String query) {
        if (!query.trim().isEmpty()) {
            return universitiesRepository.findByNameStartingWith(query);
        } else {
            return Collections.emptyList();
        }
    }
}
