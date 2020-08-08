package pe.fullstack.pedidos.core.copedidos.model;

public class CategoriasResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CategoriasResponse(String message) {
        super();
        this.message = message;
    }

    public CategoriasResponse() {
        super();
    }
}