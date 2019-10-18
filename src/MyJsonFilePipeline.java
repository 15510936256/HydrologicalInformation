import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import static us.codecraft.webmagic.utils.FilePersistentBase.PATH_SEPERATOR;

public class MyJsonFilePipeline implements Pipeline
{
    public String path = "";

    public MyJsonFilePipeline() {
        this.setPath("/data/webmagic");
    }

    public  void setPath( String path)
    {
        this.path = path;
    }

    public MyJsonFilePipeline(String path) {
        this.setPath(path);
    }

    public void process(ResultItems resultItems, Task task) {
        String path = this.path ;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day  = calendar.get(Calendar.DATE) ;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String time = ""+ year + month + day + hour + minute;
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter( new File(path +"\\" + time  + ".json")));
            printWriter.write(JSON.toJSONString(resultItems.get("json")));
            printWriter.close();
        } catch (IOException var5) {
             var5.printStackTrace();
        }

    }

}
