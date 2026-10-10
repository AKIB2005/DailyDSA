class Solution {
public:
    bool isValid(string s) {
        stack<char> open_brackets;
        
        for (char c : s) {
            switch (c) {
                // If it's an opening bracket, push it onto the stack
                case '(': 
                case '[': 
                case '{': 
                    open_brackets.push(c); 
                    break;
                
                // If it's a closing bracket, check the top of the stack
                case ')':
                    if (open_brackets.empty() || open_brackets.top() != '(') return false;
                    open_brackets.pop();
                    break;
                case ']':
                    if (open_brackets.empty() || open_brackets.top() != '[') return false;
                    open_brackets.pop();
                    break;
                case '}':
                    if (open_brackets.empty() || open_brackets.top() != '{') return false;
                    open_brackets.pop();
                    break;
                
                default: 
                    break;
            }
        }
        
        // If the stack is empty, all brackets matched perfectly
        return open_brackets.empty();
    }
};
