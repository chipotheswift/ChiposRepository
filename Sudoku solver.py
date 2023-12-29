
# Author: Chipo Sekabanja
# Description: This program takes any sudoku board and solves it using a backtracking algorithm 

puzzle = [

   [0, 2, 0, 6, 0, 8, 0, 0, 0],
   
   [5, 8, 0, 0, 0, 9, 7, 0, 0],
   
   [0, 0, 0, 0, 4, 0, 0, 0, 0],
   
   [3, 7, 0, 0, 0, 0, 5, 0, 0],
   
   [6, 0, 0, 0, 0, 0, 0, 0, 4],
   
   [0, 0, 8, 0, 0, 0, 0, 1, 3],
   
   [0, 0, 0, 0, 2, 0, 0, 0, 0],
   
   [0, 0, 9, 8, 0, 0, 0, 3, 6],
   
   [0, 0, 0, 3, 0, 6, 0, 9, 0]

        ]

#takes the array and provides a visual representation of a sudoku board 
def print_board(board):
    
    for i in range(len(board)):
        # 
        print("\n")
        if i % 3 == 0 and i!=0:
            #after every third row print line
            print("- - - - - - - - - - - -  \n")
        for j in range(len(board[0])):
            if j % 3 == 0 and j != 0  :
                #place horizontal line after each third value
                print(" | ", end="")
            if j == 0:
                    print(board[i][j], end = " ")
            else:
                print(str(board[i][j])+ " ",end ="")


#makes sure that there is no repeated value in the column or row
def is_valid_move(board, row, col, num):
     
        for i in range(len(board)):
                #check the same column value for each row 
                if board[i][col] == num:
                        return False
        

        for i in range(len(board)): 
                #check each column value for the same row
                if board[row][i] == num:
                        return False
                
#makes sure there is no repeated value inside the 3 x 3 section                 
        #gets the top left corner value
        left_most_point = row - (row % 3)
        top_most_point = col - (col % 3)

        #checks the 9 values in the sudoku section starting at the top left corner
        for i in range(3):
                for j in range(3):
                        if(board[left_most_point + i][top_most_point + j]) == num:
                                return False
                        
        return True

# replaces the zeros with valid values
def solve(board, row, col):

        if col == 9:
                if row == 8:
                        return True
                #new row first column of that row
                row += 1
                col = 0
        #if there is a value, go to the next slot in that row
        if board[row] [col] !=  0:
                return solve(board, row,col+1)
        
        for num in range(1,10):
                #if the value isnt repeated - keep it
                if is_valid_move(board,row,col,num):
                        board[row][col] = num
                        #repeat these steps for the next value in the same row
                        if solve(board, row,col+1):
                                return True
                        
                #no possible solution found set it to zero
                board[row][col] = 0

        return False


#prints the original board and 
def print_solution(board):

        print_board(board)
        
        if solve(board, 0, 0):
                print("\n\n\n============================")
                print("\n      SOLVED BOARD")
                print( "\n============================")

                print_board(board)

        else:
                print()
                print("\n\n\n============================")
                print("\n      NO SOLUTION FOUND")
                print( "\n============================")

def main():
        print_solution(puzzle)

main()

# NEXT STEP - build a GUI to visualize the process
