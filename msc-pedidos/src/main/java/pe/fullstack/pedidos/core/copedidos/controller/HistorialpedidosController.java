package pe.fullstack.pedidos.core.copedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.fullstack.pedidos.core.copedidos.constant.Constant;
import pe.fullstack.pedidos.core.copedidos.exception.ExceptionResponse;
import pe.fullstack.pedidos.core.copedidos.model.HistorialpedidosRequest;
import pe.fullstack.pedidos.core.copedidos.model.HistorialpedidosResponse;
import pe.fullstack.pedidos.core.copedidos.service.HistorialpedidosService;

@RestController
@RequestMapping("v1/historial-pedidos")
@Api(value = "HistorialpedidosController", produces = "application/json", tags = { "Controlador Historialpedidos" })
public class HistorialpedidosController {

    private final HistorialpedidosService historialpedidosService;

    @Autowired
    public HistorialpedidosController(HistorialpedidosService historialpedidosService) {
        this.historialpedidosService = historialpedidosService;
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


}
