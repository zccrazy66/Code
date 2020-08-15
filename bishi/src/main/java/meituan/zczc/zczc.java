package meituan.zczc;

import meituan.zczc.WorkflowNode;

import java.util.*;
import java.util.stream.Collectors;



public class zczc
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext())
        {
            WorkflowNode node = WorkflowNode.load(cin.next());
            System.out.println(solution(node));
        }
    }
    private static int solution(WorkflowNode node){
        List<WorkflowNode> list = node.nextNodes;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            WorkflowNode workflowNode = list.get(i);
            max = Math.max(max,workflowNode.timeoutMillis);
            if (workflowNode.nextNodes != null){
                max = Math.max(max,solution(workflowNode));
            }
        }
        return max;
    }




}