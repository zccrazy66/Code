package 笔试.jungel.huawei;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class First {
    private static class Child{
        int num;
        int index;
        int color;

        public Child(int num, int index, int color) {
            this.num = num;
            this.index = index;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Child{" +
                    "num=" + num +
                    ", index=" + index +
                    ", color=" + color +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<Child> list1 = new LinkedList<>();
        List<Child> list2 = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            int color = scanner.nextInt();
            if (color==1){
                list1.add(new Child(num,i,1));
            }else {
                list2.add(new Child(num,i,2));
            }
        }


        if (list1.size()<3&&list2.size()<3) {
            System.out.println("null");
            return;
        }

        Collections.sort(list1, (o1, o2) -> o2.num-o1.num);
        Collections.sort(list2, (o1, o2) -> o2.num-o1.num);

        LinkedList<TreeSet<Child>> res =dfs(list1,list2);

        if (res.size()==0) {
            System.out.println("null");
            return;
        }

        Collections.sort(res, Comparator.comparingInt(o -> o.first().index));
        TreeSet<Child> children = res.removeFirst();

        System.out.println(JSON.toJSONString(children));
        PriorityQueue<Child> queue = new PriorityQueue<>((o1, o2) -> o2.num-o1.num);
        for (Child child : children) {
            System.out.println(child.num+","+child.index);
            queue.add(child);
        }

        int sum=0;
        int color = 1;
        while (queue.size()!=0) {
            Child remove = queue.remove();
            sum = sum+remove.num;
            System.out.print(remove.index+1+" ");

            color=remove.color;

        }
        System.out.println();
        System.out.println(color);
        System.out.println(sum);

    }

    private static LinkedList<TreeSet<Child>> dfs(List<Child> list1,List<Child> list2) {

        int maxList1=0;
        int maxList2=0;
        int m = list1.size();
        if (m>=3) {
            maxList1=list1.get(0).num+list1.get(1).num+list1.get(2).num;
        }
        int n = list2.size();
        if (n>=3) {
            maxList2=list2.get(0).num+list2.get(1).num+list2.get(2).num;
        }
        LinkedList<TreeSet<Child>> linkedList = new LinkedList<>();
        if (m>=3) {
            for (int i = 0; i < m; i++) {
                for (int j = i+1; j < m; j++) {
                    for (int k = j+1; k < m; k++) {

                        Child child1 = list1.get(i);
                        Child child2 = list1.get(j);
                        Child child3 = list1.get(k);

                        int sum = child1.num+child2.num+child3.num;

                        if (sum>=find(list1,i,j,k)) {
                            if (sum>=maxList2) {
                                TreeSet<Child> children = new TreeSet<>(Comparator.comparingInt(o -> o.index));
                                children.add(list1.get(i));
                                children.add(list1.get(j));
                                children.add(list1.get(k));

                                linkedList.addLast((TreeSet<Child>) children.clone());
                            }


                        }else {
                            break;
                        }
                    }
                }
            }
        }

        if (n>=3) {
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    for (int k = j+1; k < n; k++) {

                        Child child1 = list2.get(i);
                        Child child2 = list2.get(j);
                        Child child3 = list2.get(k);

                        int sum = child1.num+child2.num+child3.num;

                        if (sum>=find(list2,i,j,k)) {
                            if (sum>=maxList1) {
                                TreeSet<Child> children = new TreeSet<>(Comparator.comparingInt(o -> o.index));
                                children.add(list2.get(i));
                                children.add(list2.get(j));
                                children.add(list2.get(k));

                                linkedList.addLast((TreeSet<Child>) children.clone());
                            }


                        }else {
                            break;
                        }
                    }
                }
            }
        }

        return linkedList;
    }

    /**
     * 找出此时的最大3数的和
     */
    private static int find(List<Child> list,int x,int y,int z) {

        int i = 0;
        int sum = 0;
        int size = list.size();
        for (int j = 0; j < size; j++) {
            if (j!=x&&j!=y&&j!=z) {
                sum =sum+list.get(j).num;
                i++;
            }
            if (i==3) break;
        }

        return sum;
    }
}
