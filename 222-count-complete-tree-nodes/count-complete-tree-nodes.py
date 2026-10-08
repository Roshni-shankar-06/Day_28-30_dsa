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
      
