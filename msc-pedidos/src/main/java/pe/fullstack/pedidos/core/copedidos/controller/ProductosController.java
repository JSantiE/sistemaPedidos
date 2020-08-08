package pe.fullstack.pedidos.core.copedidos.controller;

import pe.fullstack.pedidos.core.copedidos.domain.ProductosEntity;
import pe.fullstack.pedidos.core.copedidos.service.ProductosService;
import pe.fullstack.pedidos.core.copedidos.exception.ExceptionResponse;
import pe.fullstack.pedidos.core.copedidos.model.ProductosResponse;
import pe.fullstack.pedidos.core.copedidos.model.ProductosRequest;
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
@RequestMapping("v1/productos")
@Api(value = "ProductosController", produces = "application/json", tags = { "Controlador Productos" })
public class ProductosController {

    private final ProductosService productosService;

    @Autowired
    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public List<ProductosEntity> getAllProductoss() {
        return productosService.findAllProductoss();
    }

    @ApiOperation(value = "Obtiene Productos por ID", tags = { "Controlador Productos" })
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Productos encontrada", response = ProductosEntity.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<ProductosEntity> getProductosById(@PathVariable Long id) {
        return productosService.findProductosById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Registra Productos", tags = { "Controlador Productos" })
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Productos registrada", response = ProductosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<ProductosResponse> createProductos(@RequestBody @Validated ProductosRequest productosRequest) {
        productosService.saveProductos(productosRequest);
        return new ResponseEntity<>(new ProductosResponse(Constant.REG_INS_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualiza Productos", tags = { "Controlador Productos" })
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Productos actualizada", response = ProductosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<ProductosResponse> updateProductos(@PathVariable Long id, @RequestBody ProductosRequest productosRequest) throws Exception {
        productosService.updateProductos(productosRequest, id);
        return new ResponseEntity<>(new ProductosResponse(Constant.REG_ACT_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Elimina Productos", tags = { "Controlador Productos" })
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Productos eliminada", response = ProductosRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<ProductosResponse> deleteProductos(@PathVariable Long id) {
        productosService.deleteProductosById(id);
        return new ResponseEntity<>(new ProductosResponse(Constant.REG_ELI_OK), HttpStatus.ACCEPTED);
    }
}
