package br.com.abiblia.responses;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Classe que representa o response de versículos")
public class VersiculoResponse implements Serializable {

	private static final long serialVersionUID = -8053042720343828502L;

	@ApiModelProperty(value="ID de identificação do versículo", name="id", position = 1)
	public Integer id;

	@ApiModelProperty(value="ID de identificação da versão", name="idVersao", position = 2)
	public Integer idVersao;
	
	@ApiModelProperty(value="ID de identificação do testamento", name="idTestamento", position = 3)
	public Integer idTestamento;

	@ApiModelProperty(value="ID de identificação do livro", name="idLivro", position = 4)
	public Integer idLivro;
	
	@ApiModelProperty(value="Número do capítulo", name="capitulo", position = 5)
	public Integer capitulo;
	
	@ApiModelProperty(value="Número do versículo", name="versiculoNumero", position = 6)
	public Integer versiculoNumero;
	
	@ApiModelProperty(value="Texto do versículo", name="versiculoTexto", position = 7)
	public String versiculoTexto;

}
