package com.multi.frame;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

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

