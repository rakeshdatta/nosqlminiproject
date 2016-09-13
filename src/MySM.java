/********************************************************
 * AUTHOR      : Rakesh Datta                           *
 * COURSE      : CMPE 281 Mini Project                  *
 * DATE        : April 2016                             *
 * DESCRIPTION : This Class Implements the interface SM.*
 *               SM Interface contains methods for the  *
 *               Database.                              *
 * *****************************************************/
 
import java.util.*;
import java.io.*;

public class MySM implements SM {

	private SM sm;


	public MySM() {
		this.sm = SMFactory.getInstance();
	}


	public SM.OID store(Record rec) throws IOException {
		return sm.store(rec);
	}


	public Record fetch(SM.OID oid) throws NotFoundException, IOException {
		return sm.fetch(oid);
	}


	public void close() throws SM.IOException {
		sm.close();
	}


	public void flush()  {
		try { sm.flush(); } catch (Exception e) {}
	}



	public SM.OID update(SM.OID oid, Record rec) throws NotFoundException, IOException {
		return sm.update(oid, rec);
	}


	public void delete(SM.OID oid) throws NotFoundException, CannotDeleteException {
		sm.delete(oid);
	}

        public SM.OID getOID( byte[] oidbytes ) {
        	return sm.getOID( oidbytes ) ;	  
        } 

        /*
         * This an inner class used to create a Hashmap. This hashmap
         * is used for (oid, primary key) mapping. 
         * Given the primary key this Map gives oid. The oid is then used
         * to fetch the entire record from SM.
         *

	public class MyHashMap {
    		private Map<String, String> map  = new HashMap<String, String>();
    		private Map<String, String> map1 = new HashMap<String, String>();

    		MyHashMap(){
                   System.out.println("Hashmap Created");
    		};

    		public void create(SM.OID oid, String key){
        	   String guid = new String (oid.toBytes());
        	   System.out.println("[INFO]: map_create:key/guid  = "+guid);
        	   System.out.println("[INFO]: map_create:value     = "+key);

        	   map.put(guid, key);

        	   map1.put(guid, "1");
    		};

    		public SM.OID read(String value){
        	   //System.out.println("[INFO]: map_read:value  = "+value);
        	   String guid = null;
        
        	   for (Object o : map.keySet()) {
            	      if (map.get(o).equals(value)) {
                          //System.out.println(o);
                          guid = o.toString();
                      }
        	   }

        	   System.out.println("[INFO]: map_read:guid   = "+guid);
                   return getOID(guid.getBytes());
                };

                public void delete(String value){
                   System.out.println("[INFO]: map_delete:value  = "+value);
                   String guid = null;

                   for (Object o : map.keySet()) {
                      if (map.get(o).equals(value)) {
                          //System.out.println(o);
                          guid = o.toString();
                      }
                   }

                   System.out.println("[INFO]: map_delete:guid   = "+guid);
	           map.remove(guid);		
                };

    		public void increaseVer(String value){
		   String guid = null;

                   for (Object o : map.keySet()) {
                      if (map.get(o).equals(value)) {
                          guid = o.toString();
           
 			  String version = map1.get(guid);
                          int ver = Integer.parseInt(version);
                          ver++;
        	          map1.put(guid, String.valueOf(ver));
			  
                      }

                 
                   }
                };

		public String readVer(String value){
                   String guid = null;
                  
                   for (Object o : map.keySet()) {
                        if (map.get(o).equals(value)) {
                            guid = o.toString();
                            return map1.get(guid);
                        }
	           }
                   return "0";
                };
        }


}

