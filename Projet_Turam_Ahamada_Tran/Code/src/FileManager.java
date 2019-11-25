package manager;

import java.util.ArrayList;

public class FileManager {
    HeapFile[] heapFiles;
	private static FileManager INSTANCE = new FileManager();
    
    private FileManager() {
    }
    
    public static FileManager getInstance(){
        return INSTANCE;
    }
    
    public void init() {
        RelDef[] relDef = DBDef.getInstance().getReldef();
        //heapFiles = new HeapFile[relDef.length];
        int caseActual=0;
        for(int i=0;i<relDef.length;i++){
            while(heapFiles[caseActual]!=null){
                caseActual++;
            }
            heapFiles[caseActual] = new HeapFile(relDef[i]);
        }
    }
    
    public void createRelationFile (RelDef relDef){
        int caseActual=0;
        while(heapFiles[caseActual]!=null){
            caseActual++;
        }
        heapFiles[caseActual] = new HeapFile(relDef);
        heapFiles[caseActual].createNewOnDisk();
    }
    
    public Rid insertRecordInRelation (Record record,String relName){
    	// TODO
	}

	
	
	/**
 	*
 	* @param relName
	* @param idxCol
 	* @param valeur
	* @return liste de records
 	*/
	/*signature fonction*/ selectFromRelation(String relName, int idxCol, String valeur){
		Record[] allRecords = new Record[selectAllFromRelation(relName).length];
		allRecords = selectAllFromRelation(relName);
		ArrayList <String> records = new ArrayList <String>();
		for (Record r : allRecords){
			if r.getReldef().getTypeCol(idxCol).equals(valeur){
				records.add(r);
			}
		}
		Record [] tabRecord = records.toArray();
		return tabRecord;
	}
}