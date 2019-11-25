package manager;

import java.nio.Buffer;

public class HeapFile {
    RelDef relDef;

    public HeapFile(RelDef relDef) {
        this.relDef = relDef;
    }

    public void createNewOnDisk(){
        DiskManager.getInstance().CreateFile(relDef.getFileIdx());
        PageId pageid = DiskManager.getInstance().AddPage(relDef.getFileIdx());
        byte[] buff = BufferManager.getInstance().GetPage(pageid);
        for(int i =0;i<Constants.pageSize;i++){
            buff[i]=0;
        }
        BufferManager.getInstance().FreePage(pageid,false);
    }

    // pageId addDataPage()

    public PageId getFreeData(){
        PageId pageid = DiskManager.getInstance().addPage(relDef.getFileIdx());
        byte[] buff = BufferManager.getInstance().getPage(pageid);
        boolean freedata = false;
        for(int i=0;i<Constants.pageSize;i++){
            int nb = 0;
            if(buff[i]==0)nb++;
            if(nb==Constants.pageSize)freedata=true;
        }
        BufferManager.getInstance().freePage(pageid,false);
        if(freedata) return pageid;
        else return null;
    }
    
    public Rid writeRecordToDataPage(Record record,PageId pageid){
        byte[] buff = BufferManager.getInstance().getPage(pageid);
        int pos=0;
        for(int i=0;i<Constants.pageSize;i++){
            if(buff[i]==0){
                pos=i;
                i=Constants.pageSize;
            }
        }
        record.writeToBuffer(buff,pos);
        BufferManager.getInstance().freePage(pageid,true);
        // acutaliser headerpage car nb de page dispo a changé
        // c'est a dire dans le fichier de la pageid faire -- au deuxième N
        Rid rid = new Rid(pageid,pos);
        return rid;
    }
    
    public Record[] getRecordsInDataPage (PageId pageid){
        byte[] buff = BufferManager.getInstance().getPage(pageid);
        int count = 0;
        Record[] record = new Record[Constants.pageSize];
        for(int i=0;i<Constants.pageSize;i++){
            if(buff[i]!=0){
                record[count].readFromBuffer(buff,i);
                // i peut etre different car pos != case du tableau
            }
        }

        BufferManager.getInstance().freePage(pageid,false);
        return record;
    }

    public Rid insertRecord (Record record){
        PageId pageid = ;
        // page libre
        Rid rid = writeRecordToDataPage(record,pageid);
        return rid;
    }
    
    public Record[] getAllRecords (){
        // recuperer les infos de la headerpage
        int headerpagesize;
        int headerpagefreesize;
        Record[] recordtab = new Record[relDef.getSlotCount()];
        Record record = new Record();
        int pos = 0;
        // creer un record
        for (int i = 1; i < headerpagesize; i++) {
			if (headerpagefreesize < relDef.getSlotCount()) {
				PageId pi = ;
				//recuperer la pi du headerpage
				byte[] buffer = BufferManager.getInstance().getPage(pi);
				for (int j = 0; j < relDef.getSlotCount(); j++)
					// record.readFromBuffer(buffer,j); et mettre dans le tab
					BufferManager.getInstance().freePage(pi, false);
			}
		}
    }
}
