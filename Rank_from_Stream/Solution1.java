/* 
	Solution 1 
	
	Insert elements into a binary search tree. To find the rank of a number, we could do an in-order
	traversal, keeping a counter as we traverse. As we move left, the counter doesn't change since
	we are skipping nodes that are greater than the number. As we move right, we skip an amount of
	smaller elements in the left subtree. That number of elements will be added to the counter. The
	amount of elements in a subtree can be kept track of for each node as a node is added.
*/


/* 
	Time Complexity: The track method and the getRankOfNumber method will both operate in O(log N)
					on a balanced tree and O(N) on an unbalanced tree.
	Space Complexity: 
*/

RankNode root = null;

void track(int number){
	if(root == null){
		root = new RankNode(number);
	} else {
		root.insert(number);
	}
}

int getRankOfNumber(int number){
	return root.getRank(number);
}

public class RankNode {
	public int left_size = 0;
	public RankNode left, right;
	public int data = 0;
	public RankNode(int d){
		if(d <= data){
			if(left != null) left.insert(d);
			else left = new RankNode(d);
			left_size++;
		} else {
			if(right != null) right.insert(d);
			else right = new RankNode(d);
		}
	}

	public int getRank(int d){
		if(d == data){
			return left_size;
		} else if(d < data){
			if(left == null) return -1;
			else return left.getRank(d);
		} else {
			int right_rank = right == null ? -1 : right.getRank(d);
			if(right_rank == -1) return -1;
			else return left_size + 1 + right_rank;
		}
	}
}