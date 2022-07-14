package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.Pagamento;
import ao.com.ApiTecno01.repository.PagamentoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PagamentoService {

    @Autowired
    private final PagamentoRepository pagamentoRepository;

    //LISTAR
    public List<Pagamento> getAllPagamento() {
        return pagamentoRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public Pagamento getPorCodigo(long codigo) {
        return pagamentoRepository.findById(codigo);
    }

    //CRIAR
    public Pagamento createPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    //ACTUALIZAR
    public Pagamento updatePagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    //ELIMINAR
    public void deletePagamento(long codigo) {
        pagamentoRepository.deleteById(codigo);
    }
}
