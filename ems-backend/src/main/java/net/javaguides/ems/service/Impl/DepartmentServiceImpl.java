package net.javaguides.ems.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.Mapper.DepartmentMapper;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.exception.ResourceNotFound;
import net.javaguides.ems.repository.DepartmentRepo;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepo departmentRepo;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepo.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepo.findById(departmentId).orElseThrow(
                () -> new ResourceNotFound("Department is not exists with a given id:" + departmentId)
        );
        return DepartmentMapper.mapToDepartmentDto(department) ;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepo.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepo.findById(departmentId).orElseThrow(
                () -> new ResourceNotFound("Department is not exists with a given id:" + departmentId)
        );
        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());

        Department savedDepartment = departmentRepo.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepo.findById(departmentId).orElseThrow(
                () -> new ResourceNotFound("Department is not exists with a given id:" + departmentId)
        );
        departmentRepo.deleteById(departmentId);
    }
}
