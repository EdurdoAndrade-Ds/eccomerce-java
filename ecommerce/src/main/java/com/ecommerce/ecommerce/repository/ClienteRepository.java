@Repository
public interface ClienteRepository extends JpaRepository {
    List<Cliente> findByEmailContaining(String email);
}