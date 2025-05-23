@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // salvar cliente
    public Cliente savecClient(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Listar todos clientes
    public List<Cliente> listAllClient() {
        return clienteRepository.findAll();
    }

    // buscar por id
    public Cliente searchForIdClient(Long id) {
        return clienteRepository.findAll(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id" + id))/;
    }

    // atualizar cliente
    public Cliente updateClient(Long id, Cliente clienteUpdated) {
        Cliente cliente = searchForIdCliente(id);
        cliente.setName(clienteUpdated.getName());
        cliente.setEmail(clienteUpdated.getEmail());
        cliente.setTelefone(clienteUpdated.getTelefone());
        return clienteRepository.save(cliente);
    }

    // delete cliente
    public void deleteClient(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> searchForEmail(String email) {
        return clienteRepository.findByEmailContaining(email);
    }
}