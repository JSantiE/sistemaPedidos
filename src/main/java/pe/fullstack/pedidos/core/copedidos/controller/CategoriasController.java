package pe.fullstack.pedidos.core.copedidos.controller;

import pe.fullstack.pedidos.core.copedidos.domain.CategoriasEntity;
import pe.fullstack.pedidos.core.copedidos.service.CategoriasService;
import pe.fullstack.pedidos.core.copedidos.exception.ExceptionResponse;
import pe.fullstack.pedidos.core.copedidos.model.CategoriasResponse;
import pe.fullstack.pedidos.core.copedidos.model.CategoriasRequest;
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
@RequestMapping("v1/categorias")
@Api(value = "CategoriasController", produces = "application/json", tags = { "Controlador Categorias" })
public class CategoriasController {

    private final CategoriasService categoriasService;

    @Autowired
    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping
    public List<CategoriasEntity> getAllCategoriass() {
        return categoriasService.findAllCategoriass();
    }

    @ApiOperation(value = "Obtiene Categorias por ID", tags = { "Controlador Categorias" })
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categorias encontrada", response = CategoriasEntity.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<CategoriasEntity> getCategoriasById(@PathVariable Long id) {
        return categoriasService.findCategoriasById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Registra Categorias", tags = { "Controlador Categorias" })
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Categorias registrada", response = CategoriasRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<CategoriasResponse> createCategorias(@RequestBody @Validated CategoriasRequest categoriasRequest) {
        categoriasService.saveCategorias(categoriasRequest);
        return new ResponseEntity<>(new CategoriasResponse(Constant.REG_INS_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualiza Categorias", tags = { "Controlador Categorias" })
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categorias actualizada", response = CategoriasRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<CategoriasResponse> updateCategorias(@PathVariable Long id, @RequestBody CategoriasRequest categoriasRequest) throws Exception {
        categoriasService.updateCategorias(categoriasRequest, id);
        return new ResponseEntity<>(new CategoriasResponse(Constant.REG_ACT_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Elimina Categorias", tags = { "Controlador Categorias" })
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categorias eliminada", response = CategoriasRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<CategoriasResponse> deleteCategorias(@PathVariable Long id) {
        categoriasService.deleteCategoriasById(id);
        return new ResponseEntity<>(new CategoriasResponse(Constant.REG_ELI_OK), HttpStatus.ACCEPTED);
    }
}
