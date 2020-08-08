package pe.fullstack.pedidos.core.copedidos.model;

public class PedidosResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PedidosResponse(String message) {
        super();
        this.message = message;
    }

    public PedidosResponse() {
        super();
    }
}