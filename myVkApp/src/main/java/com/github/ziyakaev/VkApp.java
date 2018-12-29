package com.github.ziyakaev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;



public class VkApp {
    private static final Logger logger = LogManager.getLogger(VkApp.class);
    private static final String userDataFile = "D:\\project\\vkApp\\testApp\\myVkApp\\LoginName.txt";

    public static void main(String[] args) throws IOException {
        AuthFileReader dsa = new TxtAuthFileReader(userDataFile);
        AuthVk authVk = dsa.getAuthVk(1);
        Utils.accessToken = authVk.getToken().getAccessToken();
        logger.info("token = {}", Utils.accessToken);
        User user = new User(Integer.toString(authVk.getToken().getUserId()), Utils.accessToken);
        Utils utils = new Utils();
        user.setGroups();
        DataGroups dataGroups = utils.delimitersForGroup(user.getGroups());
        dataGroups.createTextForHouse();
        dataGroups.createTextForOtherGroup();
        dataGroups.getBoardComment(dataGroups.getGroupToOther());


    }
}
