package com.lego.care4you.service;

import com.lego.care4you.domain.SafetyEquipment;
import com.lego.care4you.dto.SafetyEquipmentRequestDTO;
import com.lego.care4you.repository.SafetyEquipmentRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@Service
public class SafetyEquipmentService extends GenericService<SafetyEquipment, SafetyEquipmentRequestDTO> {

    @Autowired
    private SafetyEquipmentRepository safetyEquipmentRepository;

    @Override
    public List<SafetyEquipment> findAll() {
        return safetyEquipmentRepository.findAll();
    }

    @Override
    public SafetyEquipment findById(String id) {
        return safetyEquipmentRepository.findOne(id);
    }

    @Override
    public SafetyEquipment delete(String id) {
        SafetyEquipment safetyEquipment = findById(id);
        safetyEquipmentRepository.delete(safetyEquipment);
        return safetyEquipment;
    }

    @Override
    public SafetyEquipment insert(SafetyEquipmentRequestDTO dto) {
        SafetyEquipment safetyEquipment = buildCreateSafetyEquipment(dto);
        safetyEquipment = safetyEquipmentRepository.insert(safetyEquipment);
        return safetyEquipment;
    }

    @Override
    public SafetyEquipment update(String id, SafetyEquipmentRequestDTO dto) {
        SafetyEquipment safetyEquipment = findById(id);
        buildUpdateSafetyEquipment(safetyEquipment, dto);
        safetyEquipmentRepository.insert(safetyEquipment);
        return safetyEquipment;
    }

    private SafetyEquipment buildCreateSafetyEquipment(SafetyEquipmentRequestDTO dto) {
        SafetyEquipment safetyEquipment = new SafetyEquipment();
        safetyEquipment.setName(dto.getName());
        safetyEquipment.setDescription(dto.getDescription());
        safetyEquipment.setStock(dto.getStock());

        return safetyEquipment;
    }

    private void buildUpdateSafetyEquipment(SafetyEquipment safetyEquipment, SafetyEquipmentRequestDTO dto) {
        safetyEquipment.setName(dto.getName());
        safetyEquipment.setDescription(dto.getDescription());
        safetyEquipment.setStock(dto.getStock());
    }
}