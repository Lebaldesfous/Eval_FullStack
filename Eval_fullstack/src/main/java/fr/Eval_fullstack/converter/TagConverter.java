package fr.Eval_fullstack.converter;

import fr.Eval_fullstack.dto.response.TagDto;
import fr.Eval_fullstack.entity.TagEntity;

import java.util.List;

public class TagConverter {

    public static TagEntity dtoToEntity(TagDto tagDto) {
        return TagEntity.builder()
                .id(tagDto.getId())
                .nom(tagDto.getNom())
                .build();
    }

    public static TagDto entityToDto(TagEntity tagEntity) {
        return TagDto.builder()
                .id(tagEntity.getId())
                .nom(tagEntity.getNom())
                .build();
    }

    public static List<TagEntity> dtoToEntity(List<TagDto> tagDtos) {
        return tagDtos.stream().map(TagConverter::dtoToEntity).toList();
    }

    public static List<TagDto> entityToDto(List<TagEntity> tagEntities) {
        return tagEntities.stream().map(TagConverter::entityToDto).toList();
    }
}
