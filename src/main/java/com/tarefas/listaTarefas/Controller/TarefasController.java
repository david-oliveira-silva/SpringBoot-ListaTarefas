package com.tarefas.listaTarefas.Controller;

import com.tarefas.listaTarefas.DTO.TarefasDTO;
import com.tarefas.listaTarefas.Models.TarefasModel;
import com.tarefas.listaTarefas.Repository.TarefasRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarefasController {

    @Autowired
    TarefasRepository tarefasRepository;

    @PostMapping("/tarefas")
    public ResponseEntity<TarefasModel> cadastrarTarefas(@RequestBody @Valid TarefasDTO tarefasDTO){
        var TarefasModel = new TarefasModel();
        BeanUtils.copyProperties(tarefasDTO,TarefasModel);
        return ResponseEntity.status(HttpStatus.OK).body(tarefasRepository.save(TarefasModel));

    }
}