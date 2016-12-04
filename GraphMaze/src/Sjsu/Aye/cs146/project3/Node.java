package Sjsu.Aye.cs146.project3;
/******* Vertex Class *******/
import java.util.ArrayList;
import java.util.LinkedList;
public class Node{
	public boolean wasVisited;
	public char label;
	public Node east;
	public Node west;
	public Node south;
	public Node north;
	public int row;
	public int col;
	
    public LinkedList<Node> adjList = new LinkedList<Node>();
    
    public Node (char l, int r, int c){
        label = l;
        wasVisited = false;
        this.east = null;
        this.west = null;
        this.south = null;
        this.north = null;
        this.row = r;
        this.col = c;
    }
    
    public void setEast (Node n) {
    	this.east = n;
    }
    
    public void setWest (Node n) {
    	this.west = n;
    }
    public void setSouth (Node n) {
    	this.south = n;
    }
    public void setNorth (Node n) {
    	this.north = n;
    }
    public boolean hasEast() {
    	if (this.east == null) return false;
    	return true;
    }
    public boolean hasWest() {
    	if (this.west == null) return false;
    	return true;
    }
    public boolean hasNorth() {
    	if (this.north == null) return false;
    	return true;
    }
    public boolean hasSouth() {
    	if (this.south == null) return false;
    	return true;
    }
}//end Node class



