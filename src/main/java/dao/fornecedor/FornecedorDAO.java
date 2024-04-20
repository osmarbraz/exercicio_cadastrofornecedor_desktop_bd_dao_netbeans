package dao.fornecedor;

import java.util.List;
import modelo.Fornecedor;

public interface FornecedorDAO {

    public boolean salvar(Fornecedor fornecedor);

    public Fornecedor consultarPK(String fornecedorId);

    public boolean apagarPK(int fornecedorId);

    public List consultarTudo();
}
