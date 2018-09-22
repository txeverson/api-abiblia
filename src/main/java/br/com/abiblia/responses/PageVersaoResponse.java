package br.com.abiblia.responses;

import java.io.Serializable;

import br.com.abiblia.util.PageDefault;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description="Paginação de livros")
public class PageVersaoResponse extends PageDefault<VersaoResponse> implements Serializable {

	private static final long serialVersionUID = -5873252259143195332L;

	public PageVersaoResponse(PageDefault<VersaoResponse> p) {
		super(p.getNumber(), p.size, p.totalPages, p.numberOfElements, p.totalElements, p.firstPage, p.hasPreviousPage, p.hasNextPage, p.hasContent,
				p.first, p.last, p.nextPage, p.previousPage, p.content);
	}

}
