@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ReponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.savecClient(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> list(){
        return ResponseEntity.ok(clienteService.listAllClient());
    }

    @GetMapping("/{id}")
    public searchForIdClient(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.searchForIdClient(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return responseEntity.ok(clienteService.uptatedClient(id, cliente));
    }

    @DeleteMapping("/{id}")
    public void ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clienteService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Cliente>> searchForEmail(@RequestParam String email) {
        return ResponseEntity.ok(clienteService.searchForEmail(String email));

    }
}