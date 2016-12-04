package Sjsu.Aye.cs146.project3;

import java.util.ArrayList;
import java.util.Random;

public class Maze {

	// private final int MAX_VERTS = 4;//this is tempory to test stuff
	private int size;
	private Stack thestack;
	int TotalCells;// used to count the number of cells in the matrix
	int VisitedCells = 1;// might have to change to 0
	private Node[][] maze;
	private Node currentCell;
	private Random rand;

	public Maze(int size) {
		this.size = size;
		maze = new Node[size][size];// Node type 2d array
		TotalCells = size * size;
		// System.out.println("in Graph nVerts is: " + nVerts);

		for (int j = 0; j < size; j++) {
			for (int k = 0; k < size; k++) { // matrix to 0
				Node n = new Node('a', j, k);

				maze[j][k] = n; // some dummy label if needed
				// System.out.println("maze[j][k] is " + maze[j][k].label);
			}
		}
		// System.out.println("for loop done here, n.row is " + n.row );
	}

	private ArrayList<Node> getNeighbor(Node n) {

		ArrayList<Node> neighbors = new ArrayList<Node>();

		int r = n.row;
		int c = n.col;

		if (r > 0) { // has north
			if (!maze[r - 1][c].hasEast() && !maze[r - 1][c].hasWest() && !maze[r - 1][c].hasSouth()
					&& !maze[r - 1][c].hasNorth()) {
				neighbors.add(maze[r - 1][c]);
				System.out.println("neighbors is " + "[" + (r - 1) + "]" + "[" + c + "]");
			}
		}
		if (r < size - 1) { // has south
			if (!maze[r + 1][c].hasEast() && !maze[r + 1][c].hasWest() && !maze[r + 1][c].hasSouth()
					&& !maze[r + 1][c].hasNorth()) {
				neighbors.add(maze[r + 1][c]);
				System.out.println("neighbors is " + "[" + (r + 1) + "]" + "[" + c + "]");
			}
		}
		if (c > 0) { // has west
			if (!maze[r][c - 1].hasEast() && !maze[r][c - 1].hasWest() && !maze[r][c - 1].hasSouth()
					&& !maze[r][c - 1].hasNorth()) {
				neighbors.add(maze[r][c - 1]);
				System.out.println("neighbors is " + "[" + r + "]" + "[" + (c - 1) + "]");

			}
		}
		if (c < size - 1) { // has east

			if (!maze[r][c + 1].hasEast() && !maze[r][c + 1].hasWest() && !maze[r][c + 1].hasSouth()
					&& !maze[r][c + 1].hasNorth()) {
				neighbors.add(maze[r][c + 1]);
				System.out.println("neighbors is " + "[" + r + "]" + "[" + (c + 1) + "]");
			}
		}

		// for (int i =0; i <neighbors.size();i++){
		// System.out.println("["+neighbors.get(i).row+","+neighbors.get(i).col+"]");
		// }

		return neighbors;

	}

	public void dfsGenerate() {
		currentCell = maze[0][0];// (dummy node)start node as current node
		// System.out.println(" This");
		// System.out.println("size is " + size);
		// System.out.println("currentCell.lable is " + currentCell.label);
		//
		// System.out.println(" currentCell.row in getNeighbor is " +
		// currentCell.row);
		// System.exit(0);
		while (VisitedCells < TotalCells) {
			// System.out.println(" Visited Cells is " + VisitedCells);
			// System.out.println(" TotalCells is " + TotalCells);
			if ((currentCell.row == (size - 1)) && (currentCell.col == (size - 1)))
				break;
			ArrayList<Node> neighbors = this.getNeighbor(currentCell);
			// System.out.print("Neighbor size: "+neighbors.size());

			// System.out.println(" Visited Cells update is " +
			// VisitedCells);
			if (neighbors.size() > 0) {
				rand = new Random();
				int index = rand.nextInt(neighbors.size());
				Node mySelectedNeighbor = neighbors.get(index);
				System.out.println("Chosen index is " + index);

				if ((currentCell.row + 1) == mySelectedNeighbor.row && currentCell.col == mySelectedNeighbor.col) { // this
																													// is
																													// south
					System.out.println("[" + currentCell.row + "," + currentCell.col + "] -->[" + mySelectedNeighbor.row
							+ "," + mySelectedNeighbor.col + "]");
					currentCell.setSouth(mySelectedNeighbor);
					currentCell.adjList.add(mySelectedNeighbor);
					mySelectedNeighbor.setNorth(currentCell);
					mySelectedNeighbor.adjList.add(currentCell);
					currentCell = mySelectedNeighbor;
					VisitedCells++;
					// System.exit(0);
				}

				else if ((currentCell.row - 1) == mySelectedNeighbor.row && currentCell.col == mySelectedNeighbor.col) { // this
																															// is
																															// North
					System.out.println("[" + currentCell.row + "," + currentCell.col + "] -->[" + mySelectedNeighbor.row
							+ "," + mySelectedNeighbor.col + "]");
					currentCell.setNorth(mySelectedNeighbor);
					currentCell.adjList.add(mySelectedNeighbor);
					mySelectedNeighbor.setSouth(currentCell);
					mySelectedNeighbor.adjList.add(currentCell);
					currentCell = mySelectedNeighbor;
					VisitedCells++;
				}

				else if ((currentCell.col + 1) == mySelectedNeighbor.col && currentCell.row == mySelectedNeighbor.row) { // this
																															// is
																															// east
					System.out.println("[" + currentCell.row + "," + currentCell.col + "] -->[" + mySelectedNeighbor.row
							+ "," + mySelectedNeighbor.col + "]");
					currentCell.setEast(mySelectedNeighbor);
					currentCell.adjList.add(mySelectedNeighbor);
					mySelectedNeighbor.setWest(currentCell);
					mySelectedNeighbor.adjList.add(currentCell);
					currentCell = mySelectedNeighbor;
					VisitedCells++;
					// System.exit(0);
				}

				else if ((currentCell.col - 1) == mySelectedNeighbor.col && currentCell.row == mySelectedNeighbor.row) { // this
																															// is
																															// west
					System.out.println("[" + currentCell.row + "," + currentCell.col + "] -->[" + mySelectedNeighbor.row
							+ "," + mySelectedNeighbor.col + "]");
					currentCell.setWest(mySelectedNeighbor);
					currentCell.adjList.add(mySelectedNeighbor);
					mySelectedNeighbor.setEast(currentCell);
					mySelectedNeighbor.adjList.add(currentCell);
					currentCell = mySelectedNeighbor;
					VisitedCells++;
				} else {
					System.out.println("Done");
					System.exit(0);
				}
				// System.out.println("indes is " + index);
				// System.out.println("In dfsGenerate row and coloum " +
				// currentCell.row + "and " + currentCell.col);
			}

		}

	}

	// just test methods

}
