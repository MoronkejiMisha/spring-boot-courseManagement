package com.Project.CourseManagement.services.Implementations;

import com.Project.CourseManagement.dto.CreatorDto;
import com.Project.CourseManagement.dto.CreatorResponseDto;
import com.Project.CourseManagement.models.Creator;
import com.Project.CourseManagement.repositories.CreatorRepository;
import com.Project.CourseManagement.services.CreatorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreatorServiceImpl implements CreatorService {
    private final CreatorRepository creatorRepository;
    private  ModelMapper mapper = new ModelMapper();

    public void addCreator(CreatorDto creatorDto) {
        creatorRepository.save(mapper.map(creatorDto, Creator.class));
    }

    public List<CreatorResponseDto> findAllCreators() {
        return creatorRepository.findAll()
                .stream().map(creator -> mapper.map(creator, CreatorResponseDto.class)).toList();
    }

    public CreatorDto findCreatorByName(String firstName, String lastName) {
        var creator = creatorRepository.findByFirstNameAndLastNameIgnoreCaseContaining(firstName, lastName);
        return mapper.map(creator, CreatorDto.class);
    }
    public CreatorResponseDto findCreatorById(Integer id) {
        var creator = creatorRepository.findById(id);
        return mapper.map(creator, CreatorResponseDto.class);
    }


    public List<CreatorResponseDto> findCreatorByFirstName(String firstName) {
        return creatorRepository.findByFirstNameIgnoreCaseContaining(firstName).
                stream().map(creator -> mapper.map(creator, CreatorResponseDto.class)).toList();
    }

    public List<CreatorResponseDto> findCreatorByLastName(String lastName) {
        return creatorRepository.findByLastNameIgnoreCaseContaining(lastName).
                stream().map(creator -> mapper.map(creator, CreatorResponseDto.class)).toList();
    }

    public void deleteCreator(Integer id) {
        creatorRepository.deleteById(id);
    }
}

