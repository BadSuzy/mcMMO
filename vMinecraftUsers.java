import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class vMinecraftUsers {
    private static volatile vMinecraftUsers instance;
    protected static final Logger log = Logger.getLogger("Minecraft");
    String file = "vminecraftusers.txt";
    private PropertiesFile properties;
    String location = "vminecraftusers.txt";
    public void loadUsers(){
        File theDir = new File("vminecraftusers.txt");
		if(!theDir.exists()){
			properties = new PropertiesFile("vminecraftusers.txt");
			FileWriter writer = null;
			try {
				writer = new FileWriter(location);
				writer.write("#Storage place for user information\r\n");
                                writer.write("#username:nickname:suffix:ignore,list,names:alias,commands,here\r\n");
			} catch (Exception e) {
				log.log(Level.SEVERE, "Exception while creating " + location, e);
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch (IOException e) {
					log.log(Level.SEVERE, "Exception while closing writer for " + location, e);
				}
			}

		} else {
			properties = new PropertiesFile("vminecraftusers.txt");
			try {
				properties.load();
			} catch (IOException e) {
				log.log(Level.SEVERE, "Exception while loading vminecraftusers.txt", e);
			}
		}
    }
    public static void addUser(Player player){
        FileWriter writer = null;
        String location = "vminecraftusers.txt";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(location, true));
            bw.append(player.getName()+"::::\r\n");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception while trying to add user with BufferedWriter to " + location, e);
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				log.log(Level.SEVERE, "Exception while closing writer for " + location, e);
			}
		}

    }
    public static vMinecraftUsers getInstance() {
		if (instance == null) {
			instance = new vMinecraftUsers();
		}
		return instance;
	}
    public static void getRow(){

    }
}
