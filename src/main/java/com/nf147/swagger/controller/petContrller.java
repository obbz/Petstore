package com.nf147.swagger.controller;

import com.nf147.swagger.dao.PetMapper;
import com.nf147.swagger.entity.Pet;
import com.nf147.swagger.vo.aaa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Pet")
public class petContrller {

    @Autowired
    private PetMapper petMapper;

    @PostMapping
    @ResponseBody
    public aaa addpet(Pet pet) {
        if (petMapper.insert(pet) != 0) {
            return new aaa();
        } else {
            return new aaa(405, "error", "Invalid input");
        }
    }

    @PutMapping
    @ResponseBody
    public aaa updatePet(Pet pet) {
        if (pet.getId() == null) {
            if (petMapper.selectByPrimaryKey(pet.getId()) != null) {
                if (petMapper.updateByPrimaryKey(pet) != 0) {
                    return new aaa();
                } else {
                    return new aaa(405, "error", "Validation exception");
                }
            } else {
                return new aaa(404, "error", "Pet not found");
            }
        } else {
            return new aaa(400, "error", "Invalid ID supplied");
        }
    }

    @GetMapping
    @ResponseBody
    public aaa findByStatus(Pet pet) {
        List<Pet> list = null;
        if (pet.getStatus() == null || pet.getStatus().isEmpty()) {
            return new aaa(400, "error", "Invalid status value");
        } else {
            list = petMapper.selectAll(pet.getStatus());
            if (list == null) {
                return new aaa(200, "success", "successful operation");
            } else {
                return new aaa();
            }
        }
    }

    @GetMapping
    @ResponseBody
    public aaa findId(@PathVariable int petId) {
        if (petId == 0) {
            return new aaa(400, "error", "Invalid status value");
        } else {
            if (petMapper.selectByPrimaryKey(petId) != null) {
                return new aaa(200, "success", "successful operation");
            } else {
                return new aaa(404, "error", "Pet not found");
            }
        }
    }

    @PostMapping
    @ResponseBody
    public aaa updateId(@PathVariable int petId, Pet pet) {
        if (petId == 0) {
            return new aaa(405, "error", "Validation exception");
        } else {
            petMapper.updateByPrimaryKey(pet);
            return new aaa();
        }
    }


    @DeleteMapping
    @ResponseBody
    public aaa deleteId(@PathVariable int petId) {
        Pet pet = new Pet();
        pet.setId(petId);
        if(petMapper.selectByPrimaryKey(pet.getId()) == null){
            return new aaa(405, "error", "Validation exception");
        }else {
            if(petMapper.updateByPrimaryKey(pet) != 0){
                return new aaa(404, "error", "Pet not found");
            }
            return new aaa();
        }
    }

    @PostMapping
    @ResponseBody
    public aaa update(@PathVariable int petId,Pet pet){
        if(petMapper.updateByPrimaryKey(pet) != 0){
            return new aaa(200, "success", "successful operation");
        }
        return new aaa();
    }
}