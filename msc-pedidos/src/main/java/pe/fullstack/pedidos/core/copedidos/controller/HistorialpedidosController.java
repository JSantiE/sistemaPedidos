package pe.fullstack.pedidos.core.copedidos.controller;

import pe.fullstack.pedidos.core.copedidos.domain.HistorialpedidosEntity;
import pe.fullstack.pedidos.core.copedidos.service.HistorialpedidosService;
import pe.fullstack.pedidos.core.copedidos.exception.ExceptionResponse;
import pe.fullstack.pedidos.core.copedidos.model.HistorialpedidosResponse;
import pe.fullstack.pedidos.core.copedidos.model.HistorialpedidosRequest;
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
@RequestMapping("v1/historial-pedidos")
@Api(value = "HistorialpedidosController", produces = "application/json", tags = { "Controlador Historialpedidos" })
public class HistorialpedidosController {

    private final HistorialpedidosService historialpedidosService;

    @Autowired
    public HistorialpedidosController(HistorialpedidosService historialpedidosService) {
        this.historialpedidosService = historialpedidosService;
    }

    @GetMapping
    public List<HistorialpedidosEntity> getAllHistorialpedidoss() {
        return historialpedidosService.findAllHistorialpedidoss();
    }

    @ApiOperation(value = "Obtiene Historialpedidos por ID", tags = { "Controlador Historialpedidos" })
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Historialpedidos encontrada", response = HistorialpedidosEntity.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<HistorialpedidosEntity> getHistorialpedidosById(@PathVariable Long id) {
        return historialpedidosService.findHistorialpedidosById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Registra Historialpedidos", tags = { "Controlador Historialpedidos" })
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Historialpedidos registrada", response = HistorialpedidosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<HistorialpedidosResponse> createHistorialpedidos(@RequestBody @Validated HistorialpedidosRequest historialpedidosRequest) {
        historialpedidosService.saveHistorialpedidos(historialpedidosRequest);
        return new ResponseEntity<>(new HistorialpedidosResponse(Constant.REG_INS_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualiza Historialpedidos", tags = { "Controlador Historialpedidos" })
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Historialpedidos actualizada", response = HistorialpedidosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<HistorialpedidosResponse> updateHistorialpedidos(@PathVariable Long id, @RequestBody HistorialpedidosRequest historialpedidosRequest) throws Exception {
        historialpedidosService.updateHistorialpedidos(historialpedidosRequest, id);
        return new ResponseEntity<>(new HistorialpedidosResponse(Constant.REG_ACT_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Elimina Historialpedidos", tags = { "Controlador Historialpedidos" })
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Historialpedidos eliminada", response = HistorialpedidosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<HistorialpedidosResponse> deleteHistorialpedidos(@PathVariable Long id) {
        historialpedidosService.deleteHistorialpedidosById(id);
        return new ResponseEntity<>(new HistorialpedidosResponse(Constant.REG_ELI_OK), HttpStatus.ACCEPTED);
    }
}
