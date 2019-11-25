package manager;

public class RelDef {
	
	private String nomDeRelation;
	private int nbCol;
	private String [] typeCol;
	private int fileIdx;
	private int recordSize;
	private int slotCount;
	
	public RelDef(String nomRel, int nbCol, String [] typeCol){
		this.nomDeRelation = nomRel;
		this.nbCol = nbCol;
		this.typeCol = typeCol;
	}
	
	public RelDef (String nomRel, String [] typeCol) {
		this.nomDeRelation = nomRel;
		this.typeCol = typeCol;
		this.nbCol = typeCol.length;
	}

	public RelDef(String nomDeRelation, int nbCol, String[] typeCol, int fileIdx, int recordSize, int slotCount) {
		this.nomDeRelation = nomDeRelation;
		this.nbCol = nbCol;
		this.typeCol = typeCol;
		this.fileIdx = fileIdx;
		this.recordSize = recordSize;
		this.slotCount = slotCount;
	}

	public String getNomDeRelation() {
		return nomDeRelation;
	}

	public void setNomDeRelation(String nomDeRelation) {
		this.nomDeRelation = nomDeRelation;
	}

	public int getNbCol() {
		return nbCol;
	}

	public void setNbCol(int nbCol) {
		this.nbCol = nbCol;
	}

	public String[] getTypeCol() {
		return typeCol;
	}
	
	public String getTypeCol(int numCol){
		return typeCol[numCol];
	}

	public void setTypeCol(String[] typeCol) {
		this.typeCol = typeCol;
	}

	public int getFileIdx() {
		return fileIdx;
	}

	public void setFileIdx(int fileIdx) {
		this.fileIdx = fileIdx;
	}

	public int getRecordSize() {
		return recordSize;
	}

	public void setRecordSize(int recordSize) {
		this.recordSize = recordSize;
	}

	public int getSlotCount() {
		return slotCount;
	}

	public void setSlotCount(int slotCount) {
		this.slotCount = slotCount;
	}
}