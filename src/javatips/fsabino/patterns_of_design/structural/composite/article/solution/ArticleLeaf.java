package javatips.fsabino.patterns_of_design.structural.composite.article.solution;

public class ArticleLeaf extends ArticleComponent {

	private Article article;
		
	public ArticleLeaf(String icon, Article a) {
		super(icon);
		this.article = a;
	}
	
	@Override
	public boolean isComposite() {
		return false;
	}

	@Override
	public void add(ArticleComponent articleComponent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(ArticleComponent articleComponent) {
		// TODO Auto-generated method stub
		
	}
	
	public Article getArticle() {
        return article;
    }
}
