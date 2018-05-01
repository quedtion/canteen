package com.example.canteen.utils;

import com.example.canteen.model.ResultCode;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class Common<T> {

    public void validateList(ResultCode<List<T>> resultCode, List<T> list){
        if(list.isEmpty()){
            resultCode.setRs(-350);
            resultCode.setMsg("数据库插入操作错误");
        }else{
            resultCode.setRs(1);
            resultCode.setValue(list);
        }
    }

    public String generateUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public String uploadFile(String fileLocation, Part part) throws IOException {

        InputStream ins = null;
        FileOutputStream fileOut = null;
        try {

            // 获得提交的文件名
            String filename =part.getSubmittedFileName();

            // 获得文件输入流
            ins = part.getInputStream();
            // 获得文件类型
            File file = new File(fileLocation + filename);

            fileOut = new FileOutputStream(file);
            byte[] buf = new byte[1024 * 8];
            while (true) {
                int read = 0;
                if (ins != null) {
                    read = ins.read(buf);
                }
                if (read == -1) {
                    break;
                }
                fileOut.write(buf, 0, read);
            }
            if (fileOut.getFD().valid() == true) {
                return filename;
            } else {
                System.out.println("获取文件失败");
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            ins.close();
            fileOut.close();
        }
        return "";
    }
}
