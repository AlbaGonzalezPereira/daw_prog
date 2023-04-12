package tests;

import utils.MiQueue;

public class QueueTest {
    public static void main(String[] args) {
        MiQueue<String> queue=new MiQueue();
       
        System.out.println("ELEMENTOS EN QUEUE: "+queue.size());
        System.out.println("Engadindo strings de 1 a 5");
        queue.offer("String 1");
        queue.offer("String 2");
        queue.add("String 3");
        queue.add("String 4");
        queue.add("String 5");
        System.out.println("ELEMENTOS EN QUEUE: "+queue.size());
        System.out.println("\nObtido: "+queue.peek());
        System.out.println("ELEMENTOS EN QUEUE: "+queue.size());
        System.out.println("\nExtraido: "+queue.poll());
        System.out.println("ELEMENTOS EN QUEUE: "+queue.size());
        System.out.println("\nExtraido: "+queue.poll());
        System.out.println("ELEMENTOS EN QUEUE: "+queue.size());
        System.out.println("\nResto de elementos: ");
        for(String s:queue) System.out.println("Extraido: "+s);
        System.out.println("ELEMENTOS EN QUEUE: "+queue.size());
        System.out.println("\nEngadindo Strings 1 e 2");
        queue.offer("String 1");
        queue.offer("String 2");
        System.out.println("ELEMENTOS EN QUEUE: "+queue.size());
        System.out.println("\nEliminando string: "+queue.peek());
        queue.remove();
        System.out.println("Obtido: "+queue.peek());
        System.out.println("ELEMENTOS EN QUEUE: "+queue.size());
        System.out.println("\nExtraido: "+queue.poll());
        System.out.println("ELEMENTOS EN QUEUE: "+queue.size());
        
        try {
            queue.add(null);
        } catch(Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
