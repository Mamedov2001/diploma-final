package kz.careerguidance.applicationapi.mapper;

import javax.annotation.processing.Generated;
import kz.careerguidance.applicationapi.dto.university.SpecialityDto;
import kz.careerguidance.applicationapi.entity.university.Speciality;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-13T15:44:16+0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class SpecialityMapperImpl implements SpecialityMapper {

    @Override
    public SpecialityDto toSpecialityDto(Speciality s) {
        if ( s == null ) {
            return null;
        }

        String name = null;
        String description = null;

        name = s.getName();
        description = s.getDescription();

        SpecialityDto specialityDto = new SpecialityDto( name, description );

        specialityDto.setCategory( s.getCategory() );
        specialityDto.setCategoryImage( s.getCategoryImage() );
        specialityDto.setImage( s.getImage() );
        specialityDto.setWhatMakes( s.getWhatMakes() );
        specialityDto.setRequiredKnowledge( s.getRequiredKnowledge() );
        specialityDto.setSalaryInfo( s.getSalaryInfo() );

        return specialityDto;
    }

    @Override
    public Speciality toSpecialityEntity(SpecialityDto s) {
        if ( s == null ) {
            return null;
        }

        Speciality speciality = new Speciality();

        speciality.setCategory( s.getCategory() );
        speciality.setCategoryImage( s.getCategoryImage() );
        speciality.setImage( s.getImage() );
        speciality.setName( s.getName() );
        speciality.setDescription( s.getDescription() );
        speciality.setWhatMakes( s.getWhatMakes() );
        speciality.setRequiredKnowledge( s.getRequiredKnowledge() );
        speciality.setSalaryInfo( s.getSalaryInfo() );

        return speciality;
    }
}
