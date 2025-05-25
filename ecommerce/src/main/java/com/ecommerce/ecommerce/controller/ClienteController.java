import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveClient(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.ok(clienteService.listAllClient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> searchForIdClient(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.searchForIdClient(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.updateClient(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clienteService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Cliente>> searchForEmail(@RequestParam String email) {
        return ResponseEntity.ok(clienteService.searchForEmail(email));
    }
}