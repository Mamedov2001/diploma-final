package kz.careerguidance.applicationapi.mapper;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import kz.careerguidance.applicationapi.dto.university.UniversityDto;
import kz.careerguidance.applicationapi.entity.university.Subject;
import kz.careerguidance.applicationapi.entity.university.Tag;
import kz.careerguidance.applicationapi.entity.university.University;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-13T15:44:15+0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class UniversityMapperImpl implements UniversityMapper {

    @Override
    public UniversityDto toUniversityDto(University university) {
        if ( university == null ) {
            return null;
        }

        UniversityDto universityDto = new UniversityDto();

        universityDto.setId( university.getId() );
        universityDto.setName( university.getName() );
        Set<Tag> set = university.getTags();
        if ( set != null ) {
            universityDto.setTags( new LinkedHashSet<Tag>( set ) );
        }
        Set<Subject> set1 = university.getSubjects();
        if ( set1 != null ) {
            universityDto.setSubjects( new LinkedHashSet<Subject>( set1 ) );
        }
        universityDto.setStatus( university.getStatus() );
        universityDto.setImage( university.getImage() );
        universityDto.setBenefits( university.getBenefits() );
        universityDto.setLocation( university.getLocation() );
        universityDto.setPassScores( university.getPassScores() );
        universityDto.setBudget( university.getBudget() );
        universityDto.setOffBudget( university.getOffBudget() );
        universityDto.setHasHotel( university.getHasHotel() );
        universityDto.setHasMilitaryDepartment( university.getHasMilitaryDepartment() );
        universityDto.setDescription( university.getDescription() );
        universityDto.setRating( university.getRating() );
        universityDto.setLink( university.getLink() );

        return universityDto;
    }

    @Override
    public University toUniversityEntity(UniversityDto universityDTO) {
        if ( universityDTO == null ) {
            return null;
        }

        University university = new University();

        university.setId( universityDTO.getId() );
        university.setName( universityDTO.getName() );
        university.setStatus( universityDTO.getStatus() );
        Set<Subject> set = universityDTO.getSubjects();
        if ( set != null ) {
            university.setSubjects( new LinkedHashSet<Subject>( set ) );
        }
        Set<Tag> set1 = universityDTO.getTags();
        if ( set1 != null ) {
            university.setTags( new LinkedHashSet<Tag>( set1 ) );
        }
        university.setImage( universityDTO.getImage() );
        university.setDescription( universityDTO.getDescription() );
        university.setBenefits( universityDTO.getBenefits() );
        university.setLocation( universityDTO.getLocation() );
        university.setPassScores( universityDTO.getPassScores() );
        university.setBudget( universityDTO.getBudget() );
        university.setOffBudget( universityDTO.getOffBudget() );
        university.setHasHotel( universityDTO.getHasHotel() );
        university.setHasMilitaryDepartment( universityDTO.getHasMilitaryDepartment() );
        university.setRating( universityDTO.getRating() );
        university.setLink( universityDTO.getLink() );

        return university;
    }
}
