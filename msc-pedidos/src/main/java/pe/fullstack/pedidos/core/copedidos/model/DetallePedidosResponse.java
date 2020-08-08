package pe.fullstack.pedidos.core.copedidos.model;

public class DetallePedidosResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DetallePedidosResponse(String message) {
        super();
        this.message = message;
    }

    public DetallePedidosResponse() {
        super();
    }
}