package com.multi.frame;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 6.			noranbear		   First Creation
 *  
 *  2022. 7. 25.							admindir 삭제
 *
 * =========================================================
 */

public class Util {
   public static void saveFile(MultipartFile mf, String userdir) {
      byte [] data;
      String imgname = mf.getOriginalFilename();
      try {
         data = mf.getBytes();
         
         FileOutputStream userfo = 
               new FileOutputStream(userdir+imgname);
         userfo.write(data);
         userfo.close();
      }catch(Exception e) {
         
      }
      
   }
   
}

