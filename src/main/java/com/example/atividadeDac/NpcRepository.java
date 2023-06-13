package com.example.atividadeDac;

import com.example.atividadeDac.model.NpcModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NpcRepository extends JpaRepository<NpcModel, Long> {
}
