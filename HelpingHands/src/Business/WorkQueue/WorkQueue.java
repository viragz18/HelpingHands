
package Business.WorkQueue;

import java.util.ArrayList;

public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<WorkRequest>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}