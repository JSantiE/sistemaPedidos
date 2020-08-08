package pe.fullstack.pedidos.core.copedidos.controller;

import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;
import pe.fullstack.pedidos.core.copedidos.service.PedidosService;
import pe.fullstack.pedidos.core.copedidos.exception.ExceptionResponse;
import pe.fullstack.pedidos.core.copedidos.model.PedidosResponse;
import pe.fullstack.pedidos.core.copedidos.model.PedidosRequest;
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
@RequestMapping("v1/pedidos")
@Api(value = "PedidosController", produces = "application/json", tags = { "Controlador Pedidos" })
public class PedidosController {

    private final PedidosService pedidosService;

    @Autowired
    public PedidosController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @GetMapping
    public List<PedidosEntity> getAllPedidoss() {
        return pedidosService.findAllPedidoss();
    }

    @ApiOperation(value = "Obtiene Pedidos por ID", tags = { "Controlador Pedidos" })
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pedidos encontrada", response = PedidosEntity.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<PedidosEntity> getPedidosById(@PathVariable Long id) {
        return pedidosService.findPedidosById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Registra Pedidos", tags = { "Controlador Pedidos" })
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Pedidos registrada", response = PedidosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<PedidosResponse> createPedidos(@RequestBody @Validated PedidosRequest pedidosRequest) {
        pedidosService.savePedidos(pedidosRequest);
        return new ResponseEntity<>(new PedidosResponse(Constant.REG_INS_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualiza Pedidos", tags = { "Controlador Pedidos" })
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pedidos actualizada", response = PedidosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<PedidosResponse> updatePedidos(@PathVariable Long id, @RequestBody PedidosRequest pedidosRequest) throws Exception {
        pedidosService.updatePedidos(pedidosRequest, id);
        return new ResponseEntity<>(new PedidosResponse(Constant.REG_ACT_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Elimina Pedidos", tags = { "Controlador Pedidos" })
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pedidos eliminada", response = PedidosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<PedidosResponse> deletePedidos(@PathVariable Long id) {
        pedidosService.deletePedidosById(id);
        return new ResponseEntity<>(new PedidosResponse(Constant.REG_ELI_OK), HttpStatus.ACCEPTED);
    }
}
