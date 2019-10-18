import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.component.DuplicateRemover;

public class NothingDuplicateRemover implements DuplicateRemover {


    @Override
    public boolean   isDuplicate(Request request, Task task)
    {
        return  false;
    }

    @Override
    public void resetDuplicateCheck(Task task) {

    }

    @Override
    public int getTotalRequestsCount(Task task) {
        return 0;
    }

}
