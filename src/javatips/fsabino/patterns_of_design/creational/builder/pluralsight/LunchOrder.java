package javatips.fsabino.patterns_of_design.creational.builder.pluralsight;

public class LunchOrder {

	public static class Builder {
		
		// the variables are mutable
		private String bread;
		private String condiments;
		private String meat;
		private String dressing;
		
		public Builder setCondiments(String condiments) {
			this.condiments = condiments;
			return this;
		}
		public Builder setMeat(String meat) {
			this.meat = meat;
			return this;
		}
		public Builder setBread(String bread) {
			this.bread = bread;
			return this;
		}
		public Builder setDressing(String dressing) {
			this.dressing = dressing;
			return this;
		}
		
		public LunchOrder build() {
			return new LunchOrder(this);
		}
	}
	
	// inmutable variables
	private final String bread;
	private final String condiments;
	private final String meat;
	private final String dressing;
	
	private LunchOrder(Builder builder) {
		this.bread = builder.bread;
		this.condiments = builder.condiments;
		this.dressing = builder.dressing;
		this.meat = builder.meat;
	}
	
	// only getters because the variables are inmutable
	public String getBread() {
		return bread;
	}

	public String getCondiments() {
		return condiments;
	}

	public String getMeat() {
		return meat;
	}

	public String getDressing() {
		return dressing;
	}
}
