import java.io.*;
import java.util.*;

public class Graph
   {
     //Number Of Vertecies
       private int V;
       private LinkedList<Vertex>adj[];
       Graph(int v)
       {
           V=v;
           adj = new LinkedList[V];
           for (int i=0; i<v; ++i)
               adj[i] = new LinkedList<Vertex>();
       }
       public void addEdge(int u, int v ,String s)
       {
           Vertex node = new Vertex(v ,s);
           adj[u].add(node);// Add v to u's list
       }

       // A recursive function used by shortestPath.
       // See below link for details
       public void topologicalSortUtil(int v, Boolean visited[], Stack stack)
       {
           // Mark the current node as visited.
           visited[v] = true;
           Integer i;

           // Recur for all the vertices adjacent to this vertex
           Iterator<Vertex> it = adj[v].iterator();
           while (it.hasNext())
           {
               Vertex node =it.next();
               if (!visited[node.getValue()]){
                   topologicalSortUtil(node.getValue(), visited, stack);
                 }
           }
           // Push current vertex to stack which stores result
           stack.push(new Integer(v));
       }

       public void findCycles(){
          Stack stack = new Stack();
          int dist[] = new int[V];

          // Mark all the vertices as not visited
          Boolean visited[] = new Boolean[V];
          for (int i = 0; i < V; i++) {
              visited[i] = false;
            }
          // Call the recursive helper function to store Topological
          // Sort starting from all vertices one by one
          for (int i = 0; i < V; i++){
              if (visited[i] == false){
                  topologicalSortUtil(i, visited, stack);
                }
          }
          while(!stack.empty()){
            stack.pop();
          }
        }
      }

  //Adapted From https://www.geeksforgeeks.org/topological-sorting/
