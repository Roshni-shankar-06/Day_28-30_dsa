class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        # Calculate the leftmost height
        left_height = 0
        left_node = root
        while left_node:
            left_height += 1
            left_node = left_node.left
            
        # Calculate the rightmost height
        right_height = 0
        right_node = root
        while right_node:
            right_height += 1
            right_node = right_node.right
            
        # If the heights are equal, it's a perfect binary tree
        if left_height == right_height:
            return (1 << left_height) - 1  # Equivalent to 2^left_height - 1
            
        # If they are not equal, recurse on left and right subtrees
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)
