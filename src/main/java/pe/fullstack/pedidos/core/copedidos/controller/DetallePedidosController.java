package pe.fullstack.pedidos.core.copedidos.controller;

import pe.fullstack.pedidos.core.copedidos.domain.DetallePedidosEntity;
import pe.fullstack.pedidos.core.copedidos.service.DetallePedidosService;
import pe.fullstack.pedidos.core.copedidos.exception.ExceptionResponse;
import pe.fullstack.pedidos.core.copedidos.model.DetallePedidosResponse;
import pe.fullstack.pedidos.core.copedidos.model.DetallePedidosRequest;
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
@RequestMapping("v1/detalle-pedidos")
@Api(value = "DetallePedidosController", produces = "application/json", tags = { "Controlador DetallePedidos" })
public class DetallePedidosController {

    private final DetallePedidosService detallePedidosService;

    @Autowired
    public DetallePedidosController(DetallePedidosService detallePedidosService) {
        this.detallePedidosService = detallePedidosService;
    }

    @GetMapping
    public List<DetallePedidosEntity> getAllDetallePedidoss() {
        return detallePedidosService.findAllDetallePedidoss();
    }

    @ApiOperation(value = "Obtiene DetallePedidos por ID", tags = { "Controlador DetallePedidos" })
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "DetallePedidos encontrada", response = DetallePedidosEntity.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<DetallePedidosEntity> getDetallePedidosById(@PathVariable Long id) {
        return detallePedidosService.findDetallePedidosById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Registra DetallePedidos", tags = { "Controlador DetallePedidos" })
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "DetallePedidos registrada", response = DetallePedidosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<DetallePedidosResponse> createDetallePedidos(@RequestBody @Validated DetallePedidosRequest detallePedidosRequest) {
        detallePedidosService.saveDetallePedidos(detallePedidosRequest);
        return new ResponseEntity<>(new DetallePedidosResponse(Constant.REG_INS_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualiza DetallePedidos", tags = { "Controlador DetallePedidos" })
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "DetallePedidos actualizada", response = DetallePedidosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<DetallePedidosResponse> updateDetallePedidos(@PathVariable Long id, @RequestBody DetallePedidosRequest detallePedidosRequest) throws Exception {
        detallePedidosService.updateDetallePedidos(detallePedidosRequest, id);
        return new ResponseEntity<>(new DetallePedidosResponse(Constant.REG_ACT_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Elimina DetallePedidos", tags = { "Controlador DetallePedidos" })
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "DetallePedidos eliminada", response = DetallePedidosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<DetallePedidosResponse> deleteDetallePedidos(@PathVariable Long id) {
        detallePedidosService.deleteDetallePedidosById(id);
        return new ResponseEntity<>(new DetallePedidosResponse(Constant.REG_ELI_OK), HttpStatus.ACCEPTED);
    }
}
