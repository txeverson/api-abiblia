package br.com.abiblia.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.abiblia.entidades.Versiculo;
import br.com.abiblia.requests.VersiculoRequest;
import br.com.abiblia.servicos.VersiculoServico;
import br.com.abiblia.util.ConstantesRest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = ConstantesRest.PATH_VERSICULO, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = ConstantesRest.PATH_VERSICULO, produces = MediaType.APPLICATION_JSON_VALUE, description="Versiculos de todos os livros da bíblia", tags = {"VERSICULO"})
public class VersiculoResource {

     @Autowired
     private VersiculoServico versiculoServico; 

     
     @ResponseBody
     @RequestMapping(method = RequestMethod.GET)
     @ApiOperation(value="Lista os versiculos da bíblia", notes="Recurso para listagem de todos os versiculos da bíblia", response = Page.class)
     @ApiResponses({
          @ApiResponse(code=200, message="Requisição efetuada com sucesso!."),
          @ApiResponse(code=400, message="Requisição inválida."),
          @ApiResponse(code=404, message="Recurso não encontrado."),
          @ApiResponse(code=500, message="Erro interno do sistema.")
     })
     public ResponseEntity<?> versoes( @ModelAttribute(value="GenericRequest") VersiculoRequest request ){
          
          PageRequest pageRequest = request.pageRequest();
          
          Page<Versiculo> page = versiculoServico.versiculos(pageRequest);
          
          return ResponseEntity.ok(page);

     }

     @ResponseBody
     @RequestMapping(value = "{id}", method = RequestMethod.GET)
     @ApiOperation(value="Consulta um versiculo da bíblia", notes="Recurso para consultar versiculos da bíblia", response = Versiculo.class)
     @ApiResponses({
          @ApiResponse(code=200, message="Requisição efetuada com sucesso!."),
          @ApiResponse(code=400, message="Requisição inválida."),
          @ApiResponse(code=404, message="Recurso não encontrado."),
          @ApiResponse(code=500, message="Erro interno do sistema.")
     })
     public ResponseEntity<?> varsao(@PathVariable("id") Long id){
          
          Optional<Versiculo> versiculo = versiculoServico.versiculo(id);
          
          return ResponseEntity.ok(versiculo);
          
     }
     
}