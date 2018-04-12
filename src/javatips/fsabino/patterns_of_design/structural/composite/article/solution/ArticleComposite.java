package javatips.fsabino.patterns_of_design.structural.composite.article.solution;

import java.util.ArrayList;
import java.util.List;

public class ArticleComposite extends ArticleComponent {

	private List<ArticleComponent> lista;
	
	public ArticleComposite(String icon) {
		super(icon);
		lista = new ArrayList<ArticleComponent>();
	}
	
	@Override
	public boolean isComposite() {
		return true;
	}

	@Override
	public void add(ArticleComponent articleComponent) {
		assert lista!= null;
		this.lista.add(articleComponent);
	}

	@Override
	public void remove(ArticleComponent articleComponent) {
		assert lista!= null; 
		this.lista.remove(articleComponent);
	}

}
