package pe.fullstack.pedidos.core.copedidos.controller;

import pe.fullstack.pedidos.core.copedidos.domain.ClientesEntity;
import pe.fullstack.pedidos.core.copedidos.service.ClientesService;
import pe.fullstack.pedidos.core.copedidos.exception.ExceptionResponse;
import pe.fullstack.pedidos.core.copedidos.model.ClientesResponse;
import pe.fullstack.pedidos.core.copedidos.model.ClientesRequest;
import pe.fullstack.pedidos.core.copedidos.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("v1/clientes")
@Api(value = "ClientesController", produces = "application/json", tags = { "Controlador Clientes" })
public class ClientesController {

    private final ClientesService clientesService;

    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping
    public List<ClientesEntity> getAllClientess() {
        return clientesService.findAllClientess();
    }

    @ApiOperation(value = "Obtiene Clientes por ID", tags = { "Controlador Clientes" })
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Clientes encontrada", response = ClientesEntity.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<ClientesEntity> getClientesById(@PathVariable Long id) {
        return clientesService.findClientesById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Registra Clientes", tags = { "Controlador Clientes" })
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Clientes registrada", response = ClientesRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<ClientesResponse> createClientes(@RequestBody @Validated ClientesRequest clientesRequest) {
        clientesService.saveClientes(clientesRequest);
        return new ResponseEntity<>(new ClientesResponse(Constant.REG_INS_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualiza Clientes", tags = { "Controlador Clientes" })
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Clientes actualizada", response = ClientesRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<ClientesResponse> updateClientes(@PathVariable Long id, @RequestBody ClientesRequest clientesRequest) throws Exception {
        clientesService.updateClientes(clientesRequest, id);
        return new ResponseEntity<>(new ClientesResponse(Constant.REG_ACT_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Elimina Clientes", tags = { "Controlador Clientes" })
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Clientes eliminada", response = ClientesRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<ClientesResponse> deleteClientes(@PathVariable Long id) {
        clientesService.deleteClientesById(id);
        return new ResponseEntity<>(new ClientesResponse(Constant.REG_ELI_OK), HttpStatus.ACCEPTED);
    }
}
