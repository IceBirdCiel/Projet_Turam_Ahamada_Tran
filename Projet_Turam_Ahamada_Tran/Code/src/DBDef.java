public class DBDef {
	// ajouter un cstr si beesoin

	private DBDef() {
	}
	private static DBDef INSTANCE = new DBDef();

	public static DBDef getInstance() {   return INSTANCE;
	}
	
	private RelDef [] dbDef;
	private int cptRelEntier=0;
	/*private final instance = new DBDef();
	
	private DBDef(RelDef [] dbDef,int cptRelEntier) {
		this.dbDef = dbDef;
		this.cptRelEntier = cptRelEntier;
	}
	private DBDef() {
		this.dbDef = new RelDef[100];
		this.cptRelEntier = 0;
	}
	
	*/
	
	
	public void init(){
		
	}
	
	public void finish() {
		
	}
	
	public void addRel (RelDef relation) {
		dbDef[cptRelEntier++] = relation ;
		
	}
}