package org.bedu.java.backend.postwork.fase4.controllers;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.postwork.fase4.model.Producto;
import org.bedu.java.backend.postwork.fase4.model.Venta;
import org.bedu.java.backend.postwork.fase4.model.Visita;
import org.bedu.java.backend.postwork.fase4.services.VisitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visita")
@RequiredArgsConstructor
public class VisitaController {
    private final VisitaService visitaService;
    @GetMapping("/{visitaId}")
    public ResponseEntity<Visita> getVisita(@PathVariable Long visitaId){
        Optional<Visita> visitaDb = visitaService.obtenVisita(visitaId);

        if (visitaDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La visita especificada no existe.");
        }

        return ResponseEntity.ok(visitaDb.get());
    }

    @GetMapping
    public ResponseEntity <List<Visita>> getVisitas(){
        return ResponseEntity.ok(visitaService.obtenVisitas());
    }

    @PostMapping
    public ResponseEntity<Void> creaVisita(@RequestBody Visita visita, @RequestParam Long clienteId){
        Visita visitaNueva = visitaService.guardaVisita(visita);

        return ResponseEntity.created(URI.create(String.valueOf(visitaNueva.getId()))).build();
    }

    @PutMapping("/{visitaId}")
    public ResponseEntity<Void> actualizaVisita(@PathVariable Long visitaId, @RequestBody Visita visita){
        visitaService.actualizaVisita(visita);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{visitaId}")
    public ResponseEntity<Void> eliminaVisita(@PathVariable Long visitaId){
        visitaService.eliminaVisita(visitaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
