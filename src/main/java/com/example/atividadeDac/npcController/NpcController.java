package com.example.atividadeDac.npcController;

import com.example.atividadeDac.NpcRepository;
import com.example.atividadeDac.model.NpcModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class NpcController {

    private NpcRepository npcRepository;
    @ResponseBody
    @PostMapping("/npc")
    public NpcModel criar(@RequestBody NpcModel npc){

        return npcRepository.save(npc);

    }


    @GetMapping("/npc")
    public List<NpcModel> findAll(){

        return npcRepository.findAll();

    }

    @GetMapping("/npc/{id}")
    public Optional<NpcModel> findById(@PathVariable Long id){

        return npcRepository.findById(id);

    }

    @DeleteMapping("/npc/{id}")
    public String deleteById(@PathVariable Long id){

        npcRepository.deleteById(id);

        return "removido";

    }

    @PutMapping("/npc/{id}")
    public Optional<NpcModel> atualizarById(@PathVariable Long id, @RequestBody NpcModel npc) {
        Optional<NpcModel> npcOptional = npcRepository.findById(id);

        if (npcOptional.isPresent()) {
            NpcModel npcExistente = npcOptional.get();
            npcExistente.setName(npc.getName());
            npcExistente.setAtk(npc.getAtk());
            npcExistente.setLife(npc.getLife());

            return Optional.of(npcRepository.save(npcExistente));
        } else {
            return Optional.empty();
        }
    }




}
