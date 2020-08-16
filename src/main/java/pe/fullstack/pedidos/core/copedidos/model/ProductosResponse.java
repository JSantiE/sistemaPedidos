package pe.fullstack.pedidos.core.copedidos.model;

public class ProductosResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProductosResponse(String message) {
        super();
        this.message = message;
    }

    public ProductosResponse() {
        super();
    }
}