package pe.fullstack.pedidos.core.copedidos.model;

public class ClientesResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ClientesResponse(String message) {
        super();
        this.message = message;
    }

    public ClientesResponse() {
        super();
    }
}