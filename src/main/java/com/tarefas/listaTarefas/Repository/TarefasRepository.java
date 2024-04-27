package com.tarefas.listaTarefas.Repository;

import com.tarefas.listaTarefas.Models.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<TarefasModel,Long> {
}
