package com.ms.grademaster.comons.mapper;

import com.ms.grademaster.comons.dto.EstadoDto;
import com.ms.grademaster.comons.dto.MateriaDto;
import com.ms.grademaster.comons.entity.MateriaEntity;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

import static com.ms.grademaster.comons.utils.utilities.Utilidades.checkType;

@Mapper(componentModel = "spring")
public interface MateriaMapper {

    MateriaEntity dtoToEntity(MateriaDto dto);

    List<MateriaDto> listEntityToListDto(List<MateriaEntity> entity);
    List<MateriaEntity> listDtoToListEntity(List<MateriaDto> entity);

    default List<MateriaDto> listObjectToListDto(List<Object[]> objects) {
        List<MateriaDto> materias = new ArrayList<>();
        for(Object[] objeto : objects){
            MateriaDto materiaDto = new MateriaDto();
            EstadoDto estadoDto = new EstadoDto();
            estadoDto.setNombre(checkType(objeto[3], String.class).orElse(null));
            materiaDto.setCodigo(checkType(objeto[0], String.class).orElse(null));
            materiaDto.setNombre(checkType(objeto[1], String.class).orElse(null));
            materiaDto.setNCreditos(checkType(objeto[2], Short.class).orElse(null));
            materiaDto.setEstadoEntityFk(estadoDto);
            materias.add(materiaDto);
        }
        return materias;
    }

    default List<MateriaDto> lisObjectToListMateriaDocente(List<Object[]> objects) {
        List<MateriaDto> materias = new ArrayList<>();
        for(Object[] objeto : objects){
            MateriaDto materiaDto = new MateriaDto();
            materiaDto.setCodigo(checkType(objeto[0], String.class).orElse(null));
            materiaDto.setNombre(checkType(objeto[1], String.class).orElse(null));
            materias.add(materiaDto);
        }
        return materias;
    }

}
