import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import java.util.ArrayList;
import java.util.List;

public class InformationPageProcessor implements PageProcessor {

    private  Site site = Site.me().setRetryTimes(3).setSleepTime(1000 * 3600);
    @Override
    public  void process(Page page)
    {


        String html = page.getJson().toString();
        List<String> te = new ArrayList<>() ;
        te. add("http://123.127.175.45:8082/ajax/GwtWaterHandler.ashx?Method=SelectRealData");
        page.putField("json" , html);
        page.addTargetRequests(te);


    }

    @Override
    public Site getSite()
    {
        return site;
    }


    public static void main(String [] args)
    {
        Spider.create(new InformationPageProcessor()).setScheduler(new QueueScheduler().setDuplicateRemover(new NothingDuplicateRemover())).addUrl("http://123.127.175.45:8082/ajax/GwtWaterHandler.ashx?Method=SelectRealData").addPipeline(new MyJsonFilePipeline("D:\\resultjson")).thread(1).run();

    }
}
