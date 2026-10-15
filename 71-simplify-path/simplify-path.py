class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        
        # Split the path by '/' to isolate directory names and commands
        segments = path.split('/')
        
        for segment in segments:
            if segment == '..':
                # Go up one level by popping from the stack if it's not empty
                if stack:
                    stack.pop()
            elif segment == '.' or segment == '':
                # '.' means current directory, '' happens due to consecutive slashes '//'
                # In both cases, do nothing
                continue
            else:
                # Valid directory or file name (e.g., 'home', '...', 'file.txt')
                stack.append(segment)
        
        # Join elements with '/' and ensure it starts with a leading '/'
        return '/' + '/'.join(stack)
