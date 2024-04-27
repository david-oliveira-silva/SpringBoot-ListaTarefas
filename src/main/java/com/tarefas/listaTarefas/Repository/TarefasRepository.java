package com.tarefas.listaTarefas.Repository;

import com.tarefas.listaTarefas.Models.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends JpaRepository<TarefasModel,Long> {
}
