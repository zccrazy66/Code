package meituan.bin;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 林松斌的船 on 2020/8/15.
 */


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