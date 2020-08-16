package pe.fullstack.pedidos.core.copedidos.controller;

import pe.fullstack.pedidos.core.copedidos.domain.EstadosEntity;
import pe.fullstack.pedidos.core.copedidos.service.EstadosService;
import pe.fullstack.pedidos.core.copedidos.exception.ExceptionResponse;
import pe.fullstack.pedidos.core.copedidos.model.EstadosResponse;
import pe.fullstack.pedidos.core.copedidos.model.EstadosRequest;
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
@RequestMapping("v1/estados")
@Api(value = "EstadosController", produces = "application/json", tags = { "Controlador Estados" })
public class EstadosController {

    private final EstadosService estadosService;

    @Autowired
    public EstadosController(EstadosService estadosService) {
        this.estadosService = estadosService;
    }

    @GetMapping
    public List<EstadosEntity> getAllEstadoss() {
        return estadosService.findAllEstadoss();
    }

    @ApiOperation(value = "Obtiene Estados por ID", tags = { "Controlador Estados" })
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Estados encontrada", response = EstadosEntity.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<EstadosEntity> getEstadosById(@PathVariable Long id) {
        return estadosService.findEstadosById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Registra Estados", tags = { "Controlador Estados" })
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Estados registrada", response = EstadosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<EstadosResponse> createEstados(@RequestBody @Validated EstadosRequest estadosRequest) {
        estadosService.saveEstados(estadosRequest);
        return new ResponseEntity<>(new EstadosResponse(Constant.REG_INS_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualiza Estados", tags = { "Controlador Estados" })
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Estados actualizada", response = EstadosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<EstadosResponse> updateEstados(@PathVariable Long id, @RequestBody EstadosRequest estadosRequest) throws Exception {
        estadosService.updateEstados(estadosRequest, id);
        return new ResponseEntity<>(new EstadosResponse(Constant.REG_ACT_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Elimina Estados", tags = { "Controlador Estados" })
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Estados eliminada", response = EstadosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<EstadosResponse> deleteEstados(@PathVariable Long id) {
        estadosService.deleteEstadosById(id);
        return new ResponseEntity<>(new EstadosResponse(Constant.REG_ELI_OK), HttpStatus.ACCEPTED);
    }
}
