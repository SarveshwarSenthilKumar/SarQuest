package SarQuest.src.main;

import java.rmi.server.ObjID;

import SarQuest.src.main.GamePanel;
import SarQuest.src.object.OBJ_Bee;
import SarQuest.src.object.OBJ_BrokenGlass;
import SarQuest.src.object.OBJ_Door;
import SarQuest.src.object.OBJ_ForbiddenBeans;
import SarQuest.src.object.OBJ_ITS;
import SarQuest.src.object.OBJ_Key;
import SarQuest.src.object.OBJ_LettuceLemonade;
import SarQuest.src.object.OBJ_Vault;
import SarQuest.src.object.OBJ_Wingams;

public class AssetSetter {
    
    GamePanel gp;

    public AssetSetter (GamePanel gp){
        this.gp = gp;
        setObject();
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 17 * gp.tileSize;
        gp.obj[0].worldY = 10 * gp.tileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 43 * gp.tileSize;
        gp.obj[1].worldY = 7 * gp.tileSize;

        gp.obj[2] = new OBJ_Key();
        gp.obj[2].worldX = 8 * gp.tileSize;
        gp.obj[2].worldY = 35 * gp.tileSize;

        gp.obj[3] = new OBJ_Key();
        gp.obj[3].worldX = 13 * gp.tileSize;
        gp.obj[3].worldY = 27 * gp.tileSize;

        gp.obj[4] = new OBJ_Key();
        gp.obj[4].worldX = 39 * gp.tileSize;
        gp.obj[4].worldY = 22 * gp.tileSize;
        
        gp.obj[5] = new OBJ_Door();
        gp.obj[5].worldX = 29 * gp.tileSize;
        gp.obj[5].worldY = 32 * gp.tileSize;

        gp.obj[6] = new OBJ_Door();
        gp.obj[6].worldX = 30 * gp.tileSize;
        gp.obj[6].worldY = 24 * gp.tileSize;

        gp.obj[7] = new OBJ_Door();
        gp.obj[7].worldX = 29 * gp.tileSize;
        gp.obj[7].worldY = 27 * gp.tileSize;

        gp.obj[8] = new OBJ_Door();
        gp.obj[8].worldX = 29 * gp.tileSize;
        gp.obj[8].worldY = 34 * gp.tileSize;

        gp.obj[9] = new OBJ_Door();
        gp.obj[9].worldX = 29 * gp.tileSize;
        gp.obj[9].worldY = 38 * gp.tileSize;

        gp.obj[10] = new OBJ_Vault();
        gp.obj[10].worldX = 26 * gp.tileSize;
        gp.obj[10].worldY = 40 * gp.tileSize;

        gp.obj[11] = new OBJ_LettuceLemonade();
        gp.obj[11].worldX = 39 * gp.tileSize;
        gp.obj[11].worldY = 8 * gp.tileSize;

        gp.obj[12] = new OBJ_Bee();
        gp.obj[12].worldX = 40 * gp.tileSize;
        gp.obj[12].worldY = 23 * gp.tileSize;

        gp.obj[13] = new OBJ_Bee();
        gp.obj[13].worldX = 16 * gp.tileSize;
        gp.obj[13].worldY = 26 * gp.tileSize;

        gp.obj[14] = new OBJ_Key();
        gp.obj[14].worldX = 20 * gp.tileSize;
        gp.obj[14].worldY = 9 * gp.tileSize;

        gp.obj[15] = new OBJ_BrokenGlass();
        gp.obj[15].worldX = 25 * gp.tileSize;
        gp.obj[15].worldY = 9 * gp.tileSize;

        gp.obj[16] = new OBJ_BrokenGlass();
        gp.obj[16].worldX = 32 * gp.tileSize;
        gp.obj[16].worldY = 10 * gp.tileSize;

        gp.obj[17] = new OBJ_BrokenGlass();
        gp.obj[17].worldX = 4 * gp.tileSize;
        gp.obj[17].worldY = 20 * gp.tileSize;

        gp.obj[18] = new OBJ_BrokenGlass();
        gp.obj[18].worldX = 4 * gp.tileSize;
        gp.obj[18].worldY = 21 * gp.tileSize;

        gp.obj[19] = new OBJ_BrokenGlass();
        gp.obj[19].worldX = 9 * gp.tileSize;
        gp.obj[19].worldY = 51 * gp.tileSize;

        gp.obj[20] = new OBJ_BrokenGlass();
        gp.obj[20].worldX = 4 * gp.tileSize;
        gp.obj[20].worldY = 34 * gp.tileSize;

        gp.obj[21] = new OBJ_ForbiddenBeans();
        gp.obj[21].worldX = 48 * gp.tileSize;
        gp.obj[21].worldY = 58 * gp.tileSize;

        gp.obj[22] = new OBJ_ITS();
        gp.obj[22].worldX = 36 * gp.tileSize;
        gp.obj[22].worldY = 6 * gp.tileSize;

        gp.obj[23] = new OBJ_Wingams();
        gp.obj[23].worldX = 1 * gp.tileSize;
        gp.obj[23].worldY = 58 * gp.tileSize;

    }
}
