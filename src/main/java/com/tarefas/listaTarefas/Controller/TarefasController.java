package com.tarefas.listaTarefas.Controller;

import com.tarefas.listaTarefas.DTO.TarefasDTO;
import com.tarefas.listaTarefas.Models.TarefasModel;
import com.tarefas.listaTarefas.Repository.TarefasRepository;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/tarefas")
    public ResponseEntity<List<TarefasModel>> getTarefas(){
        return ResponseEntity.status(HttpStatus.OK).body(tarefasRepository.findAll());
    }
    @GetMapping("/tarefas/{id}")
    public ResponseEntity<Object> getByIdTarefas(@PathVariable(name = "id")Long id){
        Optional<TarefasModel> tarefa0 = tarefasRepository.findById(id) ;
        if (tarefa0.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tarefasRepository.findById(id));
    }
    @PutMapping("/tarefas/{id}")
    public  ResponseEntity<Object> updateTarefas(@PathVariable(name = "id")Long id,@RequestBody @Valid TarefasDTO tarefasDTO){
        Optional<TarefasModel> tarefas0 = tarefasRepository.findById(id);
        if (tarefas0.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("tarefa não encotrada");
        }
        var TarefasModel = tarefas0.get();
        BeanUtils.copyProperties(tarefasDTO,TarefasModel);
        return  ResponseEntity.status(HttpStatus.OK).body(tarefasRepository.save(TarefasModel));
    }
    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<Object> deleteTarefas(@PathVariable(name = "id")Long id){
        Optional<TarefasModel>tarefa0 = tarefasRepository.findById(id);
        if (tarefa0.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
        var tarefasModels = tarefa0.get();
        tarefasRepository.delete(tarefasModels);

        return ResponseEntity.status(HttpStatus.OK).body("Tarefa deletada");
    }
}
