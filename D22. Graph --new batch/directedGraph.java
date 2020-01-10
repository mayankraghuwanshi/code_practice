import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
class main{
    static class Edge{
        int val;
        int weight;
        Edge(int val , int weight){
            this.val=val;
            this.weight=weight;
        }
    }
    static ArrayList<Edge> graph[] = new ArrayList[8];
    static void initGraph(){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
    }
    static void display(){
        for(int i=0;i<graph.length;i++){
            System.out.print(i+"->");
            for(Edge ver : graph[i]){
                System.out.print("("+ver.val+"|"+ver.weight+"), ");
            }
            System.out.println();
        }
    }
    static void addEdge(int src , int des , int weight , boolean directed){
        if(isValid(src , des)){
            graph[src].add(new Edge(des,weight));
            if(directed){
                graph[des].add(new Edge(src,weight));
            }
        }
    }
    static boolean isValid(int src , int des){
        if(src>=0 && src<graph.length && des>=0 && des<graph.length) return true;
        return false;
    }
    // static void DFS(int src , boolean isDone[] , Stack<Integer> stack){
    //     if(graph[src].size()==0) {
    //         stack.push(src);
    //         return;
    //         }
    //     isDone[src]=true;
    //     for(int i=0;i<graph[src].size();i++){
    //         if(!isDone[graph[src].get(i).val]){
    //             isDone[graph[src].get(i).val]=true;
    //             DFS(graph[src].get(i).val,isDone,stack);
    //             if(!isDone[graph[src].get(i).val]){
    //                 stack.push(graph[src].get(i).val);
    //             }
    //         }
    //         stack.push(src);
            
    //     }
    // }
    // static void topologicalSort(){
    //     boolean isDone[] = new boolean[7];
    //     Stack<Integer> stack = new Stack<>();
    //     for(int i=0;i<graph.length;i++){
    //         if(!isDone[i]){
    //             DFS(i,isDone,stack);
    //         }
    //     }
    //     while(stack.size()>0){
    //         System.out.print(stack.pop()+"->");
    //     }
    //     System.out.println();
    // }

    static void topologicalSort(int src, boolean isDone[] , Stack<Integer> stack){
        isDone[src]=true;
        for(Edge ver : graph[src]){
            if(!isDone[ver.val]){
                isDone[ver.val]=true;
                topologicalSort(ver.val,isDone,stack);
            }
        }
        stack.add(src);
    }
    static void topologicalSort(){
        boolean isDone[] = new boolean[8];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!isDone[i]){
                topologicalSort(i,isDone,stack);
            }
        }
        while(stack.size()>0){
            System.out.print(stack.pop()+"->");
        }
        System.out.println();
        
    }

    static void incomingEdges(int arr[]){
        for(int i=0;i<graph.length;i++){
            for(Edge ver : graph[i]){
                arr[ver.val]++;
            }
        }
    }
    static void khannsAlgo(){
        int arr[] = new int[8];
        Queue<Integer> queue = new LinkedList<>();
        incomingEdges(arr);
        for(int i=0;i<arr.length;i++){
            int item = arr[i];
            if(item==0){
                queue.add(i);
            }
        }
        // System.out.println(Arrays.toString(arr));
        while(queue.size()>0){
            int item = queue.peek();
            queue.remove();
            System.out.print(item+"->");
            for(Edge ver : graph[item]){
                arr[ver.val]--;
                if(arr[ver.val]==0){
                    queue.add(ver.val);
                }
            }
        }
        System.out.println();
    }
    //bellmenford
    //flowdwarshalzxc
    static void solve(int src , boolean isDone[] , ArrayList<Integer)

    public static void main(String args[]){
        initGraph();
        addEdge(1,0,10,false);
        addEdge(2,1,10,false);
        addEdge(3,1,10,false);
        addEdge(5,4,40,false);
        addEdge(5,2,2,false);
        addEdge(6,4,2,false);
        addEdge(6,3,3,false);
        addEdge(7,5,3,false);
        addEdge(7,6,3,false);
        // addEdge(5,6,8,false);
        topologicalSort();
        // display();
        khannsAlgo();
    }
}