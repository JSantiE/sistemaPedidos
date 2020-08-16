package pe.fullstack.pedidos.core.copedidos.model;

public class HistorialpedidosResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HistorialpedidosResponse(String message) {
        super();
        this.message = message;
    }

    public HistorialpedidosResponse() {
        super();
    }
}