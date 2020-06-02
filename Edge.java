class Edge{

	boolean Ja;	
	String Edge_Origin;
	String Edge_Destination;
	
	
	public void set_origin(String Origin){
		
		this.Edge_Origin = Origin;
		this.Edge_Origin = this.Edge_Origin.replaceAll("\\s", "");
	}
	
	public String get_origin(){
		
		return this.Edge_Origin;
	}
	
	public void set_destination(String Destination){
		
		this.Edge_Destination = Destination;
		this.Edge_Destination = this.Edge_Destination.replaceAll("\\s", "");
		
	}
	
	public String get_destination(){
		
		return this.Edge_Destination;
	}
	
	public void set_answer(boolean Ja_of_nee){
		
		this.Ja = Ja_of_nee;
	}

	public boolean get_answer(){
		
		return this.Ja;
	}



}