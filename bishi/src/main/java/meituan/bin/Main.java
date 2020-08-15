package meituan.bin;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 林松斌的船 on 2020/8/15.
 */
 class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);

        for (String nodeValue : value.split("\\|")) {
            String[] properties = nodeValue.split("\\`");
            WorkflowNode node = map.get(properties[0]);

            node.timeoutMillis = Integer.parseInt(properties[1]);
            node.initialised = true;

            // Check next nodes
            if (properties[2].equals("END")) {
                continue;
            }
            node.nextNodes = Arrays.stream(properties[2].split(","))
                    .map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));

            map.put(node.nodeId, node);
        }

        return head;
    }

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }

}

public class Main {
     int resmax=Integer.MIN_VALUE;
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        Main main=new Main();
        while (cin.hasNext()) {
            WorkflowNode node = WorkflowNode.load(cin.next());
            main.help(node,node.timeoutMillis);
        }
        System.out.println(main.resmax);


    }
    public void help(WorkflowNode workflowNode,int time){
            if (workflowNode.nextNodes==null){
                resmax=Math.max(resmax,time);
            }
            for (int i=0;i<workflowNode.nextNodes.size();i++){
                help(workflowNode.nextNodes.get(i),time+workflowNode.nextNodes.get(i).timeoutMillis);
            }
    }
}