import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // salvar cliente
    public Cliente saveClient(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Listar todos clientes
    public List<Cliente> listAllClient() {
        return clienteRepository.findAll();
    }

    // buscar por id
    public Cliente searchForIdClient(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id " + id));
    }

    // atualizar cliente
    public Cliente updateClient(Long id, Cliente clienteUpdated) {
        Cliente cliente = searchForIdClient(id);
        cliente.setName(clienteUpdated.getName());
        cliente.setEmail(clienteUpdated.getEmail());
        cliente.setTelefone(clienteUpdated.getTelefone());
        return clienteRepository.save(cliente);
    }

    // deletar cliente
    public void deleteClient(Long id) {
        clienteRepository.deleteById(id);
    }

    // buscar clientes por email
    public List<Cliente> searchForEmail(String email) {
        return clienteRepository.findByEmailContaining(email);
    }
}