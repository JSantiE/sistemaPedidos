package pe.fullstack.pedidos.core.copedidos.model;

public class EstadosResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EstadosResponse(String message) {
        super();
        this.message = message;
    }

    public EstadosResponse() {
        super();
    }
}